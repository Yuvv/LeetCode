CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  declare N_1 INT default N - 1;
  RETURN (
      select distinct Salary from Employee
      order by Salary desc limit N_1, 1
  );
END