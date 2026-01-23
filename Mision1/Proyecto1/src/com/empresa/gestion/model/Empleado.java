package Mision1.Proyecto1.src.com.empresa.gestion.model;

public class Empleado extends Persona{
    private double salario;
    private int horasTrabajadas;
    
        // ✅ Constructor corto: (nombre, edad, salario)
    public Empleado(String nombre, int edad, double salario) {
        this(nombre, edad, true, 'M', salario, 160); // valores por defecto
    }


    public Empleado(String nombre, int edad,boolean activo,char genero, double salario, int horasTrabajadas) {
        super(nombre, edad, activo, genero);
        this.salario = salario;
        this.horasTrabajadas= horasTrabajadas;
    }
    
    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    

   // ♻️Sobreescritura del método presentarse Polimorfismo
    @Override
    public void presentarse() {
        System.out.println("Soy el empleado " + getNombre() + " y misalario es " + salario);
    }

    public double calcularSalarioMensual(){
        double valorHora =salario/160;
        double salarioFinal= valorHora * horasTrabajadas;
        return salarioFinal;
    }
    // Agregamos reglas de negocio
    public boolean esMayorDeEdad(){
        return getEdad()>=18;
    }
    public boolean puedeTrabajar(){
        return getEdad() >=18 && activo==true;
    }
    
}
