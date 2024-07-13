-- Write your MySQL query statement below
SELECT customer_id
FROM (
    SELECT customer_id, count(distinct(product_key)) AS cnt
    FROM Customer
    GROUP BY customer_id
    HAVING cnt = (SELECT count(*) FROM Product)
) AS a
;
