package com.delazete.Literalura.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ConvierteDatos implements IConvierteDatos {
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
