select distinct(h.car_id) from car_rental_company_rental_history as h
join (
    select car_id from car_rental_company_car
    where car_type = '세단') as c on h.car_id = c.car_id
where month(h.start_date) = 10
order by h.car_id desc