package Mision1.Proyecto1.src.com.empresa.gestion.model;

public class Empleado extends Persona{
    private double salario;

    public Empleado(String nombre, int edad, double salario) {
        super(nombre, edad);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

   // ♻️Sobreescritura del método presentarse Polimorfismo
    @Override
    public void presentarse() {
        System.out.println("Soy el empleado " + getNombre() + " y misalario es " + salario);
    }
}
