package com.energia.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.energia.energia.*;
import com.energia.exceptions.EnergiaInvalidaException;
import com.energia.exceptions.RegionNoEncontradaException;
import com.energia.model.Region;
import com.energia.model.Storage;
import com.energia.service.EnergyManager;

public class App {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            EnergyManager manager = new EnergyManager(new Storage(5000)); // 5000 MWh
            seedData(manager); // datos iniciales para probar

            int opcion = -1;
            do {
                mostrarMenu();
                opcion = leerEntero(sc);

                try {
                    switch (opcion) {
                        case 1 -> crearRegion(sc, manager);
                        case 2 -> registrarEnergiaEnRegion(sc, manager);
                        case 3 -> listarRegiones(manager);
                        case 4 -> verDetalleRegion(sc, manager);
                        case 5 -> verStorage(manager);
                        case 6 -> cargarStorage(sc, manager);
                        case 7 -> descargarStorage(sc, manager);
                        case 8 -> simular(sc, manager);
                        case 0 -> System.out.println("Saliendo...");
                        default -> System.out.println("Opción inválida.");
                    }
                } catch (EnergiaInvalidaException | RegionNoEncontradaException e) {
                    System.out.println("ERROR: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("ERROR inesperado: " + e.getMessage());
                }

            } while (opcion != 0);
        } catch (EnergiaInvalidaException e) {
            System.out.println("Error inicializando el sistema: " + e.getMessage());
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== TRANSICIÓN ENERGÉTICA (POO) ===");
        System.out.println("1. Registrar región");
        System.out.println("2. Registrar energía en región");
        System.out.println("3. Listar regiones (resumen)");
        System.out.println("4. Ver detalle de una región");
        System.out.println("5. Ver almacenamiento (storage)");
        System.out.println("6. Cargar storage");
        System.out.println("7. Descargar storage");
        System.out.println("8. Simular escenario");
        System.out.println("0. Salir");
        System.out.print("Seleccione opción: ");
    }

    private static int leerEntero(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Ingrese un número válido: ");
                sc.nextLine();
            }
        }
    }

    private static double leerDouble(Scanner sc) {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Ingrese un número decimal válido: ");
                sc.nextLine();
            }
        }
    }

    private static void crearRegion(Scanner sc, EnergyManager manager) {
        sc.nextLine(); // limpia buffer
        System.out.print("Nombre región: ");
        String nombre = sc.nextLine();
        System.out.print("Ubicación (texto libre): ");
        String ubicacion = sc.nextLine();

        manager.registrarRegion(new Region(nombre, ubicacion));
        System.out.println("Región registrada.");
    }

    private static void registrarEnergiaEnRegion(Scanner sc, EnergyManager manager)
            throws RegionNoEncontradaException, EnergiaInvalidaException {

        sc.nextLine();
        System.out.print("Nombre de la región: ");
        String regionNombre = sc.nextLine();
        Region region = manager.buscarRegion(regionNombre);

        System.out.println("Tipo energía: 1)Solar 2)Eólica 3)Hidro 4)Biomasa 5)Geotérmica");
        int tipo = leerEntero(sc);

        System.out.print("Producción anual (MWh): ");
        double prod = leerDouble(sc);

        System.out.print("Consumo anual (MWh): ");
        double cons = leerDouble(sc);

        IEnergia energia = switch (tipo) {
            case 1 -> new EnergiaSolar(prod, cons);
            case 2 -> new EnergiaEolica(prod, cons);
            case 3 -> new EnergiaHidro(prod, cons);
            case 4 -> new EnergiaBiomasa(prod, cons);
            case 5 -> new EnergiaGeotermica(prod, cons);
            default -> throw new EnergiaInvalidaException("Tipo de energía inválido.");
        };

        region.agregarEnergia(energia);
        System.out.println("Energía registrada en la región.");
    }

    private static void listarRegiones(EnergyManager manager) {
        if (manager.listarRegiones().isEmpty()) {
            System.out.println("No hay regiones registradas.");
            return;
        }
        manager.listarRegiones().forEach(r -> System.out.println(r));
    }

    private static void verDetalleRegion(Scanner sc, EnergyManager manager)
            throws RegionNoEncontradaException {

        sc.nextLine();
        System.out.print("Nombre de la región: ");
        String nombre = sc.nextLine();

        Region r = manager.buscarRegion(nombre);
        System.out.println(r);

        if (r.getEnergias().isEmpty()) {
            System.out.println("  (Sin energías registradas)");
            return;
        }
        System.out.println("  Energías:");
        r.getEnergias().forEach(e -> System.out.println("   - " + e.toString()));
    }

    private static void verStorage(EnergyManager manager) {
        System.out.println(manager.getStorage());
    }

    private static void cargarStorage(Scanner sc, EnergyManager manager) throws EnergiaInvalidaException {
        System.out.print("MWh a cargar: ");
        double mwh = leerDouble(sc);
        manager.getStorage().cargar(mwh);
        System.out.println("Carga exitosa. " + manager.getStorage());
    }

    private static void descargarStorage(Scanner sc, EnergyManager manager) throws EnergiaInvalidaException {
        System.out.print("MWh a descargar: ");
        double mwh = leerDouble(sc);
        manager.getStorage().descargar(mwh);
        System.out.println("Descarga exitosa. " + manager.getStorage());
    }

    private static void simular(Scanner sc, EnergyManager manager) throws RegionNoEncontradaException {
        sc.nextLine();
        System.out.print("Región a simular: ");
        String region = sc.nextLine();

        System.out.print("Factor producción (ej 1.10 = +10%): ");
        double fp = leerDouble(sc);

        System.out.print("Factor consumo (ej 0.95 = -5%): ");
        double fc = leerDouble(sc);

        System.out.println(manager.simularEscenario(region, fp, fc));
    }

    private static void seedData(EnergyManager manager) throws EnergiaInvalidaException {
        Region latam = new Region("LATAM", "América Latina");
        latam.agregarEnergia(new EnergiaSolar(1200, 900));
        latam.agregarEnergia(new EnergiaEolica(800, 600));

        Region europa = new Region("EUROPA", "Europa");
        europa.agregarEnergia(new EnergiaHidro(1500, 1400));
        europa.agregarEnergia(new EnergiaGeotermica(300, 250));

        manager.registrarRegion(latam);
        manager.registrarRegion(europa);
    }
}
