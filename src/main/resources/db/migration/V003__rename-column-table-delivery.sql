ALTER TABLE delivery
    CHANGE orderDate order_date DATETIME NOT NULL,
    CHANGE deliveryDate delivery_date DATETIME NOT NULL,
    MODIFY COLUMN complement_recipient VARCHAR(60) NULL;
