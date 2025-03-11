CREATE TABLE genero (
    id_genero SERIAL PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE pelicula (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    director VARCHAR(100),
    estudio VARCHAR(100),
    anio INT,
    id_genero INT,
    duracion INT,
    CONSTRAINT fk_id_genero FOREIGN KEY (id_genero) REFERENCES genero (id_genero)
);


-- Insertar géneros únicos
INSERT INTO genero (nombre) VALUES
('Fantasía'),
('Acción'),
('Ciencia ficción'),
('Mecha'),
('Romance'),
('Drama'),
('Aventura'),
('Psicológico');

-- Insertar películas con referencia a la tabla genero
INSERT INTO pelicula (titulo, director, estudio, anio, id_genero, duracion) VALUES
('Suzume', 'Makoto Shinkai', 'CoMix Wave Films', 2022, (SELECT id_genero FROM genero WHERE nombre = 'Fantasía'), 122),
('Sword Art Online: Progressive - Scherzo of Deep Night', 'Ayako Kouno', 'A-1 Pictures', 2022, (SELECT id_genero FROM genero WHERE nombre = 'Acción'), 100),
('Sword Art Online: Progressive - Aria of a Starless Night', 'Ayako Kouno', 'A-1 Pictures', 2021, (SELECT id_genero FROM genero WHERE nombre = 'Acción'), 97),
('Jujutsu Kaisen 0', 'Sunghoo Park', 'MAPPA', 2021, (SELECT id_genero FROM genero WHERE nombre = 'Acción'), 105),
('Belle', 'Mamoru Hosoda', 'Studio Chizu', 2021, (SELECT id_genero FROM genero WHERE nombre = 'Ciencia ficción'), 121),
('Evangelion: 3.0+1.0 Thrice Upon a Time', 'Hideaki Anno', 'Khara', 2021, (SELECT id_genero FROM genero WHERE nombre = 'Mecha'), 154),
('Demon Slayer: Mugen Train', 'Haruo Sotozaki', 'ufotable', 2020, (SELECT id_genero FROM genero WHERE nombre = 'Acción'), 117),
('Weathering with You', 'Makoto Shinkai', 'CoMix Wave Films', 2019, (SELECT id_genero FROM genero WHERE nombre = 'Romance'), 112),
('Mirai', 'Mamoru Hosoda', 'Studio Chizu', 2018, (SELECT id_genero FROM genero WHERE nombre = 'Fantasía'), 98),
('Maquia: When the Promised Flower Blooms', 'Mari Okada', 'P.A. Works', 2018, (SELECT id_genero FROM genero WHERE nombre = 'Drama'), 115),
('Sword Art Online: Ordinal Scale', 'Tomohiko Itou', 'A-1 Pictures', 2017, (SELECT id_genero FROM genero WHERE nombre = 'Acción'), 119),
('A Silent Voice', 'Naoko Yamada', 'Kyoto Animation', 2016, (SELECT id_genero FROM genero WHERE nombre = 'Drama'), 129),
('Your Name', 'Makoto Shinkai', 'CoMix Wave Films', 2016, (SELECT id_genero FROM genero WHERE nombre = 'Romance'), 107),
('The Boy and the Beast', 'Mamoru Hosoda', 'Studio Chizu', 2015, (SELECT id_genero FROM genero WHERE nombre = 'Aventura'), 119),
('The Tale of the Princess Kaguya', 'Isao Takahata', 'Studio Ghibli', 2013, (SELECT id_genero FROM genero WHERE nombre = 'Drama'), 137),
('Wolf Children', 'Mamoru Hosoda', 'Studio Chizu', 2012, (SELECT id_genero FROM genero WHERE nombre = 'Fantasía'), 117),
('The Secret World of Arrietty', 'Hiromasa Yonebayashi', 'Studio Ghibli', 2010, (SELECT id_genero FROM genero WHERE nombre = 'Fantasía'), 94),
('Summer Wars', 'Mamoru Hosoda', 'Madhouse', 2009, (SELECT id_genero FROM genero WHERE nombre = 'Ciencia ficción'), 114),
('Ponyo', 'Hayao Miyazaki', 'Studio Ghibli', 2008, (SELECT id_genero FROM genero WHERE nombre = 'Fantasía'), 101),
('The Girl Who Leapt Through Time', 'Mamoru Hosoda', 'Madhouse', 2006, (SELECT id_genero FROM genero WHERE nombre = 'Ciencia ficción'), 98),
('Howls Moving Castle', 'Hayao Miyazaki', 'Studio Ghibli', 2004, (SELECT id_genero FROM genero WHERE nombre = 'Fantasía'), 119),
('Tokyo Godfathers', 'Satoshi Kon', 'Madhouse', 2003, (SELECT id_genero FROM genero WHERE nombre = 'Drama'), 92),
('Spirited Away', 'Hayao Miyazaki', 'Studio Ghibli', 2001, (SELECT id_genero FROM genero WHERE nombre = 'Fantasía'), 125),
('Jin-Roh: The Wolf Brigade', 'Hiroyuki Okiura', 'Production I.G', 1999, (SELECT id_genero FROM genero WHERE nombre = 'Ciencia ficción'), 102),
('Perfect Blue', 'Satoshi Kon', 'Madhouse', 1997, (SELECT id_genero FROM genero WHERE nombre = 'Psicológico'), 81),
('Princess Mononoke', 'Hayao Miyazaki', 'Studio Ghibli', 1997, (SELECT id_genero FROM genero WHERE nombre = 'Aventura'), 133),
('Ghost in the Shell', 'Mamoru Oshii', 'Production I.G', 1995, (SELECT id_genero FROM genero WHERE nombre = 'Ciencia ficción'), 83),
('Ninja Scroll', 'Yoshiaki Kawajiri', 'Madhouse', 1993, (SELECT id_genero FROM genero WHERE nombre = 'Acción'), 94),
('Porco Rosso', 'Hayao Miyazaki', 'Studio Ghibli', 1992, (SELECT id_genero FROM genero WHERE nombre = 'Aventura'), 94),
('Akira', 'Katsuhiro Otomo', 'Tokyo Movie Shinsha', 1988, (SELECT id_genero FROM genero WHERE nombre = 'Ciencia ficción'), 124),
('My Neighbor Totoro', 'Hayao Miyazaki', 'Studio Ghibli', 1988, (SELECT id_genero FROM genero WHERE nombre = 'Fantasía'), 86),
('Grave of the Fireflies', 'Isao Takahata', 'Studio Ghibli', 1988, (SELECT id_genero FROM genero WHERE nombre = 'Drama'), 89),
('Castle in the Sky', 'Hayao Miyazaki', 'Studio Ghibli', 1986, (SELECT id_genero FROM genero WHERE nombre = 'Aventura'), 124),
('Nausicaä of the Valley of the Wind', 'Hayao Miyazaki', 'Topcraft', 1984, (SELECT id_genero FROM genero WHERE nombre = 'Aventura'), 117);


select * from pelicula;
