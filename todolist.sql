CREATE TABLE todolist(
id INT AUTO_INCREMENT PRIMARY KEY,
description VARCHAR(255) NOT NULL,
status BOOLEAN DEFAULT FALSE
);

INSERT INTO todolist(description, status) VALUES
('Hacer la compra de comestibles', FALSE),
('Terminar el informe para el trabajo', TRUE),
('Hacer ejercicio por 30 minutos', FALSE);

SELECT * FROM todolist;