WITH cte AS (
    SELECT visited_on,
    SUM(amount) AS daily_amount
    FROM Customer
    GROUP BY visited_on
)
SELECT visited_on,
    SUM(daily_amount) OVER(ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) AS amount,
    ROUND(AVG(daily_amount) OVER(ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW), 2) AS average_amount
FROM cte
LIMIT 1000 OFFSET 6