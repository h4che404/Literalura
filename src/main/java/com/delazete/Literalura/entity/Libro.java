package com.delazete.Literalura.entity;

import com.delazete.Literalura.dto.Datos;
import com.delazete.Literalura.dto.datosLibro;
import com.delazete.Literalura.dto.Idiomas;
import jakarta.persistence.*;
import jdk.jfr.Name;

import java.util.List;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(unique = true)
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Idiomas idioma;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Autor autor;
    private double totalDeDescargas;

    public Libro() {
    }

    public Libro(datosLibro datosdelibro) {
        this.titulo = datosdelibro.titulo();
        this.totalDeDescargas = datosdelibro.totalDedescargas();
        this.idioma =Idiomas.fromString(datosdelibro.Idiomas().toString());
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setTotalDeDescargas(double totalDeDescargas) {
        this.totalDeDescargas = totalDeDescargas;
    }

    public Idiomas getIdioma() {
        return idioma;
    }

    public void setIdioma(Idiomas idioma) {
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


    @Override
    public String toString() {
        String newLibro= "------- LIBRO -------\n" +
                "Título: " + titulo + "\n" +
                "Idioma: " + idioma.name() + "\n" +
                "Numero de descargas: " + totalDeDescargas + "\n";

        return newLibro;
    }
}