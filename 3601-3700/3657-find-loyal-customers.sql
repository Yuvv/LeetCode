SELECT customer_id
FROM customer_transactions
GROUP BY customer_id
HAVING SUM(transaction_type='purchase') >= 3
    -- AND MAX(transaction_date) - MIN(transaction_date) >= 30
    AND DATEDIFF(MAX(transaction_date), MIN(transaction_date)) >= 30
    AND SUM(transaction_type='refund')/COUNT(*) < 0.2
ORDER BY customer_id
;