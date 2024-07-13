package com.delazete.Literalura.repository;

import com.delazete.Literalura.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IAutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findAutorByNombre(String nombre);
}