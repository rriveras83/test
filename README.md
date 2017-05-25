# test
Proyecto para despliegue de servicios REST

Creado por: José Roberto Rivera Santana

# Tecnologías empleadas:
Spring MVC 3

Hibernate 3

Maven 3.5.0

Tomcat 8.5

JDK 7

Eclipse Neon

PostgreSQL 9.6

# Modificación xml para conexión a BD

dispatcher-servlet.xml

# Compilación

Utilizar comandos maven a nivel de donde se encuentra archivo pom.xml

mvn clean install

# URL Servicios

http://localhost:XXXX/test/restService/baseService/{tabla}

Ejemplo: http://localhost:8080/test/restService/baseService/profesores

http://localhost:XXXX/test/restService/baseService/porFecha/{tabla}/{fechaBusqueda}

Ejemplo: http://localhost:8080/test/restService/baseService/porFecha/alumnos/23-05-2017

http://localhost:XXXX/test/restService/baseService/entreFechas/{tabla}/{fechaInicio}/{fechaFin}

Ejemplo: http://localhost:8080/test/restService/baseService/entreFechas/all/23-05-2017/26-05-2017

Donde: 

XXXX Puerto que corresponde a tomcat

{tabla} Tabla que se desea consultar (alumnos, profesores, materias, carreras, all)

{fechaBusqueda} Fecha en particular sobre la que se desea realizar la busqueda de registros en las tablas

{fechaInicio} Fecha de inicio de busqueda

{fechaFin} Fecha de fin de busqueda
