CREATE TABLE card(
  id SERIAL PRIMARY KEY,
  numbers VARCHAR(16) NOT NULL,
  validation_code VARCHAR(10) NOT NULL,
  validation_date TIMESTAMP NOT NULL,
  owner_name VARCHAR(255) NOT NULL,
  type VARCHAR(100) NOT NULL,
  wallet_id INT NOT NULL,
  CONSTRAINT fk_wallet
      FOREIGN KEY(wallet_id)
	  REFERENCES wallet(id)
);