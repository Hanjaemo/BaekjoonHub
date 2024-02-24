select a.author_id, a.author_name, b.category, sum(b.sales * b.price) as total_sales from author as a 
join (
    select b.book_id, b.category, b.author_id, b.price, bs.sales_date, bs.sales from book as b join book_sales as bs on b.book_id = bs.book_id where date_format(bs.sales_date, '%Y-%m-%d') like '2022-01%') as b on a.author_id = b.author_id
group by a.author_id, b.category
order by a.author_id, b.category desc