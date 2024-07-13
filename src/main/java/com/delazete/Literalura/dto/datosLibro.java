package com.delazete.Literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record datosLibro(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<datosAutor> autores,
        @JsonAlias("languages") List<String> Idiomas,
        @JsonAlias("download_count") Double totalDedescargas) {
}
