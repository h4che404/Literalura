package com.delazete.Literalura.interfaz;

import com.delazete.Literalura.dto.Datos;
import com.delazete.Literalura.dto.datosLibro;
import com.delazete.Literalura.entity.Autor;
import com.delazete.Literalura.entity.Libro;
import com.delazete.Literalura.repository.ILibroRepository;
import com.delazete.Literalura.service.ConsumoApi;
import com.delazete.Literalura.service.ConvierteDatos;
import com.delazete.Literalura.service.LibroService;

import java.util.Comparator;

public class Menu {
    private ConsumoApi consumoApi = new ConsumoApi();

    private ConvierteDatos convierteDatos = new ConvierteDatos();

    private ILibroRepository repotorio;


    public void muestraMenu(){
        var json = consumoApi.buscarLibro("https://gutendex.com/books/?search=quijote");
        System.out.println(json);
        var datos = convierteDatos.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        //top 10 libros mas descargados
      datos.resultados().stream()
                .sorted(Comparator.comparing(datosLibro::totalDedescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);

        Libro libro1 = new Libro(datos);
        repotorio.save(libro1);
    }
}
