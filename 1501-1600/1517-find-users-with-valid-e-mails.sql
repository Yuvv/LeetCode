SELECT *
FROM Users
WHERE REGEXP_LIKE(mail, '^[a-zA-Z][\\w\.\-]*@leetcode\\.com$', 'c')
;