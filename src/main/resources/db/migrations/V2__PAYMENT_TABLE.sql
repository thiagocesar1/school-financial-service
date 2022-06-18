CREATE TABLE payment(
  id SERIAL PRIMARY KEY,
  date TIMESTAMP NOT NULL,
  type INT NOT NULL,
  status INT NOT NULL,
  value DECIMAL(65,2) NOT NULL,
  client_id INT NOT NULL,
  CONSTRAINT fk_client
      FOREIGN KEY(client_id)
	  REFERENCES client(id)
);