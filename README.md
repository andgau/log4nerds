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
* Se est� realizando una prueba de concepto (POC) y se desea tener una salida razonablemente formateada.
* Odias la salida estandar de `juli` y quieres trazas de una sola linea con colores en consola o en archivo.

El origen de esta utilidad es una entrada en un blog y esta a su vez de unas clases que ten�a hechas como POC para otros POC. No tiene mucho sentido que crezca el desarrollo, no pretenden competir con logback. Es simplemente una utilidad para acostumbrarse a utilizar trazas o desacostumbrarse a utilizar `System.out.println`.

Queda completar la documentaci�n y limpiar algo el c�digo y alguna opci�n m�nima que vea de utilidad.

De momento una vez importadas las librerias empezar a utilizar este log4nerds es escribir:

	private static ConsoleConfigurator config = ConsoleConfigurator.getInstance();
	private static Logger logger = Log4nFactory.getInstance(config);

Cualquier comentario ser� bienvenido
