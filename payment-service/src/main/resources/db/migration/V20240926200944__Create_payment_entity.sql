CREATE TABLE Payment
(
    id                  CHAR(36) PRIMARY KEY,
    orderId             CHAR(36)       NOT NULL,
    paymentProviderHash CHAR(50)       NOT NULL,
    amount              DECIMAL(19, 2) NOT NULL,
    status              VARCHAR(50)   NOT NULL,
    createdAt           TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt           TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);