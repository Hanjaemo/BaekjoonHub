select year(os.sales_date) as year, month(os.sales_date) as month, ui.gender, count(distinct ui.user_id) as users 
from user_info as ui join online_sale as os on ui.user_id = os.user_id
where gender is not null
group by year(os.sales_date), month(os.sales_date), gender
order by year, month, gender