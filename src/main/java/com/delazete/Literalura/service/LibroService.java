package com.delazete.Literalura.service;

import com.delazete.Literalura.entity.Libro;
import com.delazete.Literalura.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired
    private ILibroRepository libroRepository;

    public void guardarLibro(Libro libro) {
        libroRepository.save(libro);
    }

}