SELECT a.employee_id, a.name, b.reports_count, b.average_age
FROM Employees a
    JOIN (
        SELECT reports_to, COUNT(*) AS reports_count, ROUND(AVG(age)) AS average_age
        FROM Employees
        WHERE reports_to IS NOT NULL
        GROUP BY reports_to
    ) b on a.employee_id = b.reports_to
ORDER BY a.employee_id
;