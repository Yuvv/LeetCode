SELECT a.user_id AS buyer_id, a.join_date,
    COALESCE(b.orders_in_2019, 0) AS orders_in_2019
FROM Users a
    LEFT JOIN (
        SELECT buyer_id, COUNT(*) AS orders_in_2019
        FROM Orders
        WHERE order_date>='2019-01-01' AND order_date<'2020-01-01'
        GROUP BY buyer_id
    ) b ON a.user_id = b.buyer_id
;