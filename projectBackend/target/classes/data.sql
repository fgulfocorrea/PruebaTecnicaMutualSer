


INSERT INTO PERSONAS (id, nombre, correo) VALUES (1,'juan', 'juanperez@gmail.com'), (2,'flavio','flaviogulfo@gmail.com'), (3,'diego','diegogomez@gmail.com');

INSERT INTO USUARIOS (id, user, pswd) VALUES (1,'juanperez','12345'), (2,'fgulfo','123456'), (3,'diegogomez','1234567');

INSERT INTO MONEDAS (id, nombre, pais) VALUES (1,'50','CO'), (2,'100','CO'), (3,'200','CO'), (4,'500','CO'), (5,'1000','CO'), (6,'300','CL'), (7,'400','CL'), (8,'800','CL');;

INSERT INTO ALCANCIAS (id, nombre, pais, total_dinero) VALUES (1,'Alcancia Carro - Colombia','CO',250), (2,'Alcancia Carro - Chile','CL',600);

INSERT INTO MOVIMIENTOS_ALCANCIAS (id, id_alcancia, id_moneda, cantidad) VALUES (1,1,1,5), (2,2,6,2);