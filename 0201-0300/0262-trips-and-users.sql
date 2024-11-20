SELECT
    a.request_at AS Day,
    ROUND(
        SUM(CASE WHEN a.status!='completed' THEN 1 ELSE 0 END)/COUNT(a.id),
        2
    ) AS 'Cancellation Rate'
FROM Trips AS a
    LEFT JOIN Users AS b ON a.client_id = b.users_id
    LEFT JOIN Users AS c ON a.driver_id = c.users_id
WHERE b.banned = 'No' AND c.banned = 'No'
    AND a.request_at >= '2013-10-01' AND a.request_at <= '2013-10-03'
GROUP BY a.request_at
;