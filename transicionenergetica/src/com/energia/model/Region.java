package com.energia.model;

import java.util.ArrayList;
import java.util.List;

import com.energia.energia.IEnergia;

public class Region {

    private final String nombre;
    private final String ubicacion; // texto libre: país/continente etc.
    private final List<IEnergia> energias = new ArrayList<>();

    public Region(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }

    public void agregarEnergia(IEnergia energia) {
        energias.add(energia);
    }

    public List<IEnergia> getEnergias() {
        return energias;
    }

    public double getProduccionTotal() {
        return energias.stream().mapToDouble(IEnergia::getProduccionMWh).sum();
    }

    public double getConsumoTotal() {
        return energias.stream().mapToDouble(IEnergia::getConsumoMWh).sum();
    }

    public double getBalanceTotal() {
        return getProduccionTotal() - getConsumoTotal();
    }

    public double getEficienciaPromedio() {
        if (energias.isEmpty()) return 0.0;
        return energias.stream().mapToDouble(IEnergia::calcularEficiencia).average().orElse(0.0);
    }

    @Override
    public String toString() {
        return String.format(
            "Región: %s (%s) | Producción: %.2f | Consumo: %.2f | Balance: %.2f | Eficiencia prom: %.2f",
            nombre, ubicacion, getProduccionTotal(), getConsumoTotal(), getBalanceTotal(), getEficienciaPromedio()
        );
    }
}

