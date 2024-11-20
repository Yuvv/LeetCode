SELECT *
FROM (
    SELECT a.name, b.bonus
    FROM Employee a
        LEFT JOIN Bonus b on a.empId = b.empId
) a
WHERE a.bonus IS NULL OR a.bonus < 1000
;
