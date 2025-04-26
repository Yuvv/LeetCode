SELECT a.project_id, ROUND(SUM(b.experience_years)/COUNT(*), 2) AS average_years
FROM Project a
    JOIN Employee b on a.employee_id=b.employee_id
GROUP BY a.project_id
;
