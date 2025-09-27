SELECT a.product_name, SUM(b.unit) AS unit
FROM Products a JOIN Orders b
    ON a.product_id=b.product_id
WHERE b.order_date>='2020-02-01' AND b.order_date<'2020-03-01'
GROUP BY a.product_id
HAVING SUM(b.unit)>=100
;