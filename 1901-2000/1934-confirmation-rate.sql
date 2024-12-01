SELECT a.user_id, COALESCE(b.cr, 0.00) AS confirmation_rate
FROM Signups a LEFT JOIN (
    SELECT user_id, ROUND(SUM(CASE WHEN action='confirmed' THEN 1 ELSE 0 END)/COUNT(*), 2) AS cr
    FROM Confirmations
    GROUP BY user_id
) b on a.user_id=b.user_id
;