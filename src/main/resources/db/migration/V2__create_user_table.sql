CREATE TABLE "user"(
id IDENTITY PRIMARY KEY,
login VARCHAR(200) NOT NULL,
password VARCHAR(200) NOT NULL,
authority VARCHAR(100) NOT NULL
);