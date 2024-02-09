select history_id, car_id, date_format(start_date, '%Y-%m-%d'), date_format(end_date, '%Y-%m-%d'), if (datediff(end_date, start_date) + 1 >= 30, '장기 대여', '단기 대여') as rent_type from car_rental_company_rental_history
where year(start_date) = 2022 and month(start_date) = 9
order by history_id desc