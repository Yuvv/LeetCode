SELECT patient_id, patient_name, conditions
FROM Patients
WHERE conditions like 'DIAB1%' or conditions like '% DIAB1%'
;