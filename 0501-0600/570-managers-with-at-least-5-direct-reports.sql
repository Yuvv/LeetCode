SELECT b.name
FROM (
    SELECT managerId
    FROM Employee
    GROUP BY managerId
    HAVING COUNT(*) >= 5
) a JOIN Employee b ON a.managerId = b.id
;