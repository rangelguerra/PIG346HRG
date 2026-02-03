package com.energia.energia;
import com.energia.exceptions.EnergiaInvalidaException;
public class EnergiaSolar extends Energia {
    public EnergiaSolar(double produccionMWh, double consumoMWh) throws EnergiaInvalidaException {
        super("Solar", produccionMWh, consumoMWh);
    }
}
