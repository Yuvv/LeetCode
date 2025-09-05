SELECT
    contest_id,
    ROUND(COUNT(*)*100/(select COUNT(*) FROM Users), 2) AS percentage
FROM Register
GROUP BY contest_id
ORDER BY percentage DESC, contest_id ASC
;