select c.aName Employee from (
    select a.Name aName, a.Salary aSalary, b.Salary bSalary
    from Employee a
    join Employee b
    on a.ManagerId = b.Id
    where a.ManagerId is not null) c
where c.aSalary > c.bSalary