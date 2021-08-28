-- schema:
--    Create table If Not Exists Scores (Id int, Score DECIMAL(3,2))

-- query:
SELECT S1.score, COUNT(S2.score) 'Rank'
FROM Scores S1
JOIN (
    SELECT DISTINCT score FROM Scores
) S2 ON S2.score >= S1.score
GROUP BY S1.Id
ORDER BY score DESC;