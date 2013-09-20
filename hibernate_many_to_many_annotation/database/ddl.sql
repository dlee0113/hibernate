CREATE TABLE STOCK (
	STOCK_ID	NUMBER		NOT NULL,
	STOCK_CODE	VARCHAR(10)	NOT	NULL,
	STOCK_NAME	VARCHAR(20)	NOT	NULL,
	CONSTRAINT PK_STOCK_ID	PRIMARY KEY (STOCK_ID),
	CONSTRAINT STOCK_CODE UNIQUE (STOCK_CODE),
	CONSTRAINT STOCK_NAME UNIQUE (STOCK_NAME)
);

CREATE TABLE CATEGORY (
	CATEGORY_ID	NUMBER		NOT NULL,
	NAME		VARCHAR(10)	NOT NULL,
	DESCRIPTION	VARCHAR(255)	NOT NULL,
	CONSTRAINT PK_CATEGORY_ID PRIMARY KEY (CATEGORY_ID)
);

CREATE TABLE STOCK_CATEGORY (
	STOCK_ID	NUMBER	NOT NULL,
	CATEGORY_ID	NUMBER	NOT NULL,
	CONSTRAINT PK_STOCK_CATEGORY_ID PRIMARY KEY (STOCK_ID, CATEGORY_ID),
	CONSTRAINT FK_STOCK_ID FOREIGN KEY (STOCK_ID) REFERENCES STOCK(STOCK_ID),
	CONSTRAINT FK_CATEGORY_ID FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY(CATEGORY_ID)
);
