package com.energia.energia;

import com.energia.exceptions.EnergiaInvalidaException;

public class EnergiaHidro extends Energia {
    public EnergiaHidro(double produccionMWh, double consumoMWh) throws EnergiaInvalidaException {
        super("Hidroeléctrica", produccionMWh, consumoMWh);
    }
}

