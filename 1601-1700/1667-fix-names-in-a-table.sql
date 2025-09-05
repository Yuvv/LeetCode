SELECT user_id, CONCAT(UCASE(SUBSTR(name, 1, 1)), LCASE(SUBSTR(name, 2))) AS name
FROM Users
ORDER BY user_id
;