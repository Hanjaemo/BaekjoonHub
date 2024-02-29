select item_id, item_name, rarity from item_info
where item_id in (
    select t.item_id from item_tree as t
    join (select * from item_info
        where rarity = 'RARE') as i on t.parent_item_id = i.item_id)
order by item_id desc

