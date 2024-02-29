with max_price as (
    select category, max(price) as price from food_product
    group by category)

select f.category, f.price, f.product_name from food_product as f
join max_price as m on f.category = m.category and f.price = m.price
where f.category in ('과자', '국', '김치', '식용유')
order by f.price desc