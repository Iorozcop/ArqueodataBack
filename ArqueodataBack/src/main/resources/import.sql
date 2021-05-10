
INSERT INTO campains (id,campain) VALUES (1,2012);
INSERT INTO campains (id,campain) VALUES (2,2013);
INSERT INTO campains (id,campain) VALUES (3,2014);
INSERT INTO campains (id,campain) VALUES (4,2015);
INSERT INTO campains (id,campain) VALUES (5,2016);
INSERT INTO campains (id,campain) VALUES (6,2017);
INSERT INTO campains (id,campain) VALUES (7,2018);
INSERT INTO campains (id,campain) VALUES (8,2019);
INSERT INTO campains (id,campain) VALUES (9,2020);

INSERT INTO yacimientos (id,nombre,lugar,epoca) VALUES (1,'Bastida', 'Totana, Murcia','Argárica');
INSERT INTO yacimientos (id,nombre,lugar,epoca) VALUES (2,'Almoloya', 'Mula, Murcia','Argárica');
INSERT INTO yacimientos (id,nombre,lugar,epoca) VALUES (3,'Baeloclaudia', 'Bolonia, Cádiz','Romana');
INSERT INTO yacimientos (id,nombre,lugar,epoca) VALUES (4,'Itálica', 'Santiponce, Sevilla','Romana');
INSERT INTO yacimientos (id,nombre,lugar,epoca) VALUES (5,'Ocuri', 'Ubrique, Cádiz','Romana');
INSERT INTO yacimientos (id,nombre,lugar,epoca) VALUES (6,'Urso', 'Osuna, Sevilla','Romana');
INSERT INTO yacimientos (id,nombre,lugar,epoca) VALUES (7,'Asta Regia', 'Jerez, Cádiz','Romana');
INSERT INTO yacimientos (id,nombre,lugar,epoca) VALUES (8,'Dolmen de la pastora', 'Valencina, Sevilla','2000-AC');
INSERT INTO yacimientos (id,nombre,lugar,epoca) VALUES (9,'Tira del lienzo', 'Totana, Murcia','Argárica');
INSERT INTO yacimientos (id,nombre,lugar,epoca) VALUES (10,'Dolmen de menga', 'Antequera, Málaga','2000-AC');


INSERT INTO usuarios (username,email,password,enabled) VALUES ('Pepe','pepe@gmail.com','$2a$10$RKi9AN48ir99g5LkkAU2huyyBugwmnXhGqwz4x.Qv.YfvYFTbPlSi',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('Juan','juan@gmail.com','$2a$10$L9bNwFbWr7tNnvliU.YqpOmndShu6GqmbEfMgDlX1e5DH5QboMUoG',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('Paco','paco@gmail.com','$2a$10$PwASHdAO71MEnMx/fANwFu3wFDdl6CDicXFMcSde6MaiXmJsojZHm',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('Maria','maria@gmail.com','$2a$10$L1RNRdBi8DyS5IAd9DEH8eb5Jk.Uc3WNZN7ofAmDKRMj5oL3H70eW',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('Juana','Juana@gmail.com','$2a$10$uLNxXsJt5plJyZbTDx8CautSWoKqzlCtqre5c6S87w8l3zA4dmlCe',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('Curro','Curro@gmail.com','$2a$10$X3tqCMMzRg.FUAzL7a.haOgG1IvR2ccxe3VuYSKoZh12FingJVKrW',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('lolo','lolo@gmail.com','$2a$10$17AQ5Bwm9DTFxI9sKN4.2eYGsc2.3Vqb4Du/UirX0QgkciMEnfOn.',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('julia','julia@gmail.com','$2a$10$CmRqpHFiE6Y4IjVwLdcNKerBDFj9hmMCD7bL0feAxVBsZvjP.d4FW',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('Claudia','claudia@gmail.com','$2a$10$Cttbbi2YZGd9fj5x3AmLv.4wgwC2o4k2GB5NMe2oMkaGvKFiQ1AzC',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('Isa','isa@gmail.com','$2a$10$jpzb4bH31pIYMp/Lo4FfCuY6X/EWk067z3ia4cbYNMp0hddFDiyEu',1);


INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (3,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (4,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (5,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (6,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (7,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (8,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (9,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (10,1);

INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (1,2,'2014-08-08','hueso','punzón',1234,1234,1234,'H15','bien conservado','La pieza se encuentra en muy buen estado de conservación','');
INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (2,1,'2014-07-10','cerámica','cuenco',44445555,2344656,1234,'H17','mal conservado','Tenía restos de grano','');
INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (3,1,'2014-08-03','cerámica','tinaja',1234,1234,44445555,'H09','bien conservado','Presenta pequeña rotura en la base','');
INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (4,2,'2014-08-03','metal','flecha',44445555,1234,1234,'H09','bien conservado','La pieza se encuentra bien conservada','');
INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (5,3,'2014-08-04','hueso','punzon',2344656,1234,44445555,'H08','mal conservado','Se encontró fuera del hogar','');
INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (5,4,'2014-08-04','metal','alabarda',2344656,1234,44445555,'H08','mal conservado','Formaba parte del ajuar funerario femenino','');
INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (6,4,'2014-08-04','cerámica','cuenco',24444656,12388884,48888855,'H09','mal conservado','Tenía restos de grano','');
INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (6,4,'2014-08-04','cerámica','cuenco',27774656,4488884,4222222,'H07','muy bien conservado','Tenía restos de grano.Presenta pequeña rotura en la base.Formaba parte del ajuar funerario femenino','');
INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (8,4,'2014-08-04','cerámica','cuenco',2774656,12388884,6668855,'H02','mal conservado','Tenía restos de grano','');
INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (7,4,'2014-08-04','cerámica','cuenco',666444656,12367,666688855,'H13','bien conservado','','');






