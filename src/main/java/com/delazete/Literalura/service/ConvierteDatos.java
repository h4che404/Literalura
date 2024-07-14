package com.delazete.Literalura.service;

import com.delazete.Literalura.dto.Datos;
import com.delazete.Literalura.dto.datosLibro;
import com.delazete.Literalura.entity.Autor;
import com.delazete.Literalura.entity.Libro;
import com.delazete.Literalura.repository.IAutorRepository;
import com.delazete.Literalura.repository.ILibroRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class ConvierteDatos implements IConvierteDatos {

    @Autowired
    private ILibroRepository libroRepository;

    @Autowired
    private IAutorRepository autorRepository;


    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}