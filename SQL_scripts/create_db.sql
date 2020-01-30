#CREATE database finances;
USE finances;

CREATE TABLE operation_type ( 
		id INT UNSIGNED NOT NULL AUTO_INCREMENT,
		type TINYTEXT,
		income BOOL,
		CONSTRAINT operation_type PRIMARY KEY (id) );
		
CREATE TABLE finance_operation ( 
		daytime DATETIME,
		type_id INT UNSIGNED,
		value DECIMAL(10,2));

INSERT INTO operation_type 	(type, income)
	VALUES 	('salary', TRUE),
			('food', FALSE),
			('home_maintenance', FALSE),
			('entertainment', FALSE);
		
INSERT INTO finance_operation (daytime, type_id, value)
	VALUES 	('2020-01-05 18:00', 1, 1680.00),
			('2020-01-05 18:00', 2, 150.50),
			('2020-01-05 19:00', 3, 200.50),
			('2020-02-05 18:00', 2, 50.00);