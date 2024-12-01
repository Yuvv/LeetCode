SELECT ROUND(SUM(a.tiv_2016), 2) AS tiv_2016
FROM Insurance AS a JOIN
(
    SELECT lat, lon
    FROM Insurance
    GROUP BY lat, lon
    HAVING count(*) = 1
) AS b ON a.lat=b.lat AND a.lon=b.lon JOIN
(
    SELECT tiv_2015
    FROM Insurance
    GROUP BY tiv_2015
    HAVING count(*)>1
) AS c ON a.tiv_2015 = c.tiv_2015
;