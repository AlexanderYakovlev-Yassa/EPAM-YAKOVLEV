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
            ('car_maintenance', FALSE),
            ('community_association', FALSE),
            ('internet', FALSE);
		
INSERT INTO finance_operation (daytime, type_id, value)
	VALUES 	('2019-01-05 12:00', 1, 1680.00),
			('2019-01-05 18:00', 2, 150.50),
			('2019-01-05 19:00', 3, 180.50),
            ('2019-01-06 19:00', 3, 70.50),
            ('2019-01-30 19:00', 3, 90.00),
            ('2019-01-20 19:00', 6, 26.00),
            ('2019-01-20 19:00', 5, 180.00),
            ('2019-01-20 19:00', 2, 90.00),
			('2020-01-05 12:00', 1, 1680.00),
			('2020-01-05 18:00', 2, 150.50),
			('2020-01-05 19:00', 3, 200.50),
            ('2020-01-06 19:00', 3, 80.50),
            ('2020-01-30 19:00', 3, 100.00),
            ('2020-01-20 19:00', 6, 26.00),
            ('2020-01-20 19:00', 5, 200.00),
            ('2020-01-20 19:00', 2, 90.00),
			('2020-02-05 18:00', 2, 50.00);