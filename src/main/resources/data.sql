-- Datos para Información Personal (ID 1 es el que usamos en el controlador)
INSERT INTO info (id, nombre, descripcion, email, telefono, linkedin, github, foto_url)
VALUES (1, 'Paula Morales Mayenco', 'Desarrolladora Full Stack & Artista Digital', 'paula@gmail.com', '+34 600 000 000', 'https://linkedin.com/in/paula', 'https://github.com/paula', '/images/perfil.jpg');

-- Datos de Lenguajes
INSERT INTO lenguaje (id, nombre) VALUES (1, 'Java');
INSERT INTO lenguaje (id, nombre) VALUES (2, 'Spring Boot');
INSERT INTO lenguaje (id, nombre) VALUES (3, 'JavaScript');

-- Datos de Experiencia
INSERT INTO experiencia (id, puesto, empresa, descripcion, fecha_inicio, fecha_fin)
VALUES (1, 'Desarrolladora Junior', 'Tech Solutions', 'Desarrollo de APIs REST', '2023-01-01', '2024-01-01');

-- Datos de Proyectos
INSERT INTO proyecto (id, nombre, descripcion, github_url, imagen_url)
VALUES (1, 'Portfolio Web', 'Mi primer portfolio con Spring Boot', 'https://github.com/paula/portfolio', '/images/banner_codigo.jpg');

-- Relación Muchos a Muchos: Proyecto 1 usa Lenguajes 1 y 2
-- (Asegúrate de que el nombre de esta tabla coincida con @JoinTable en tu modelo)
INSERT INTO proyecto_lenguajes (proyecto_id, lenguajes_id) VALUES (1, 1);
INSERT INTO proyecto_lenguajes (proyecto_id, lenguajes_id) VALUES (1, 2);