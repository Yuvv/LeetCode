WITH three AS (
    SELECT a.id AS a_id, b.id AS b_id, c.id AS c_id
    FROM Stadium a
        JOIN Stadium b ON b.id = a.id-1
        JOIN Stadium c ON c.id = a.id+1
    WHERE a.people >= 100 AND b.people >= 100 AND c.people >= 100
)
SELECT *
FROM Stadium
WHERE id IN (
    SELECT a_id FROM three
    UNION
    SELECT b_id FROM three
    UNION
    SELECT c_id FROM three
)
ORDER BY visit_date
;