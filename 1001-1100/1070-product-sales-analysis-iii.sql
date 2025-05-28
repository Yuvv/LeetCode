-- ROW_NUMBER() is not allow....
-- SELECT
--     product_id, `year` AS first_year, quantity, price
-- FROM `Sales`
-- HAVING ROW_NUMBER() OVER (PARTITION BY product_id ORDER BY `year`) = 1
-- ;

SELECT
    a.product_id, b.first_year, a.quantity, a.price
FROM `Sales` AS a
    JOIN (
        SELECT
            product_id, MIN(`year`) AS first_year
        FROM `Sales`
        GROUP BY product_id
    ) AS b
        ON a.product_id = b.product_id AND a.`year` = b.first_year
;