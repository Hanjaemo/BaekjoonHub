select p.product_code, sum(p.price * os.sales_amount) as sales from product as p join offline_sale as os
where p.product_id = os.product_id
group by p.product_code
order by sales desc, p.product_code asc