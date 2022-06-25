CREATE TABLE wallet(
  id SERIAL PRIMARY KEY,
  client_id INT NOT NULL,
  CONSTRAINT fk_client
      FOREIGN KEY(client_id)
	  REFERENCES client(id)
);