INSERT INTO public.alumnos(
	id, nombre, paterno, materno, matricula, "updateDate")
	VALUES (1, 'Roberto', 'Rivera', 'Santana', '123564', to_date('2017-05-23', 'YYYY-MM-DD'));

INSERT INTO public.alumnos(
	id, nombre, paterno, materno, matricula, "updateDate")
	VALUES (2, 'Jennifer', 'Carrillo', 'Dominguez', '654321', to_date('2017-05-24', 'YYYY-MM-DD'));

INSERT INTO public.carreras(
	"Id", nombre, descripcion, "updateDate")
	VALUES (1, 'Licencitura en Derecho' , 'Sistema Abierto', to_date('2000-05-23', 'YYYY-MM-DD'));

INSERT INTO public.carreras(
	"Id", nombre, descripcion, "updateDate")
	VALUES (2, 'Licencitura en Ciencias de la Informatica' , 'UPIICSA', to_date('2010-05-23', 'YYYY-MM-DD'));

INSERT INTO public.materias(
	id, nombre, descripcion, creditos, "updateDate")
	VALUES (1, 'Sistemas digitales', 'Desarrollo de sistemas digitales con arduino', 50, to_date('2000-05-23', 'YYYY-MM-DD'));

INSERT INTO public.profesores(
	id, nombre, paterno, materno, "updateDate")
	VALUES (1, 'Sanabria', 'Cabrera', 'De Sauza', to_date('2010-05-23', 'YYYY-MM-DD'));