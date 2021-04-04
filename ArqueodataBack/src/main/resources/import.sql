INSERT INTO campains (id,campain) VALUES (1,2012);
INSERT INTO campains (id,campain) VALUES (2,2013);
INSERT INTO campains (id,campain) VALUES (3,2014);
INSERT INTO campains (id,campain) VALUES (4,2015);

INSERT INTO yacimientos (id,nombre,lugar,epoca) VALUES (1,'Bastida', 'Totana, Murcia','Argárica');
INSERT INTO yacimientos (id,nombre,lugar,epoca) VALUES (2,'Almoloya', 'Mula, Murcia','Argárica');
INSERT INTO yacimientos (id,nombre,lugar,epoca) VALUES (3,'Baeloclaudia', 'Bolonia, Cádiz','Romana');
INSERT INTO yacimientos (id,nombre,lugar,epoca) VALUES (4,'Itálica', 'Santiponce, Sevilla','Romana');

INSERT INTO usuarios (username,email,password,enabled) VALUES ('Pepe','pepe@gmail.com','$2a$10$RKi9AN48ir99g5LkkAU2huyyBugwmnXhGqwz4x.Qv.YfvYFTbPlSi',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('Juan','juan@gmail.com','$2a$10$L9bNwFbWr7tNnvliU.YqpOmndShu6GqmbEfMgDlX1e5DH5QboMUoG',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('Paco','paco@gmail.com','$2a$10$PwASHdAO71MEnMx/fANwFu3wFDdl6CDicXFMcSde6MaiXmJsojZHm',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('Maria','maria@gmail.com','$2a$10$L1RNRdBi8DyS5IAd9DEH8eb5Jk.Uc3WNZN7ofAmDKRMj5oL3H70eW',1);

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,1);


INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (1,2,'2014-08-08','hueso','punzon',1234,1234,1234,'H15','bien conservado','','');
INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (2,1,'2014-07-10','ceramica','cuenco',44445555,2344656,1234,'H17','mal conservado','','');
INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (3,1,'2014-08-03','ceramica','tinaja',1234,1234,44445555,'H09','bien conservado','','');
INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (4,2,'2014-08-03','metal','flecha',44445555,1234,1234,'H09','bien conservado','','');
INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (1,3,'2014-08-04','hueso','punzon',2344656,1234,44445555,'H08','mal conservado','','');
INSERT INTO piezas (yacimiento_id,campain_id,fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES (1,4,'2014-08-04','metal','alabarda',2344656,1234,44445555,'H08','mal conservado','','');





