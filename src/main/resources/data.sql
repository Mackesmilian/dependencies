DROP ALL OBJECTS;

CREATE TABLE customers
(
    id          int     NOT NULL,
    name        varchar NOT NULL,
    address     varchar NOT NULL,
    dateOfBirth date    NOT NULL,
    email       varchar NOT NULL,
    statusFl    boolean NOT NULL
);

ALTER TABLE customers
    ADD PRIMARY KEY (id);

INSERT INTO customers (id, name, address, dateOfBirth, email, statusFl)
VALUES (1, 'Franz', 'Skreet 1', '1998-01-01', 'mail@gmail.com', true);
INSERT INTO customers (id, name, address, dateOfBirth, email, statusFl)
VALUES (2, 'Herbert', 'Strasse 1', '1990-01-01', 'mail1@gmail.com', true);
INSERT INTO customers (id, name, address, dateOfBirth, email, statusFl)
VALUES (3, 'Günther', 'Skreet 1', '1989-01-01', 'mail2@gmail.com', false);


CREATE TABLE financialProduct
(
    id       int     NOT NULL,
    name     varchar NOT NULL,
    code     varchar NOT NULL,
    interest decimal NOT NULL
);

ALTER TABLE financialProduct
    ADD PRIMARY KEY (id);

INSERT INTO financialProduct (id, name, code, interest)
VALUES (1, 'GameStop', 'GME', 124.56);
INSERT INTO financialProduct (id, name, code, interest)
VALUES (2, 'Apple', 'AAPL', 51.86);
INSERT INTO financialProduct (id, name, code, interest)
VALUES (3, 'Microsoft', 'MSFT', 69.42);

CREATE TABLE customerFinancialProduct
(
    id                 int     NOT NULL,
    balance            decimal NOT NULL,
    customerId         int     NOT NULL,
    financialProductId int     NOT NULL
);

ALTER TABLE customerFinancialProduct
    ADD FOREIGN KEY (customerId)
        REFERENCES customers(id);

ALTER TABLE customerFinancialProduct
    ADD FOREIGN KEY (financialProductId)
        REFERENCES financialProduct(id);

INSERT INTO customerFinancialProduct (id, balance, customerId, financialProductId)
VALUES (1, 12345, 1, 1);
INSERT INTO customerFinancialProduct (id, balance, customerId, financialProductId)
VALUES (2, 300000, 1, 2);
INSERT INTO customerFinancialProduct (id, balance, customerId, financialProductId)
VALUES (3, 700, 1, 3);
INSERT INTO customerFinancialProduct (id, balance, customerId, financialProductId)
VALUES (4, 150, 2, 3);
INSERT INTO customerFinancialProduct (id, balance, customerId, financialProductId)
VALUES (1, 350, 2, 2);