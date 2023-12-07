package biblioteca;

// Declaramos la clase prestamo con todas las variables y con su correspondiente constructor
public class prestamo {
    private int id_libro;
    private String nombreUsuario;
    private String fechaPrestamo;
    private String fechaDevolucion;

    public prestamo(int id_libro, String nombreUsuario, String fechaPrestamo, String fechaDevolucion) {
        this.id_libro = id_libro;
        this.nombreUsuario = nombreUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getIdLibro() {
        return id_libro;
    }

    public void setIdLibro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    // Usamos este método para representar el objeto como una cadena de texto 
    public String toString() {
        return "ID: " + id_libro +
	            ", Usuario: '" + nombreUsuario + '\'' +
	            ", Fecha Prestamo: '" + fechaPrestamo + '\'' +
	            ", Año de publicación: " + fechaDevolucion ;
    }
}