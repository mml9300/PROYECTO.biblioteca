package biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class gestorficheros {
	libro Libro = new libro(0, "", "", 0, "");

	// Método para guardar la información de libros en un archivo binario
	public void guardarLibrosBinario(List<libro> libros, String filename) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(libros);
			System.out.println("Información de libros guardada en archivo binario.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para leer la información de libros desde un archivo binario
	public List<libro> leerLibrosBinario(String filename) {
		List<libro> libros = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			libros = (List<libro>) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return libros;
	}

	// Método para actualizar la información de libros de un archivo binario
	public void actualizarLibrosBinario(List<libro> Libros, String filename) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(Libros);
			System.out.println("Información de libros actualizada en el archivo binario.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para borrar información de libros de un archivo binario
	public void eliminarLibroBinario(int z, String filename) {

		List<libro> libros = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			libros = (List<libro>) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).getId_libro() == z) {
				libros.set(i, null);
				break;
			}
		}

		libros.removeIf(libro -> libro == null);

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(libros);
			System.out.println("Libro eliminado y información actualizada en el archivo binario.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//--------------------------------------------------------------------
	// Método para guardar la información de autores en un archivo binario
	public void guardarAutoresBinario(List<autor> autores, String filename) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(autores);
			System.out.println("Información de autores guardada en archivo binario.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para leer la información de autores de un archivo binario
	public List<autor> leerAutoresBinario(String filename) {
		List<autor> autores = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			autores = (List<autor>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return autores;
	}
	
	
	// Método para actualizar la información de autores de un archivo binario
	public void actualizarAutoresBinario(List<autor> Autores, String filename) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(Autores);
			System.out.println("Información de autores actualizada en el archivo binario.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Método para borrar la información de autores de un archivo binario
	public void eliminarAutorBinario(int z, String filename) {

		List<autor> autores = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			autores = (List<autor>) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < autores.size(); i++) {
			if (autores.get(i).getId() == z) {
				autores.set(i, null);
				break;
			}
		}

		autores.removeIf(autor -> autor == null);

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(autores);
			System.out.println("Autor eliminado y información actualizada en el archivo binario.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//-------------------------------------------------
	// Método exportar Libros en XML		
	public void exportarLibros(String filename) throws ParserConfigurationException, TransformerException {
		
		List<libro> libro = leerLibrosBinario(filename);
		
		// Creacion de documento XML
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();

		// Crear el elemento raíz
		Element rootElement = doc.createElement("libros");
		doc.appendChild(rootElement);

		// Crear elementos 
		for (int i=0; i<libro.size(); i++) {
			Element libroElement = doc.createElement("libro");
			rootElement.appendChild(libroElement);

			Element idElement = doc.createElement("id");
			idElement.appendChild(doc.createTextNode(String.valueOf(libro.get(i).getId_libro())));
			libroElement.appendChild(idElement);
			
			Element autorElement = doc.createElement("autor");
			autorElement.appendChild(doc.createTextNode(String.valueOf(libro.get(i).getAutor())));
			libroElement.appendChild(autorElement);

			Element tituloElement = doc.createElement("titulo");
			tituloElement.appendChild(doc.createTextNode(libro.get(i).getTitulo()));
			libroElement.appendChild(tituloElement);

			Element generoElement = doc.createElement("genero");
			generoElement.appendChild(doc.createTextNode(libro.get(i).getGenero()));
			libroElement.appendChild(generoElement);

			Element añoPublicacionElement = doc.createElement("añoPublicacion");
			añoPublicacionElement.appendChild(doc.createTextNode(String.valueOf(libro.get(i).getAño_de_publicacion())));
			libroElement.appendChild(añoPublicacionElement);
		}

		// Escribir el contenido del documento XML en un archivo
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("libros.xml"));
		transformer.transform(source, result);

		System.out.println("Libros exportados a XML correctamente.");
		
	}

	// Método importar Libros en XML
	public void importarLibros(String filename) throws SAXException, IOException, ParserConfigurationException {
		
		// Parsear el documento XML
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("libros.xml"));

		// Obtener el nodo raíz "libros"
		Element rootElement = document.getDocumentElement();

		// Obtener la lista de nodos de libros
		NodeList nodeList = document.getElementsByTagName("libro");

		List<libro> libro = new ArrayList<libro>();

		// Recorrer la lista de nodos y crear objetos Libro
		for (int i = 0; i < nodeList.getLength(); i++) {
			libro Libro = new libro(0, "", "", 0, "");
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				Libro.setId_libro(Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()));
				Libro.setAutor(element.getElementsByTagName("autor").item(0).getTextContent());
				Libro.setTitulo(element.getElementsByTagName("titulo").item(0).getTextContent());
				Libro.setGenero(element.getElementsByTagName("genero").item(0).getTextContent());
				Libro.setAño_de_publicacion(Integer.parseInt(element.getElementsByTagName("añoPublicacion").item(0).getTextContent()));
				libro.add(Libro);
			}
		}

		// Escribir el ArrayList de objetos Libro en un archivo binario
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("libros.bin"))) {
			oos.writeObject(libro);
			System.out.println("Objetos Libro escritos en el archivo binario.");
		} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	//-------------------------------------------------------
	// Método para crear prestamos
	public void hacerPrestamo(String archivo, prestamo Prestamo) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
            bw.write(Prestamo.toString());
            bw.newLine();
            bw.close();
            System.out.println("Préstamo guardado en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el préstamo: " + e.getMessage());
        }
    }

	// Método para mostrar prestamos
    public void mostrarPrestamos(String archivoPrestamos) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(archivoPrestamos));
            String linea = buffer.readLine();
            if (linea == null) {
                System.out.println("El archivo de préstamos está vacío.");
            } else {
                while (linea != null) {
                    System.out.println(linea);
                    linea = buffer.readLine();
                }
            }
            buffer.close();

        } catch (IOException exception) {
            System.out.println("Error al acceder al fichero");
        }
    }

}