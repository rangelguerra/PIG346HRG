package com.energia.model;

import com.energia.exceptions.EnergiaInvalidaException;

public class Storage {

    private double capacidadMWh;  // capacidad máxima
    private double almacenadoMWh; // energía almacenada actual

    public Storage(double capacidadMWh) throws EnergiaInvalidaException {
        if (capacidadMWh < 0) throw new EnergiaInvalidaException("La capacidad no puede ser negativa.");
        this.capacidadMWh = capacidadMWh;
        this.almacenadoMWh = 0;
    }

    public double getCapacidadMWh() { return capacidadMWh; }
    public double getAlmacenadoMWh() { return almacenadoMWh; }

    public void cargar(double mwh) throws EnergiaInvalidaException {
        if (mwh < 0) throw new EnergiaInvalidaException("No se puede cargar un valor negativo.");
        if (almacenadoMWh + mwh > capacidadMWh) {
            throw new EnergiaInvalidaException("No hay capacidad suficiente para cargar " + mwh + " MWh.");
        }
        almacenadoMWh += mwh;
    }

    public void descargar(double mwh) throws EnergiaInvalidaException {
        if (mwh < 0) throw new EnergiaInvalidaException("No se puede descargar un valor negativo.");
        if (mwh > almacenadoMWh) {
            throw new EnergiaInvalidaException("No hay suficiente energía almacenada para descargar " + mwh + " MWh.");
        }
        almacenadoMWh -= mwh;
    }

    @Override
    public String toString() {
        return String.format("Storage | Capacidad: %.2f MWh | Almacenado: %.2f MWh", capacidadMWh, almacenadoMWh);
    }
}

