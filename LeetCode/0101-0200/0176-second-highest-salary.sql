-- Write your MySQL query statement below
select
  case
    when (
      select distinct salary from employee order by salary desc limit 1 offset 1
    ) is null then null
    else (
      select distinct salary from employee order by salary desc limit 1 offset 1
    )
   end as SecondHighestSalary;