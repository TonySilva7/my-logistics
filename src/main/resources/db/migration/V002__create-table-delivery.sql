CREATE TABLE delivery (
    id BIGINT NOT NULL AUTO_INCREMENT,
    client_id BIGINT NOT NULL,
    fee DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    orderDate DATETIME NOT NULL,
    deliveryDate DATETIME NOT NULL,

    name_recipient VARCHAR(60) NOT NULL,
    street_recipient VARCHAR(255) NOT NULL,
    number_recipient VARCHAR(30) NOT NULL,
    complement_recipient VARCHAR(60) NOT NULL,
    district_recipient VARCHAR(30) NOT NULL,

    PRIMARY KEY (id)
);

ALTER TABLE delivery ADD CONSTRAINT fk_delivery_client
    FOREIGN KEY (client_id) REFERENCES client (id);