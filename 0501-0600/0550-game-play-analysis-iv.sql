# Write your MySQL query statement below
SELECT ROUND(
    COUNT(DISTINCT(b.player_id)) / COUNT(DISTINCT(a.player_id)),
    2
) AS fraction
FROM Activity a
    LEFT JOIN (
        SELECT player_id, MIN(event_date) AS min_date
        FROM Activity
        GROUP BY player_id
    ) b ON a.player_id = b.player_id AND a.event_date = DATE_ADD(b.min_date, INTERVAL 1 DAY)
;