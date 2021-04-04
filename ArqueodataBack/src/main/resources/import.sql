INSERT INTO usuarios (username,email,password,enabled) VALUES ('Pepe','pepe@gmail.com','$2a$10$RKi9AN48ir99g5LkkAU2huyyBugwmnXhGqwz4x.Qv.YfvYFTbPlSi',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('Juan','juan@gmail.com','$2a$10$L9bNwFbWr7tNnvliU.YqpOmndShu6GqmbEfMgDlX1e5DH5QboMUoG',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('Paco','paco@gmail.com','$2a$10$PwASHdAO71MEnMx/fANwFu3wFDdl6CDicXFMcSde6MaiXmJsojZHm',1);
INSERT INTO usuarios (username,email,password,enabled) VALUES ('Maria','maria@gmail.com','$2a$10$L1RNRdBi8DyS5IAd9DEH8eb5Jk.Uc3WNZN7ofAmDKRMj5oL3H70eW',1);

INSERT INTO piezas (fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES ('2014-08-08','hueso','punzon',1234,1234,1234,'H15','bien conservado','','http://museo.deteruel.es/museoprovincial/wp-content/uploads/2016/11/Flecha-1.jpg');
INSERT INTO piezas (fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES ('2014-07-10','ceramica','cuenco',44445555,2344656,1234,'H17','mal conservado','','https://argarica.es/images/2019/11/16/portada_large.jpg');
INSERT INTO piezas (fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES ('2014-08-03','ceramica','tinaja',1234,1234,44445555,'H09','bien conservado','','http://museo.deteruel.es/museoprovincial/wp-content/uploads/2016/11/Tinaja-3.jpg');
INSERT INTO piezas (fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES ('2014-08-03','metal','flecha',44445555,1234,1234,'H09','bien conservado','','http://museo.deteruel.es/museoprovincial/wp-content/uploads/2016/11/Flecha-1.jpg');
INSERT INTO piezas (fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES ('2014-08-04','hueso','punzon',2344656,1234,44445555,'H08','mal conservado','','http://museo.deteruel.es/museoprovincial/wp-content/uploads/2016/11/Flecha-1.jpg');
INSERT INTO piezas (fecha,material,util,coordenadasX,coordenadasY,coordenadasZ,zona,estado,observaciones,foto) VALUES ('2014-08-04','metal','alabarda',2344656,1234,44445555,'H08','mal conservado','','http://museo.deteruel.es/museoprovincial/wp-content/uploads/2016/11/Alabarda.jpg');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,1);

