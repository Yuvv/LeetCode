SELECT name
FROM SalesPerson
WHERE sales_id NOT IN (
    SELECT sales_id
    FROM Orders a
        JOIN Company b on a.com_id = b.com_id
    WHERE b.name = 'RED'
)
;