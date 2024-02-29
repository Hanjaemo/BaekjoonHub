# 음식종류별로 즐겨찾기수가 가장 많은 식당

select r.food_type, r.rest_id, r.rest_name, r.favorites from rest_info as r
join (select food_type, max(favorites) as favorites from rest_info
group by food_type) as f on r.food_type = f.food_type and r.favorites = f.favorites
order by food_type desc