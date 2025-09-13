SELECT a.product_id, a.new_price AS price
FROM Products a
    JOIN (
        SELECT product_id, MAX(change_date) AS max_date
        FROM Products
        WHERE change_date <= '2019-08-16'
        GROUP BY product_id
    ) b ON a.product_id = b.product_id AND a.change_date = b.max_date
UNION ALL
SELECT distinct product_id, 10 AS price
FROM Products
WHERE change_date > '2019-08-16' AND product_id NOT IN (
    SELECT product_id FROM Products WHERE change_date <= '2019-08-16'
)
;