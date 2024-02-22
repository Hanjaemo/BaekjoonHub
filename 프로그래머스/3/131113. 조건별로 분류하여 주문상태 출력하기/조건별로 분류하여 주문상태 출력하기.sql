select order_id, product_id, date_format(out_date, '%Y-%m-%d'), 
    if (out_date <= '2022-5-1', '출고완료', if (out_date is null, '출고미정', '출고대기'))
from food_order
order by order_id asc