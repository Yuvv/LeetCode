SELECT a.id, COUNT(a.id) AS num
FROM (
    SELECT requester_id AS id FROM RequestAccepted
    UNION ALL
    SELECT accepter_id AS id FROM RequestAccepted
) a
GROUP BY a.id
ORDER BY COUNT(a.id) DESC
LIMIT 1
;