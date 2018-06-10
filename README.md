Log4Nerd
=======

Estas librerias son para implementar unos logs de forma sencilla y con un nivel de "customizaci�n" razonable desde c�digo.

**�Qu� hacen?**
Son un *envoltorio* para las `java.util.logging` que est�n presentes en toda m�quina virtual de java (MVJ). Intencionadamente no se ha empleado ninguna libreria externa para que no exista ninguna dependencia de nada fuera de la MVJ.


**�Qu� no son?**
* No son unas librerias de logs para un sistema en producci�n
* No son un sustituto de log4j, slf4j, logback, etc ni cualquier empaquetado de los normales para logs.

**Caso de Uso** (Una o varias de las siguientes circunstancias)
* Se desea tener un sistema de gesti�n de logging sin meter configuraci�n con archivos properties o xml.
* Se est� realizando una prueba de concepto y se desea tener una salida razonablemente formateada.
* Odias la salida estandar de `juli` y quieres trazas de una sola linea con colores en consola o en archivo.

