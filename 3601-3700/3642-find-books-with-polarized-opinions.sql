SELECT
    a.book_id, a.title, a.author, a.genre, a.pages,
    MAX(b.session_rating) - MIN(b.session_rating) AS rating_spread,
    ROUND(SUM(b.session_rating<=2 OR b.session_rating>=4)/COUNT(b.session_id), 2) AS polarization_score
FROM books AS a
    JOIN reading_sessions AS b
        ON a.book_id = b.book_id
GROUP BY a.book_id
HAVING
    COUNT(b.session_id) >= 5
    AND MIN(b.session_rating) <= 2
    AND MAX(b.session_rating) >= 4
    AND polarization_score >= 0.6
ORDER BY
    polarization_score DESC, title desc
;