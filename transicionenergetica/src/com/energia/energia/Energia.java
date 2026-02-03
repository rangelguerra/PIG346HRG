package com.energia.energia;
import com.energia.exceptions.EnergiaInvalidaException;
public abstract class Energia implements IEnergia {

    private final String tipo;
    private double produccionMWh;
    private double consumoMWh;

    protected Energia(String tipo, double produccionMWh, double consumoMWh) throws EnergiaInvalidaException {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new EnergiaInvalidaException("El tipo de energía no puede estar vacío.");
        }
        if (produccionMWh < 0 || consumoMWh < 0) {
            throw new EnergiaInvalidaException("Producción/consumo no pueden ser negativos.");
        }
        this.tipo = tipo;
        this.produccionMWh = produccionMWh;
        this.consumoMWh = consumoMWh;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public double getProduccionMWh() {
        return produccionMWh;
    }

    @Override
    public double getConsumoMWh() {
        return consumoMWh;
    }

    public void setProduccionMWh(double produccionMWh) throws EnergiaInvalidaException {
        if (produccionMWh < 0) throw new EnergiaInvalidaException("Producción no puede ser negativa.");
        this.produccionMWh = produccionMWh;
    }

    public void setConsumoMWh(double consumoMWh) throws EnergiaInvalidaException {
        if (consumoMWh < 0) throw new EnergiaInvalidaException("Consumo no puede ser negativo.");
        this.consumoMWh = consumoMWh;
    }

    @Override
    public double calcularBalanceMWh() {
        return produccionMWh - consumoMWh;
    }

    @Override
    public double calcularEficiencia() {
        if (consumoMWh == 0) return produccionMWh > 0 ? 1.0 : 0.0;
        return produccionMWh / consumoMWh;
    }

    @Override
    public String toString() {
        return String.format(
            "%s | Producción: %.2f MWh | Consumo: %.2f MWh | Balance: %.2f MWh | Eficiencia: %.2f",
            tipo, produccionMWh, consumoMWh, calcularBalanceMWh(), calcularEficiencia()
        );
    }
}
