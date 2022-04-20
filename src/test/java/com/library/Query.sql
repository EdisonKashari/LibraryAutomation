select count(*) from book_borrow;

select count(*) from book_borrow where is_returned=0;


select bc.name,count(*) from book_borrow bb
                                 inner  join books b on bb.book_id = b.id
                                 inner join book_categories bc on b.book_category_id=bc.id
group by name
order by 2 desc;


select full_name,count(*) from users u inner join book_borrow bb on u.id = bb.user_id
group by full_name
order by 2 desc ;

select b.name, b.author,bc.name,b.year from books b
inner join book_categories bc on b.book_category_id = bc.id


where b.name='Chordeiles minor'

;

select name, author,year from books where name='Chordeiles minor';


select name from book_categories;
