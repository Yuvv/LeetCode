SELECT a.student_id, a.student_name, c.subject_name,
  SUM(CASE WHEN b.student_id IS NULL THEN 0 ELSE 1 END) AS attended_exams
FROM Students a
  CROSS JOIN Subjects c
  LEFT JOIN Examinations b ON a.student_id=b.student_id AND b.subject_name = c.subject_name
GROUP BY a.student_id, c.subject_name
ORDER BY a.student_id, c.subject_name
;
