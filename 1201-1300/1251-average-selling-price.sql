SELECT a.product_id, COALESCE(ROUND(SUM(a.price*b.units)/SUM(b.units), 2), 0) AS average_price
FROM Prices a
    LEFT JOIN UnitsSold b ON a.product_id=b.product_id AND b.purchase_date BETWEEN a.start_date AND a.end_date
GROUP BY a.product_id
;