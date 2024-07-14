package com.delazete.Literalura.interfaz;

import com.delazete.Literalura.dto.*;
import com.delazete.Literalura.entity.Autor;
import com.delazete.Literalura.entity.Libro;
import com.delazete.Literalura.repository.IAutorRepository;
import com.delazete.Literalura.repository.ILibroRepository;
import com.delazete.Literalura.service.ConsumoApi;
import com.delazete.Literalura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Menu {



    private ConsumoApi consumoApi = new ConsumoApi();

    private ConvierteDatos convierteDatos = new ConvierteDatos();

    @Autowired
    private ILibroRepository repotorio;

    @Autowired
    private IAutorRepository autorRepository;

    public Menu (ILibroRepository repository, IAutorRepository autorRepository){
        this.repotorio = repository;
        this.autorRepository = autorRepository;
    }

    Scanner teclado = new Scanner(System.in);


    public void muestraMenu(){

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println(
                                "╔══════════════════════════════════════════════════╗\n" +
                                "║                                                  ║\n" +
                                "║              📚 Catálogo de Libros 📚            ║\n" +
                                "║                                                  ║\n" +
                                "╚══════════════════════════════════════════════════╝\n" +
                                "\n" +
                                "✨ Seleccione una opción:\n" +
                                "\n" +
                                "1. Buscar libro por título 🔍\n" +
                                "2. Listar libros registrados 📖\n" +
                                "3. Listar autores registrados ✍️\n" +
                                "4. Listar autores vivos en un año determinado ⏳\n" +
                                "5. Listar libros por idioma 🌎\n" +
                                "6. Salir del programa 👋\n" +
                                "\n" +
                                "Ingrese el número de la opción deseada: "
                );
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        try {
                            busquedaDeLibros();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        mostrarLibrosGuardados();
                        break;
                    case 3:
                        mostrarAutoresRegistrados();
                        break;
                    case 4:
                        mostrarAutoresVivos();
                        break;
                    case 5:
                        top10LiborsDescargados();
                        break;
                    case 6:
                        System.out.println("¡Hasta luego! 👋");
                        return;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            }

    }

    private void busquedaDeLibros() throws Exception {

        System.out.println("Escriba el título del libro que desea buscar: ");
        var tituloLibro = teclado.nextLine();

        var resultadoBusqueda = new ConsumoApi().buscarLibro("https://gutendex.com/books/?search=" + tituloLibro.replace(" ", "%20"));
        var results = convierteDatos.obtenerDatos(resultadoBusqueda, Datos.class);


        if (results.resultados().isEmpty()) {
            System.out.println("Libro no encontrado con el título: " + tituloLibro);
            return;
        }
        List<LibroIndice> librosConIndice = IntStream.range(0, results.resultados().size())
                .mapToObj(i -> new LibroIndice(i + 1, results.resultados().get(i)))
                .collect(Collectors.toList());
        librosConIndice.forEach(libroConIndice -> System.out.println(libroConIndice.indice() + ". " + libroConIndice.libro().titulo()));


        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione un libro por su número: ");
        int indiceSeleccionado = scanner.nextInt();

        // Validar el índice seleccionado
        if (indiceSeleccionado >= 1 && indiceSeleccionado <= librosConIndice.size()) {
            LibroIndice libroSeleccionado = librosConIndice.get(indiceSeleccionado - 1); // Ajustar índice a 0-based
            datosLibro libroDto = libroSeleccionado.libro();
            datosAutor autorDto = libroDto.autores().get(0); // Suponiendo que tienes un método autores() en datosLibro
            Autor nuevoAutor = new Autor(autorDto.nombre(), autorDto.fechaNacimiento(), autorDto.fechaDefallecimiento());




            // Ahora puedes usar libroDto para mostrar los detalles del libro seleccionado
            System.out.println("Detalles del libro seleccionado:");
            System.out.println("Título: " + libroDto.titulo());
            // ... mostrar otros detalles
            System.out.print("Deseas guardar el libro?: \n 1-SI \n 2-NO");
            int opcion = teclado.nextInt();
            if (opcion == 1){
                Libro libro = new Libro(libroDto);
                repotorio.save(libro);
                autorRepository.save(nuevoAutor);
            }
        } else {
            System.out.println("Número de libro inválido.");
        }



    }
        private void mostrarLibrosGuardados(){
            List<Libro> libros = repotorio.findAll();

            libros.stream()
                    .sorted(Comparator.comparing(Libro::getTitulo))
                    .forEach(System.out::println);
        }

        private void mostrarAutoresRegistrados(){
            List<Autor> autors = autorRepository.findAll();

            autors.stream()
                    .forEach(System.out::println);
        }

    private void mostrarAutoresVivos(){
        List<Autor> autors = autorRepository.findAll();

        long cantidadAutoresVivos = autors.stream()
                .filter(a -> a.getFechaDefuncion() > 2023)
                .peek(System.out::println)
                .count();
        if (cantidadAutoresVivos == 0) {
            System.out.println("Todos los autores registrados han fallecido.");
        }
    }
    private void top10LiborsDescargados() {
        System.out.println("\n Top 5 libros más descargados:\n");
        List<Libro> libros = repotorio.findTop10Descargados();
        libros.forEach(System.out::println);
    }



}
