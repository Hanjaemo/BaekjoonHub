# 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 
# 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고 
# 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차

# with not_available as (
#     )

with not_available as (
    select * from car_rental_company_car as c
    join car_rental_company_rental_history as h using(car_id)
    where h.start_date <= '2022-11-30' and h.end_date >= '2022-11-1'
), plan as (
    select * from car_rental_company_discount_plan
    where car_type in ('세단', 'SUV') and duration_type = '30일 이상')

select distinct c.car_id, c.car_type, floor(c.daily_fee * 30 * (100-p.discount_rate)/100) as fee from car_rental_company_car as c
join car_rental_company_rental_history as h using(car_id)
join plan as p using(car_type)
where c.car_id not in (select car_id from not_available) and
    (c.daily_fee * 30) between 500000 and 2000000
order by fee desc, c.car_type asc, c.car_id desc