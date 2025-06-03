 CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE hackaton (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT,
    categoria_id INTEGER NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
        ON DELETE RESTRICT
        ON UPDATE RESTRICT
);

-- Insertar categorías base
INSERT INTO categoria (nombre) VALUES 
('Inteligencia Artificial'),
('Desarrollo Web'),
('Ciberseguridad'),
('Videojuegos'),
('Big Data');

INSERT INTO hackaton (nombre, descripcion, categoria_id) VALUES
('AI Challenge 2025', 'Hackatón enfocado en soluciones de IA para la industria.', 1),
('WebFest Zaragoza', 'Diseña y lanza un sitio web funcional en 48 horas.', 2),
('CyberDefense JAM', 'Reto de defensa ante ataques simulados.', 3),
('GameDev Party', 'Crea un videojuego original en 72 horas.', 4),
('Data Storm', 'Desafíos de análisis y visualización de grandes volúmenes de datos.', 5);


INSERT INTO hackaton (nombre, descripcion, categoria_id) VALUES
('AI Revolution', 'Competición para crear modelos de IA innovadores.', 1),
('FrontEnd Masters', 'Hackatón de desarrollo web con frameworks modernos.', 2),
('SecureNet', 'Desafío de ciberseguridad con escenarios reales.', 3),
('Pixel Warriors', 'Competencia para crear videojuegos indie.', 4),
('Big Data Blitz', 'Análisis avanzado de datos masivos.', 5);



SELECT h.id, h.nombre, h.descripcion, c.id, c.nombre
FROM hackaton h
INNER JOIN categoria c ON h.categoria_id = c.id
WHERE UPPER(c.nombre) = UPPER('Videojuegos')
AND UPPER(h.nombre) LIKE UPPER('%Game%');

SELECT h.id, h.nombre, h.descripcion, c.id, c.nombre 
FROM hackaton h
INNER JOIN categoria c ON h.categoria_id = c.id
WHERE UPPER(c.nombre) = UPPER('Videojuegos')
AND UPPER(h.nombre) LIKE UPPER('%Game%');