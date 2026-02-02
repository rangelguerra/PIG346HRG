package gestionbiblioteca.gbiblioteca.src.com.biblioteca.gestion.service;

import java.util.ArrayList;

import gestionbiblioteca.gbiblioteca.src.com.biblioteca.gestion.model.Libro;

public class LibroService {
    private ArrayList<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado correctamente.");
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro l : libros) {
            System.out.println(l.resumen());
        }
    }

    public void eliminarLibro(String isbn) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equalsIgnoreCase(isbn)) {
                libros.remove(i);
                System.out.println("Libro eliminado.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    public void consultarLibro(String valor) {
        for (Libro l : libros) {
            if (l.getIsbn().equalsIgnoreCase(valor)
                || l.getTitulo().equalsIgnoreCase(valor)
                || l.getAutor().equalsIgnoreCase(valor)) {
                System.out.println(l.resumen());
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }
}

