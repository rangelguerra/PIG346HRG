package Mision1.Proyecto1.src.com.empresa.gestion.model;

public class Persona {
     //🔐 Encapsulación
    private String nombre;
    private int edad;
    //🧱 Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
//Método
    public void presentarse(){
        System.out.println("Hola, soy"+nombre+" y tengo "+edad+" años");
    }
}
