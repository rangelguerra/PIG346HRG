package com.energia.energia;

import com.energia.exceptions.EnergiaInvalidaException;

public class EnergiaBiomasa extends Energia {
    public EnergiaBiomasa(double produccionMWh, double consumoMWh) throws EnergiaInvalidaException {
        super("Biomasa", produccionMWh, consumoMWh);
    }
}

