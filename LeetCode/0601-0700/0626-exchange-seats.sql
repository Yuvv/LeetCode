-- 交换座位
-- https://leetcode.com/problems/exchange-seats/description/

select a.id as id, b.student as student from seat a join seat b on b.id = a.id + 1 where a.id % 2 = 1
union
select a.id as id, b.student as student from seat a join seat b on b.id = a.id - 1 where a.id % 2 = 0
union
select id, student from (
    select a.id as id, a.student as student, b.id as bid from seat a left join seat b on (a.id + 1)^1 = b.id + 1 group by a.id having b.id is null
    ) as t
order by id;