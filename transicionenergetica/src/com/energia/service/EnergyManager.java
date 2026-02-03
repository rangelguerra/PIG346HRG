package com.energia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.energia.exceptions.RegionNoEncontradaException;
import com.energia.model.Region;
import com.energia.model.Storage;

public class EnergyManager {

    private final List<Region> regiones = new ArrayList<>();
    private final Storage storage;

    public EnergyManager(Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public void registrarRegion(Region region) {
        regiones.add(region);
    }

    public List<Region> listarRegiones() {
        return regiones;
    }

    public Region buscarRegion(String nombre) throws RegionNoEncontradaException {
        Optional<Region> r = regiones.stream()
                .filter(x -> x.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
        if (r.isEmpty()) throw new RegionNoEncontradaException("Región no encontrada: " + nombre);
        return r.get();
    }

    /**
     * Simula un escenario: factorProduccion y factorConsumo (ej: 1.10 = +10%).
     * Devuelve un resumen del impacto.
     */
    public String simularEscenario(String regionNombre, double factorProduccion, double factorConsumo)
            throws RegionNoEncontradaException {

        Region region = buscarRegion(regionNombre);

        double prodBase = region.getProduccionTotal();
        double consBase = region.getConsumoTotal();

        double prodSim = prodBase * factorProduccion;
        double consSim = consBase * factorConsumo;
        double balanceSim = prodSim - consSim;

        return String.format(
            "ESCENARIO [%s] | ProdBase=%.2f -> ProdSim=%.2f | ConsBase=%.2f -> ConsSim=%.2f | BalanceSim=%.2f",
            region.getNombre(), prodBase, prodSim, consBase, consSim, balanceSim
        );
    }
}
