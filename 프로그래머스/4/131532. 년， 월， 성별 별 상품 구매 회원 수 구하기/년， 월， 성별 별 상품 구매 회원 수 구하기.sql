select year(o.sales_date) as year, month(o.sales_date) as month, u.gender, count(distinct u.user_id) from user_info as u
join online_sale as o using(user_id)
where u.gender is not null
group by year(o.sales_date), month(o.sales_date), u.gender
order by year, month, u.gender