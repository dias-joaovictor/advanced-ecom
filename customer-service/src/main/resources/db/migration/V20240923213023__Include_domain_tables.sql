CREATE TABLE Address
(
    id         CHAR(36) PRIMARY KEY, -- UUID stored as CHAR(36)
    street     VARCHAR(100) NOT NULL,
    city       VARCHAR(100) NOT NULL,
    state      VARCHAR(50)  NOT NULL,
    postalCode VARCHAR(10)  NOT NULL
);

CREATE TABLE Customer
(
    id        CHAR(36) PRIMARY KEY, -- UUID stored as CHAR(36)
    firstName VARCHAR(50)  NOT NULL,
    lastName  VARCHAR(100) NOT NULL,
    email     VARCHAR(50)  NOT NULL,
    addressId CHAR(36),             -- Foreign key to Address table
    CONSTRAINT fk_address FOREIGN KEY (addressId) REFERENCES Address (id) ON DELETE CASCADE
);
