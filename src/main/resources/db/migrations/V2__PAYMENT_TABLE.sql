CREATE TABLE payment(
  id SERIAL PRIMARY KEY,
  date TIMESTAMP NOT NULL,
  type varchar(100) NOT NULL,
  status varchar(100) NOT NULL,
  value DECIMAL(65,2) NOT NULL,
  client_id INT NOT NULL,
  card_id INT,
  CONSTRAINT fk_client
      FOREIGN KEY(client_id)
	  REFERENCES client(id),
  CONSTRAINT fk_card
      FOREIGN KEY(card_id)
      REFERENCES card(id)
);