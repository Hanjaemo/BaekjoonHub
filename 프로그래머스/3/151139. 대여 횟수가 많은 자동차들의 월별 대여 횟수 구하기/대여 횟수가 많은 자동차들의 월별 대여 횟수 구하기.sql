# 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차들

with tmp as (select car_id from car_rental_company_rental_history
where year(start_date) = 2022 and month(start_date) between 8 and 10
group by car_id having count(*) >= 5)

select month(start_date) as month, car_id, count(car_id) as records from car_rental_company_rental_history
where car_id in (select car_id from tmp) and year(start_date) = 2022 and month(start_date) between 8 and 10
group by month(start_date), car_id having count(car_id) > 0
order by month, car_id desc