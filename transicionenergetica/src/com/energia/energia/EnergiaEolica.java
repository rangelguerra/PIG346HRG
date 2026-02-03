package com.energia.energia;

import com.energia.exceptions.EnergiaInvalidaException;

public class EnergiaEolica extends Energia {
    public EnergiaEolica(double produccionMWh, double consumoMWh) throws EnergiaInvalidaException {
        super("Eólica", produccionMWh, consumoMWh);
    }
}
