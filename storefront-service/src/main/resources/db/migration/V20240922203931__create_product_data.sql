CREATE TABLE ProductData
(
    id          CHAR(36) PRIMARY KEY,
    sku         VARCHAR(13)  NOT NULL,
    description VARCHAR(100) NOT NULL,
    price       DECIMAL(10, 2),
    quantity    INT          NOT NULL,
    enabled     TINYINT      NOT NULL,
    createdAt   TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
    updatedAt   TIMESTAMP             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
