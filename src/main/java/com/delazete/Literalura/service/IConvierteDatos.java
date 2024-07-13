package com.delazete.Literalura.service;

import org.springframework.stereotype.Repository;

@Repository
public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
