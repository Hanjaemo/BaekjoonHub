select j.flavor from first_half as f
join july as j on f.flavor = j.flavor
group by j.flavor
order by f.total_order + sum(j.total_order) desc
limit 3