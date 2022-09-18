SELECT a.name, SUM(IFNULL(b.distance, 0)) travelled_distance
FROM Users a
    LEFT JOIN Rides b
        ON a.id = b.user_id
GROUP BY a.id
ORDER BY travelled_distance desc, a.name
;
