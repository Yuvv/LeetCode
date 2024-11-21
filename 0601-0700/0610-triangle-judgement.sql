SELECT x, y, z,
    CASE
        WHEN x+y>z AND x+z>y AND y+z>x AND ABS(x-y)<z AND ABS(x-z)<y AND ABS(y-z)<x THEN 'Yes'
        ELSE 'No'
    END AS triangle
FROM Triangle
;