with tmp as (
    select category, max(price) as price from food_product
    group by category)

select p.category, p.price, p.product_name from food_product as p
join tmp as t on (p.category = t.category and p.price = t.price)
where p.category in ('과자', '국', '김치', '식용유')
order by p.price desc