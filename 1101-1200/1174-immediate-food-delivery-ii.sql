SELECT ROUND(SUM(order_date = delivery_date)*100/COUNT(*), 2) AS immediate_percentage
FROM (
    SELECT a.customer_id, a.order_date, a.customer_pref_delivery_date AS delivery_date
    FROM Delivery AS a
        JOIN (
            SELECT customer_id, MIN(order_date) AS min_order_date
            FROM Delivery
            GROUP BY customer_id
        ) AS b ON a.customer_id = b.customer_id AND a.order_date = b.min_order_date
) AS c
;