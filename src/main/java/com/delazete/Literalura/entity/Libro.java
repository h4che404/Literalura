package com.delazete.Literalura.entity;

import com.delazete.Literalura.dto.Datos;
import com.delazete.Literalura.dto.datosLibro;
import com.delazete.Literalura.dto.Idiomas;
import jakarta.persistence.*;
import jdk.jfr.Name;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @Column(unique = true)
    @Name(value = "titulo")
    private String titulo;
    private String idioma;
    @ManyToOne
    @JoinColumn(name = "idAutor")
    private Autor autor;
    private double totalDeDescargas;

    public Libro(Datos datos) {
    }

    public Libro(datosLibro datosdelibro) {
        this.titulo = datosdelibro.titulo();
        this.totalDeDescargas = datosdelibro.totalDedescargas();
        this.autor = (Autor) datosdelibro.autores();
        this.idioma =Idiomas.fromString(datosdelibro.Idiomas().toString());
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getTotalDeDescargas() {
        return totalDeDescargas;
    }

    public void setTotalDeDescargas(int totalDeDescargas) {
        this.totalDeDescargas = totalDeDescargas;
    }

    @Override
    public String toString() {
        String newLibro= "------- LIBRO -------\n" +
                "Título: " + titulo + "\n" +
                "Autor: " + autor.getNombre() + "\n" +
                "Idioma: " + Idiomas.valueOf(idioma)+ "\n" +
                "Numero de descargas: " + totalDeDescargas + "\n";

        return newLibro;
    }
}