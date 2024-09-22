ALTER TABLE ProductData
    ADD COLUMN quantity INT NOT NULL default 0,
    ADD COLUMN enabled TINYINT NOT NULL default 1;