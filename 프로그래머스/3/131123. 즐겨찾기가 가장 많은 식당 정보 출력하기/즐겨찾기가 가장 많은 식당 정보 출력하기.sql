select r2.food_type, r2.rest_id, r2.rest_name, r2.favorites from (
    select food_type, max(favorites) as favorites from rest_info
    group by food_type
) as r1 join rest_info as r2 on r1.food_type = r2.food_type and r1.favorites = r2.favorites
order by r2.food_type desc