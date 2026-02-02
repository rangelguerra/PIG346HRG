package gestionbiblioteca.gbiblioteca.src.com.biblioteca.gestion.app;
import java.util.InputMismatchException;
import java.util.Scanner;

import gestionbiblioteca.gbiblioteca.src.com.biblioteca.gestion.model.Libro;
import gestionbiblioteca.gbiblioteca.src.com.biblioteca.gestion.service.LibroService;

public class App {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibroService service = new LibroService();
        int opcion = -1;

        System.out.println("=== SISTEMA DE GESTIÓN DE LIBROS ===");

        do {
            try {
                mostrarMenu();
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        agregarLibro(sc, service);
                        break;
                    case 2:
                        service.listarLibros();
                        break;
                    case 3:
                        System.out.println("Ingrese título o autor o ISBN:");
                        sc.nextLine(); // limpia buffer
                        service.consultarLibro(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Ingrese el ISBN a eliminar:");
                        sc.nextLine(); // limpia buffer
                        service.eliminarLibro(sc.nextLine());
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número.");
                sc.nextLine(); // limpia entrada inválida
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                sc.nextLine();
            }
        } while (opcion != 0);

        sc.close();
        System.out.println("=== PROGRAMA FINALIZADO ===");
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENU DE LIBROS ===");
        System.out.println("1. Agregar libro");
        System.out.println("2. Listar libros");
        System.out.println("3. Consultar libro");
        System.out.println("4. Eliminar libro");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarLibro(Scanner sc, LibroService service) {
        sc.nextLine(); // limpia buffer por si vienes de nextInt()

        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("TÍTULO: ");
        String titulo = sc.nextLine();

        System.out.print("AUTOR: ");
        String autor = sc.nextLine();

        Libro libro = new Libro(isbn, titulo, autor);
        service.agregarLibro(libro);
    }
}

