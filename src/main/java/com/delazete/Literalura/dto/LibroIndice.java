package com.delazete.Literalura.dto;

import com.delazete.Literalura.entity.Autor;
import com.delazete.Literalura.entity.Libro;
import com.delazete.Literalura.repository.IAutorRepository;

public record LibroIndice(
        int indice,
        datosLibro libro) {
    /*
    public Libro toLibroEntity(Autor autor) { // Inyecta el repositorio de autores
        Libro libroEntity = new Libro();
        libroEntity.setTitulo(libro.titulo());
        libroEntity.setIdioma(libro.Idiomas());
        libroEntity.setTotalDeDescargas(libro.totalDedescargas());
        libroEntity.setAutor(autor);


        return libroEntity;
    }
    */
}
