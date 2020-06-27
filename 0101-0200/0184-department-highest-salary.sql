-- get max salary of each department
select DepartmentId, max(Salary) from Employee group by DepartmentId

-- just join
select d.Name as Department, e.Name as Employee, e.Salary
from Employee as e join Department as d on e.DepartmentId = d.Id
    join (select DepartmentId, max(Salary) MaxSalary from Employee group by DepartmentId) as c on c.DepartmentId = d.Id and c.MaxSalary = e.Salary
