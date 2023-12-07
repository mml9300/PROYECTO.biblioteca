package biblioteca;

import java.io.Serializable;

//Declaramos la clase prestamo con todas las variables y con su correspondiente constructor
public class autor implements Serializable{
    private int id_autor;
    private String nombre;
    private String nacionalidad;
    private int añoNacimiento;

    // Creamos el constructor con las clases
    
    public autor(int id_autor, String nombre, String nacionalidad, int añoNacimiento) {
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.añoNacimiento = añoNacimiento;
    }

    public int getId() {
        return id_autor;
    }

    public void setId(int id) {
        this.id_autor = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }
    
    // Usamos este método para representar el objeto como una cadena de texto 
    public String toString() {
	    return "Autor " + id_autor + " {" +
	            "ID: " + id_autor +
	            ", Nombre: " + nombre+ '\'' +
	            ", Nacionalidad: " + nacionalidad + '\'' +
	            ", Año de Nacimiento: " + añoNacimiento + '}';
    }
    
}