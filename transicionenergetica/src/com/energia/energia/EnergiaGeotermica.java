package com.energia.energia;

import com.energia.exceptions.EnergiaInvalidaException;

public class EnergiaGeotermica extends Energia {
    public EnergiaGeotermica(double produccionMWh, double consumoMWh) throws EnergiaInvalidaException {
        super("Geotérmica", produccionMWh, consumoMWh);
    }
}

