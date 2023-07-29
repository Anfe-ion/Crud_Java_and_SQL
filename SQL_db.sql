CREATE DATABASE proyecto_ebikes;
USE proyecto_ebikes;

CREATE TABLE usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombres VARCHAR(50) NOT NULL,
  apellidos VARCHAR(50) NOT NULL,
  cedula VARCHAR(10) NOT NULL,
  correo_electronico VARCHAR(100) NOT NULL,
  contrasena VARCHAR(100) NOT NULL
);

INSERT INTO usuarios (nombres, apellidos, cedula, correo_electronico, contrasena)
VALUES
  ('Marco', 'Rossi', '123456789', 'marco@hotmail.com', 'password123'),
  ('Alessia', 'Ferrari', '987654321', 'alessia@gmail.com', 'securepass'),
  ('Giovanni', 'Bianchi', '456789012', 'giovanni@hotmail.com', 'mypassword'),
  ('Isabella', 'Romano', '654321098', 'isabella@gmail.com', '123456'),
  ('Elena', 'Ricci', '789012345', 'elena@outlook.com', 'qwerty'),
  ('Luca', 'Marino', '2345678901', 'luca@hotmail.com', 'password'),
  ('Chiara', 'De Luca', '890123456', 'chiara@gmail.com', 'abc123'),
  ('Francesco', 'Conti', '345678901', 'francesco@hotmail.com', 'hello123'),
  ('Sofia', 'Galli', '901234567', 'sofia@gmail.com', 'welcome'),
  ('Leonardo', 'Greco', '567890123', 'leonardo@outlook.com', 'test123'),
  ('Giulia', 'Santoro', '12345678', 'giulia@hotmail.com', '123abc'),
  ('Matteo', 'Ferri', '45678901', 'matteo@gmail.com', 'pass123'),
  ('Valentina', 'Mancini', '89012345', 'valentina@hotmail.com', 'example'),
  ('Federico', 'Rizzo', '34567890', 'federico@gmail.com', 'password123'),
  ('Alessandro', 'Lombardi', '01234567', 'alessandro@hotmail.com', 'securepass'),
  ('Martina', 'Caruso', '56789012', 'martina@gmail.com', 'mypassword'),
  ('Lorenzo', 'Barbieri', '12345678', 'lorenzo@outlook.com', '123456'),
  ('Camilla', 'Gatti', '78901234', 'camilla@hotmail.com', 'qwerty'),
  ('Nicola', 'Costa', '23456789', 'nicola@gmail.com', 'password'),
  ('Elisa', 'Rinaldi', '65432109', 'elisa@hotmail.com', 'abc123');
