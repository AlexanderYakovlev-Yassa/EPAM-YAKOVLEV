SELECT*FROM operation_type;

SELECT*FROM finance_operation;

SELECT daytime, value FROM finance_operation;

SELECT daytime, value FROM finance_operation WHERE type_id = 3;

UPDATE operation_type
    SET type='internet'
    WHERE type='wi-fi';
    
UPDATE finance_operation
    SET value=80.50
    WHERE value=80.00;
    
DELETE FROM finance_operation
    WHERE type_id =3;    

SELECT t1.daytime, t2.type, t1.value FROM finance_operation AS t1, operation_type AS t2
  WHERE t1.type_id = t2.id
  ORDER BY t1.daytime;
  

    
