
SELECT t1.*
FROM
tablename	t1
where exists (
    SELECT count(*) + 1 FROM tablename t2 WHERE t2.type = t1.type AND t2.id > t1.id having (count(*) + 1) <= 3
)
ORDER BY t1.type



select t1.*
from person t1
where (select conut(*) + 1 from person t2 where t1.course = t2.course and t2.score > t1.score) <= 2
order by t1.course