package Mision1.Proyecto1.src.com.empresa.gestion.service;

import Mision1.Proyecto1.src.com.empresa.gestion.model.Empleado;

public class NominaService {
     public double calcularSalarioAnual(Empleado empleado) {
        return empleado.getSalario() * 12;
        
    }
    
}
