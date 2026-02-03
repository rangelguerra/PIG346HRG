package com.energia.energia;

public interface IEnergia {
    String getTipo();
    double getProduccionMWh();   // producción anual (MWh)
    double getConsumoMWh();      // consumo anual (MWh)

    double calcularBalanceMWh(); // producción - consumo
    double calcularEficiencia(); // ejemplo simple: producción/consumo (si consumo>0)
}

