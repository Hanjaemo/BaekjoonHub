with tmp as (select member_id, count(member_id) from rest_review
    group by member_id
    order by count(member_id) desc
    limit 1)

select m.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d') as review_date from member_profile as m 
join rest_review as r on m.member_id = r.member_id
where m.member_id = (select member_id from tmp)
order by review_date, r.review_text