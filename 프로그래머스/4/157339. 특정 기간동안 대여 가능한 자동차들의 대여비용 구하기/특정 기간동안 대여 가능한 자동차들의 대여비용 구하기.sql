# 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 
# 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고 
# 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차



with not_available as (
    select car_id from car_rental_company_rental_history
    where start_date <= '2022-11-30' and end_date >= '2022-11-01')

select c.car_id, c.car_type, floor((c.daily_fee * (100-discount_rate)/100) * 30) as fee from car_rental_company_car as c
join car_rental_company_discount_plan as p using(car_type)
where c.car_type in ('세단', 'SUV') and 
    c.car_id not in (select car_id from not_available) and
    p.duration_type = '30일 이상' and
    (c.daily_fee * (100-discount_rate)/100) * 30 between 500000 and 2000000
order by fee desc, c.car_type asc, c.car_id desc