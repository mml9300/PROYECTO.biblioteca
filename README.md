#  🌐 PROYECTO BIBLIOTECA 🌐

MANEJO DE FICHEROS CON JAVA: Hecho por Miguel Ángel Milena Ropero y Javier Gómez Priego


# 🔰Introducción

Este repositorio alberga el proyecto final de la práctica evaluable de **ACCESO A DATOS**, enfocado en el desarrollo de una aplicación en Java para gestionar información de una biblioteca. El objetivo principal es manipular libros, autores y préstamos, haciendo uso de diversos tipos de ficheros como binarios, de texto, objetos y XML. 

# 🔰Análisis de proyecto

1.  **Gestión de Libros y Autores:**
    
    -   Crear, leer, actualizar y eliminar información de libros y autores.
    -   Atributos de libros: ID, título, autor, año de publicación y género.
    -   Atributos de autores: ID, nombre, nacionalidad y año de nacimiento.
2.  **Gestión de Préstamos:**
    
    -   Registrar préstamos y devoluciones de libros.
    -   Detalles de préstamo: ID del libro, nombre del usuario, fechas de préstamo y devolución.
3.  **Almacenamiento de Datos:**
    
    -   Empleo de ficheros binarios para almacenar datos de libros y autores.
    -   Uso de ficheros de texto para registrar préstamos y devoluciones.
    -   Manejo de objetos binarios para copias de seguridad.
    -   Utilización de ficheros XML para exportar e importar datos (usando DOM).
# 🔰Estructura del proyecto

## Clases

### Clase `Libro`:
#### Atributos:

-   `id`: ID único del libro.
-   `titulo`: Título del libro.
-   `autor`: Referencia al autor del libro (puede ser un objeto de la clase `Autor`).
-   `añoPublicacion`: Año de publicación del libro.
-   `genero`: Género del libro.

#### Funcionalidades:

1.  **Creación de Libro:**
    
    -   Constructor que toma los datos necesarios para crear un nuevo libro en binario.
2.  **Gestión de Información del Libro:**
    
    -   Métodos para acceder, mostrar, modificar y eliminar los atributos del libro, como el título, autor, año de publicación y género (en binario).


### Clase `Autor`:

#### Atributos:

-   `id`: Identificador único del autor.
-   `nombre`: Nombre del autor.
-   `nacionalidad`: País de origen del autor.
-   `añoNacimiento`: Año de nacimiento del autor.

#### Funcionalidades:

1.  **Creación de Autor:**
    
    -   Constructor que recibe los datos del autor para crear una nueva instancia de la clase en binario.
2.  **Gestión de Información del Autor:**
    
    -   Métodos para acceder y modificar los atributos del autor, como el nombre, nacionalidad y año de nacimiento. (en binario)




### Clase `Prestamo`:
#### Atributos:

-   `idLibro`: ID del libro prestado.
-   `nombreUsuario`: Nombre del usuario que toma prestado el libro.
-   `fechaPrestamo`: Fecha en la que se realizó el préstamo.
-   `fechaDevolucion`: Fecha en la que se espera la devolución del libro.
#### Funcionalidades:
1.  **Registro de Préstamo:**
    
    -   Método para registrar un nuevo préstamo.
    -   Método para llevar un control de las devoluciones.
    

2.  **Muestra de prestamos**
	 -   Se encarga de almacenar estos datos para el seguimiento de los préstamos activos.
	 -   Se encarga de almacenar estos datos para el seguimiento de las devoluciones pendientes.



### FUNCIONALIDAD DE GESTORFICHEROS.JAVA:
El archivo GestorFicheros.java es un componente importante en el sistema de gestión de nuestra biblioteca, diseñado para facilitar operaciones básicas sobre los datos de los libros, autores y prestamos. 
Este módulo ofrece una gama completa de funcionalidades que permiten manejar de manera eficiente la información almacenada y garantiza su integridad y consistencia.

#### Funcionalidades Principales:

1.  **Gestión de Libros y Autores:**
    
    -   **Guardar:** Métodos especializados para guardar información detallada de libros y autores, asegurando su almacenamiento preciso en ficheros correspondientes.
    -   **Mostrar:** Facilita la visualización clara y ordenada de los datos de libros y autores, permitiendo una fácil consulta de la información relevante.
    -   **Actualizar:** Permite la actualización ágil y precisa de los registros existentes de libros y autores, asegurando la coherencia de la base de datos.
    -   **Eliminar:** Funciones específicas para la eliminación segura y controlada de registros de libros y autores, manteniendo la consistencia de los datos almacenados.
2.  **Manejo de Préstamos:**
    
    -   **Creación y Visualización:** Capacidades para crear nuevos préstamos y presentar información detallada sobre préstamos existentes, proporcionando una visión clara de las transacciones de préstamo.
3.  **Importación y Exportación en Formato XML (DOM):**
    
    -   **Exportación a XML:** Ofrece la posibilidad de exportar la información de libros y autores en formato XML utilizando la API DOM, garantizando la portabilidad y compatibilidad de los datos.
    -   **Importación desde XML:** Permite la importación de datos desde archivos XML, facilitando la integración de información de fuentes externas al sistema de gestión de la biblioteca.

#### Beneficios Clave:
-   **Consistencia y Precisión:** Garantiza la coherencia y precisión de los datos almacenados, facilitando una gestión robusta y fiable de la información.
-   **Interfaz Intuitiva:** Proporciona métodos claros y estructurados para interactuar con la información, asegurando una manipulación sencilla y eficiente de los registros.
-   **Portabilidad y Compatibilidad:** La capacidad de importar y exportar datos en formato XML ofrece una solución flexible y compatible con diferentes entornos de almacenamiento y transferencia de información.
-    **Accesibilidad a los datos:** La posibilidad de acceder a los datos introducidos de forma inmediata.
-    **Uso de rutas relativas:** La misma carpeta del proyecto es la que va a almacenar todos los ficheros creados tanto en binario, texto y XML a los que se podrá acceder fácilmente siempre que se quiera.


## Decisiones de diseño
### Requisitos Funcionales y No Funcionales:

1.  **Requisitos Funcionales:**
    -   Entender en profundidad las funcionalidades requeridas, como la gestión de libros, autores y préstamos, así como la manipulación de ficheros en diferentes formatos.
2.  **Requisitos No Funcionales:**
    -   Considerar aspectos como rendimiento, seguridad, escalabilidad y usabilidad que afectan el diseño del sistema.

### Modularidad y Mantenibilidad:

1.  **Organización del Código:**
    
    -   Diseñar clases y módulos separados para libros, autores, gestión de ficheros y préstamos para asegurar un código modular y mantenible.
    
### Usabilidad y Experiencia del Usuario:

1.  **Interfaz de Usuario:**
    
    -   Considerar la facilidad de uso al diseñar la interfaz de línea de comandos (CLI) para garantizar que sea intuitiva y amigable para el usuario.

## Dificultades encontradas y soluciones
Nos enfrentamos a diversas dificultades durante el desarrollo del proyecto. 
En primer lugar, un paquete corrupto afectó la compilación adecuada, generando errores al intentar mostrar datos almacenados en formato binario. Además, experimentamos desafíos al crear elementos en XML, donde los registros se generaban incorrectamente al ser tratados como nodos padre sin las tabulaciones necesarias, lo que ocasionaba fallos en la estructura del archivo XML.

Resolvimos los errores eliminando el archivo .jar corrupto, cuya ubicación nos llevó un tiempo identificar, y el XML fue solucionado mediante ajustes en la generación apropiada de elementos XML para garantizar la integridad y funcionalidad del proyecto.


## Mejoras a tener en cuenta

- El proyecto debe contar con un sólido control de errores para manejar datos inválidos que podrían ser introducidos por usuarios o clientes en el futuro. Por ejemplo, se debe considerar la posibilidad de que se ingrese información incorrecta en campos de fechas, como la introducción de caracteres ASCII que no corresponden a un formato de fecha válido. Este control de errores debe ser capaz de identificar y manejar eficientemente situaciones donde los datos introducidos no cumplan con los criterios establecidos, brindando mensajes claros y precisos al usuario para indicar que la información ingresada no es válida.

- Sería beneficioso implementar una interfaz gráfica para mejorar la experiencia del cliente. Esto permitiría una interacción más intuitiva y amigable con la aplicación, facilitando la navegación y el uso de las diferentes funcionalidades ofrecidas por el sistema de gestión de bibliotecas.
- Sería muy ventajoso desarrollar versiones adicionales de este proyecto para dispositivos móviles (APK) y para acceso a través de una página web. Esto ampliaría significativamente la accesibilidad, permitiendo a los usuarios utilizar la aplicación desde sus dispositivos móviles o a través de un navegador web, brindando mayor flexibilidad y alcance en la gestión de la biblioteca.

