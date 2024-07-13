package com.delazete.Literalura.entity;

import com.delazete.Literalura.dto.datosAutor;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;
    @Column(unique = true)
    private String nombre;
    private int fechaNacimiento;
    private int fechaDefuncion;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libro;

    public Autor() {
    }

    public Autor(String nombre, int fechaNacimiento, int fechaDefuncion) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDefuncion = fechaDefuncion;

    }

    public Autor(datosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.fechaNacimiento = datosAutor.fechaNacimiento();
        this.fechaDefuncion = datosAutor.fechaDefallecimiento();
    }

    public int getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(int fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public List<Libro> getLibro() {
        return libro;
    }
    public String librosAutor (List<Libro> libro) {
        return libro.stream()
                .map(Libro::getTitulo).collect(Collectors.joining("\n"));

    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        String datosAutor = "---------AUTOR---------\n" +
                "Nombre:            " + nombre + "\n" +
                "Fecha de nacimiento: " + fechaNacimiento + "\n" +
                "Fecha de defuncion: " + fechaDefuncion +
                "\nLibros publicados: \n" + librosAutor(libro)+ "\n";
        return datosAutor;
    }



}