SELECT book_id, title, author, genre, publication_year, current_borrowers
FROM (
    SELECT a.book_id, a.title, a.author, a.genre, a.publication_year, a.total_copies,
        COUNT(b.record_id) AS current_borrowers
    FROM library_books AS a JOIN borrowing_records AS b ON a.book_id=b.book_id
    WHERE b.return_date IS NULL
    GROUP BY a.book_id
    HAVING COUNT(b.record_id) = a.total_copies
) AS t
ORDER BY current_borrowers DESC, title ASC
;