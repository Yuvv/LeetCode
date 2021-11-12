-- blah blah blah

SELECT
    Department.id,
    jan_r.revenue AS Jan_Revenue,
    feb_r.revenue AS Feb_Revenue,
    mar_r.revenue AS Mar_Revenue,
    apr_r.revenue AS Apr_Revenue,
    may_r.revenue AS May_Revenue,
    jun_r.revenue AS Jun_Revenue,
    jul_r.revenue AS Jul_Revenue,
    aug_r.revenue AS Aug_Revenue,
    sep_r.revenue AS Sep_Revenue,
    oct_r.revenue AS Oct_Revenue,
    nov_r.revenue AS Nov_Revenue,
    dec_r.revenue AS Dec_Revenue
FROM Department
LEFT JOIN (
    SELECT id, revenue
    FROM Department
    WHERE month = 'Jan'
) jan_r ON Department.id = jan_r.id
LEFT JOIN (
    SELECT id, revenue
    FROM Department
    WHERE month = 'Feb'
) feb_r ON Department.id = feb_r.id
LEFT JOIN (
    SELECT id, revenue
    FROM Department
    WHERE month = 'Mar'
) mar_r ON Department.id = mar_r.id
LEFT JOIN (
    SELECT id, revenue
    FROM Department
    WHERE month = 'Apr'
) apr_r ON Department.id = apr_r.id
LEFT JOIN (
    SELECT id, revenue
    FROM Department
    WHERE month = 'May'
) may_r ON Department.id = may_r.id
LEFT JOIN (
    SELECT id, revenue
    FROM Department
    WHERE month = 'Jun'
) jun_r ON Department.id = jun_r.id
LEFT JOIN (
    SELECT id, revenue
    FROM Department
    WHERE month = 'Jul'
) jul_r ON Department.id = jul_r.id
LEFT JOIN (
    SELECT id, revenue
    FROM Department
    WHERE month = 'Aug'
) aug_r ON Department.id = aug_r.id
LEFT JOIN (
    SELECT id, revenue
    FROM Department
    WHERE month = 'Sep'
) sep_r ON Department.id = sep_r.id
LEFT JOIN (
    SELECT id, revenue
    FROM Department
    WHERE month = 'Oct'
) oct_r ON Department.id = oct_r.id
LEFT JOIN (
    SELECT id, revenue
    FROM Department
    WHERE month = 'Nov'
) nov_r ON Department.id = nov_r.id
LEFT JOIN (
    SELECT id, revenue
    FROM Department
    WHERE month = 'Dec'
) dec_r ON Department.id = dec_r.id
GROUP BY Department.id