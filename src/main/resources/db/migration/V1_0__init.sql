CREATE TABLE book(
   id SERIAL NOT NULL PRIMARY KEY,
   title VARCHAR (100),
   isbn VARCHAR (20),
   author VARCHAR (100),
   price NUMERIC(6, 2)
);

INSERT INTO book (title, isbn, author, price) values ('Pairing Apache Shiro and Java EE 7', '978-1-365-12404-4', 'Nebrass Lamouchi', 0);
INSERT INTO book (title, isbn, author, price) values ('Playing with Java Microservices on Kubernetes and OpenShift', '9782956428510', 'Nebrass Lamouchi', 9.18);