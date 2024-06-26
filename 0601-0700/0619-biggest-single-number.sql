SELECT num
FROM (
    SELECT num, count(*) AS cnt
    FROM MyNumbers
    GROUP BY num
    HAVING cnt = 1
    ORDER BY num DESC
    LIMIT 1
) a UNION (
    SELECT null
)
LIMIT 1
;