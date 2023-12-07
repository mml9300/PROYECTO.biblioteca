package biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;
public class principal {
	
	//Primeramente vamos a inicializar algunas clases necesarias
	
	private static Scanner scanner = new Scanner(System.in);
	private static gestorficheros gestorFicheros = new gestorficheros();
	private static List<libro> listaDeLibros = new ArrayList<>();
	private static List<autor> listaDeAutores = new ArrayList<>();
	static prestamo Prestamo = new prestamo(0, null, null, null);
	
	
	public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException {
		
		//Menú principal
		boolean salir = false;
		while (!salir) {
			mostrarMenu();
			int opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				// Gestionar libros
				gestionarLibros();
				break;
			case 2:
				// Gestionar autores
				gestionarAutores();
				break;
			case 3:
				// Gestionar prestamos
				gestionarPrestamos();
				break;
			case 4:
				// Exportar/Importar datos con XML
				gestionarExportImportXML();
				break;
			case 5:
				// Salir
				salir = true;
				break;
			default:
				System.out.println("Opción no válida. Por favor intente de nuevo.");
			}
		}
	}

	//Libros
	private static void gestionarLibros() {
	    boolean salir = false;
	    while (!salir) {
	    	crudLibroMenu();
	        int opcion2 = scanner.nextInt();
	        scanner.nextLine();
	        switch (opcion2) {
	        
	            case 1:
	            	// Pedimos por consola al usuario todos los campos que tiene que tener libro
	            	System.out.println("---------------------");
	            	System.out.println("Ingrese el ID del libro:");
	            	int id_libro = scanner.nextInt();
	            	scanner.nextLine(); 

	            	System.out.println("Ingrese el título del libro:");
	            	String titulo = scanner.nextLine();

	            	System.out.println("Ingrese el autor del libro:");
	            	String autor = scanner.nextLine();

	            	System.out.println("Ingrese el año de publicación del libro:");
	            	int añoPublicacion = scanner.nextInt();
	            	scanner.nextLine(); 

	            	System.out.println("Ingrese el género del libro:");
	            	String genero = scanner.nextLine();

	            	// Crear un objeto Libro con los datos proporcionados por el usuario
	            	listaDeLibros.add(new libro(id_libro, titulo, autor, añoPublicacion, genero));
	            	gestionarExportLibro();
	            	
	                break;
	                
	            case 2:
	            	
	            	//Mostrar todo lo recogido del case 1
	            	
	            	List<libro> listaDeLibrosExistente = null;
	            	
	            	try {
	            		
	            		listaDeLibrosExistente=gestorFicheros.leerLibrosBinario("libros.bin");
	            			            		
	            	}catch (Exception e) {
						// TODO: handle exception
					}
	            	
	            	for (libro libro : listaDeLibrosExistente) {
	            		System.out.println(libro);
	            	}
	            	
	                break;
	                
	            case 3:
	            	//Actualización de datos de libro
	            	System.out.println("---------------------");
	            	System.out.println("¿Qué id quieres modificar?");
	            	int modificar = scanner.nextInt();
	            	scanner.nextLine();

	            	System.out.println("Ingrese el título nuevo:");
	            	String titulo_modificada = scanner.nextLine();

	            	System.out.println("Ingrese el autor nuevo:");
	            	String autor_modificada = scanner.nextLine();

	            	System.out.println("Ingrese el año nuevo:");
	            	int añoPublicacion_modificada = scanner.nextInt();
	            	scanner.nextLine(); 

	            	System.out.println("Ingrese el género nuevo:");
	            	
	            	String genero_modificada = scanner.nextLine();
	            	List<libro> Libros = new ArrayList<>();
	            	Libros.add(new libro(modificar, titulo_modificada, autor_modificada, añoPublicacion_modificada, genero_modificada));
	            	
	            	gestorFicheros.actualizarLibrosBinario(Libros, "libros.bin");
	 	            System.out.println("Información guardada en archivo binario.");
	            	
	                break;
	                
	            case 4:
	            	//Eliminar datos de libro
	            	System.out.println("---------------------");
	            	System.out.println("¿Qué id quieres borrar?");
	            	int borrar_libro = scanner.nextInt();
	            	scanner.nextLine();
	            	
	            	gestorFicheros.eliminarLibroBinario(borrar_libro, "libros.bin");
	            	
	                break;
	            case 5:
	                // Salir
	                salir = true;
	                break;
	            default:
	                System.out.println("Opción no válida. Por favor intente de nuevo.");
	        }
	    }
	}
	
	//Autores
	private static void gestionarAutores() {
		// Implementar lógica para gestionar autores
		boolean salir = false;
	    while (!salir) {
	    	crudAutoresMenu();
	        int opcion3 = scanner.nextInt();
	        switch (opcion3) {
	            case 1:
	            	// Pedimos por consola al usuario todos los campos que tiene que tener autores
	            	System.out.println("---------------------");
	            	System.out.println("Ingrese el ID del autor:");
	            	int id_autor = scanner.nextInt();
	            	scanner.nextLine(); 

	            	System.out.println("Ingrese el nombre:");
	            	String nombre = scanner.nextLine();

	            	System.out.println("Ingrese la nacionalidad:");
	            	String nacionalidad = scanner.nextLine();

	            	System.out.println("Ingrese el año de nacimiento:");
	            	int añoNacimiento = scanner.nextInt();
	            	scanner.nextLine(); 
	            	
	            	listaDeAutores.add(new autor(id_autor, nombre, nacionalidad, añoNacimiento));
	            	gestionarExportAutores();
	            	
	                break;
	                
            	case 2:
	            	
            		//Mostrar todo lo recogido del case 1
            		
	            	List<autor> listaDeAutoresExistente = null;
	            	
	            	try {
	            		
	            		listaDeAutoresExistente=gestorFicheros.leerAutoresBinario("autores.bin");
	            			            		
	            	}catch (Exception e) {
						// TODO: handle exception
					}
	            	
	            	for (autor autor : listaDeAutoresExistente) {
	            		System.out.println(autor);
	            	}
	            	
	                break;
	                
            	case 3:
            		//Actualización de datos de autores            		
            		System.out.println("---------------------");
	            	System.out.println("¿Qué id quieres modificar?");
	            	int id_autor_modificar = scanner.nextInt();
	            	scanner.nextLine();

	            	System.out.println("Ingrese el nombre nuevo:");
	            	String nombre_modificado = scanner.nextLine();

	            	System.out.println("Ingrese la nacionalidad nueva:");
	            	String autor_modificada = scanner.nextLine();

	            	System.out.println("Ingrese el año nuevo:");
	            	int año_nacimiento_modificado = scanner.nextInt();
	            	scanner.nextLine(); 

	            	List<autor> Autores = new ArrayList<>();
	            	Autores.add(new autor(id_autor_modificar, nombre_modificado, autor_modificada, año_nacimiento_modificado));
	            	
	            	
	            	gestorFicheros.actualizarAutoresBinario(Autores, "autores.bin");
	 	            System.out.println("Información guardada en archivo binario.");
	            	
	                break;
	                
	            case 4:
	            	//Eliminar datos de autor
	            	System.out.println("---------------------");
	            	System.out.println("¿Qué id quieres borrar?");
	            	int borrar_autor = scanner.nextInt();
	            	scanner.nextLine();
	            	
	            	gestorFicheros.eliminarAutorBinario(borrar_autor, "autores.bin");
	            	
	                break;
	            case 5:
	                // Salir
	                salir = true;
	                break;
	            default:
	                System.out.println("Opción no válida. Por favor intente de nuevo.");
	        }
	    }
	}

	//Prestamos
	private static void gestionarPrestamos() {
		boolean salir = false;
	    while (!salir) {
	    	crudPrestamoMenu();
	        int opcion4 = scanner.nextInt();
	        switch (opcion4) {
	            case 1:
	            	// Pedimos por consola al usuario todos los campos que tiene que tener prestamo
	            	System.out.println("---------------------");
	            	System.out.println("Ingrese el ID del libro que desea prestar:");
	            	int id_libro = scanner.nextInt();
	            	scanner.nextLine(); 

	            	System.out.println("Ingrese el nombre de usuario:");
	            	String nombreUsuario = scanner.nextLine();

	            	System.out.println("Ingrese la fecha de prestamo:");
	            	String fechaPrestamo = scanner.nextLine();

	            	System.out.println("Ingrese la fecha de devolucion:");
	            	String fechaDevolucion = scanner.nextLine();
	            	
	            	Prestamo = new prestamo(id_libro, nombreUsuario, fechaPrestamo, fechaDevolucion);
	            	gestorFicheros.hacerPrestamo("prestamos.txt", Prestamo);
	                break;
	                
	            case 2:
	            	//Llamamos a mostrar prestamos libros dentro de gestor ficheros
	            	gestorFicheros.mostrarPrestamos("prestamos.txt");
	                break;
	               
	            case 3:
	                // Salir
	                salir = true;
	                break;
	            default:
	                System.out.println("Opción no válida. Por favor intente de nuevo.");
	        }
	    }
	}

	// Este metodo proporciona un menu interactivo que permite al usuario exportar e importar libros 
	private static void gestionarExportImportXML() throws ParserConfigurationException, TransformerException, SAXException, IOException {
		boolean salir = false;
	    while (!salir) {
	    	crudImportarExportarXml();
	        int opcion6 = scanner.nextInt();
	        switch (opcion6) {
	            case 1:
	            	//Llamamos a exportar libros dentro de gestor ficheros
	            	gestorFicheros.exportarLibros("libros.bin");
	            	
	                break;
	                
	            case 2:
	            	//Llamamos a importar libros dentro de gestor ficheros
	            	gestorFicheros.importarLibros("libros.bin");
	            	
	                break;
	               
	            case 3:
	                // Salir
	                salir = true;
	                break;
	            default:
	                System.out.println("Opción no válida. Por favor intente de nuevo.");
	        }
		
	    }
		
	}
	
	// Método para gestionar Exportar Libros
	private static void gestionarExportLibro() {
	    System.out.println("Pulsa 1 para terminar de guardar.");
	    int opcion5 = scanner.nextInt();

	    switch (opcion5) {
	        case 1:
	            gestorFicheros.guardarLibrosBinario(listaDeLibros, "libros.bin");
	            System.out.println("Información guardada en archivo binario.");
	            break;
	        default:
	            System.out.println("Opción no válida. Por favor intente de nuevo.");
	    }
	}
	
	// Método para gestionar Exportar Autores
	private static void gestionarExportAutores() {
	    System.out.println("Pulsa 1 para terminar de guardar.");
	    int opcion6 = scanner.nextInt();

	    switch (opcion6) {
	        case 1:
	            // Suponiendo que tienes una lista de libros (listaDeLibros) que deseas guardar en binario
	            gestorFicheros.guardarAutoresBinario(listaDeAutores, "autores.bin");
	            System.out.println("Información guardada en archivo binario.");
	            break;
	        default:
	            System.out.println("Opción no válida. Por favor intente de nuevo. gestion EXPORTAR BIN");
	    }
	}

	//
	//
	//
	//		APARTADO DE MENÚS DEL EJERCICIO
	//
	//
	//

	// Menú principal
	private static void mostrarMenu() {
		System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");
		System.out.println("1. Gestionar Libros");
		System.out.println("2. Gestionar Autores");
		System.out.println("3. Gestionar Préstamos");
		System.out.println("4. Exportar/Importar Datos (XML)");
		System.out.println("5. Salir");
		System.out.print("Seleccione una opción: ");

	}

	// Menú derivado del principal con las opcines de Libro
	private static void crudLibroMenu() {
		System.out.println("---------------------");
		System.out.println("Posibles opciones:");
		System.out.println("1. Crear nuevo libro");
		System.out.println("2. Mostrar libro");
		System.out.println("3. Actualizar libro");
		System.out.println("4. Eliminar libro");
		System.out.println("5. Salir");
		System.out.print("Seleccione una opción: ");
	}
	
	// Menú derivado del principal con las opcines de Autores
	private static void crudAutoresMenu() {
		System.out.println("---------------------");
		System.out.println("Posibles opciones:");
		System.out.println("1. Crear nuevo autor");
		System.out.println("2. Mostrar autor");
		System.out.println("3. Actualizar autor");
		System.out.println("4. Eliminar autor");
		System.out.println("5. Salir");
		System.out.print("Seleccione una opción: ");
	}

	// Menú derivado del principal con las opcines de Prestamo
	private static void crudPrestamoMenu() {
		System.out.println("---------------------");
		System.out.println("Posibles opciones:");
		System.out.println("1. Registrar prestamos");
		System.out.println("2. Mostrar prestamos");
		System.out.println("3. Salir");
		System.out.print("Seleccione una opción: ");
	}
	
	// Menú derivado del principal con las opcines de XML
	private static void crudImportarExportarXml() {
		System.out.println("---------------------");
		System.out.println("Posibles opciones:");
		System.out.println("1. Exportar Xml");
		System.out.println("2. Importar Xml");
		System.out.println("3. Salir");
		System.out.print("Seleccione una opción: ");
	}
		
}