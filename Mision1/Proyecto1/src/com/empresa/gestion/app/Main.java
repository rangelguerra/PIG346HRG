package Mision1.Proyecto1.src.com.empresa.gestion.app;

import Mision1.Proyecto1.src.com.empresa.gestion.model.Empleado;
import Mision1.Proyecto1.src.com.empresa.gestion.model.Gerente;
import Mision1.Proyecto1.src.com.empresa.gestion.service.NominaService;

public class Main {
    public static void main(String[] args){
        Empleado empleado1 = new Empleado("Juan", 30, 5000);
        Gerente gerente1 = new Gerente("Ana", 40, 8000, "Ventas");
        empleado1.presentarse();
        gerente1.presentarse();
        NominaService nomina = new NominaService();
        System.out.println("Salario anual Empleados: $" + nomina.calcularSalarioAnual(empleado1));
        System.out.println("Salario anual Gerentes: $" + nomina.calcularSalarioAnual(gerente1));

    }
    
}
