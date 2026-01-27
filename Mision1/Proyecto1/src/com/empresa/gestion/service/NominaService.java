package Mision1.Proyecto1.src.com.empresa.gestion.service;

import Mision1.Proyecto1.src.com.empresa.gestion.model.Empleado;

public class NominaService {
<<<<<<< HEAD
     public double calcularSalarioAnual(Empleado empleado) {
=======
      public double calcularSalarioAnual(Empleado empleado) {
>>>>>>> 9b8e5ed (27enero26)
        return empleado.getSalario() * 12;
        
    }
    public double calcularTotalNomina(double[] salarios){
        double total=0;
        for(int i=0;i<salarios.length;i++){
            total+=salarios[i];
        }
        return total;
    }
<<<<<<< HEAD
=======
    public void simularPagos(int meses){
        int contador =1;
        while (contador<=meses) {
            System.out.println("Procesando nómina del mes:"+contador);
            contador++;
            //contador=contador+1;
            
        }
    }
>>>>>>> 9b8e5ed (27enero26)
    
}
