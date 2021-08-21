CREATE TABLE delivery (
  id UUID NOT NULL,
  customer_id UUID NOT NULL,
  rate DECIMAL(5, 2) NOT NULL,
  status VARCHAR(20) NOT NULL,
  delivery_date TIMESTAMP NOT NULL,
  finished_date TIMESTAMP,

  addressee_name VARCHAR(20) NOT NULL,
  addressee_street VARCHAR(255) NOT NULL,
  addressee_number VARCHAR(30) NOT NULL,
  addressee_complement VARCHAR(60),
  addressee_district VARCHAR(30) NOT NULL
);

ALTER TABLE delivery ADD CONSTRAINT pk_delivery
  PRIMARY KEY (id);

ALTER TABLE delivery ADD CONSTRAINT fk_delivery_customer
  FOREIGN KEY (customer_id) REFERENCES customer (id);
