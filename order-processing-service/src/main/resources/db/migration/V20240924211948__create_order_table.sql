CREATE TABLE Orders
(
    id                CHAR(36) PRIMARY KEY,
    customerId        CHAR(36) NULL,
    shippingAddressId CHAR(36)       NOT NULL,
    amount            DECIMAL(19, 2) NOT NULL,
    orderStatus       VARCHAR(30)    NOT NULL,
    createdAt         TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt         TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_shipping_address FOREIGN KEY (shippingAddressId) REFERENCES ShippingAddress (id)
);
