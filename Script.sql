--<ScriptOptions statementTerminator=";"/>

CREATE TABLE books_order (
	no INT NOT NULL,
	isbn VARCHAR(50),
	quantity INT,
	TS TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	PRIMARY KEY (no)
) ENGINE=InnoDB;

CREATE INDEX isbn ON books_order (isbn ASC);

ALTER TABLE books_order ADD CONSTRAINT books_order_ibfk_1 FOREIGN KEY (isbn)
	REFERENCES books (ISBN);

