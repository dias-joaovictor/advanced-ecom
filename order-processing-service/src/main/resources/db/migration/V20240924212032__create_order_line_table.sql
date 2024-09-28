CREATE TABLE OrderLine
(
    id         CHAR(36) PRIMARY KEY,
    sku        VARCHAR(13)    NOT NULL,
    price      DECIMAL(19, 2) NOT NULL,
    totalPrice DECIMAL(19, 2) NOT NULL,
    quantity   INT            NOT NULL,
    orderId    CHAR(36)       NOT NULL,
    createdAt  TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt  TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_order FOREIGN KEY (orderId) REFERENCES Orders (id) ON DELETE CASCADE
);
