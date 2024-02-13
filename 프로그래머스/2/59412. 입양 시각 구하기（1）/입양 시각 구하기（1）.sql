select hour(datetime) as hour, count(*) as count from animal_outs
group by hour(datetime) having hour between 9 and 20
order by hour