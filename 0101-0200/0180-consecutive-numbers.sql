-- 找出连续的数字
-- https://leetcode.com/problems/consecutive-numbers/
select distinct a.Num as ConsecutiveNums
from `Logs` as a
  join `Logs` as b
    on (a.id = b.id and a.Num = b.Num)
      or (a.id = b.id - 1 and a.Num = b.Num)
      or (a.id = b.id - 2 and a.Num = b.Num)
group by a.id, a.Num
having count(*) >= 3