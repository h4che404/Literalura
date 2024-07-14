package com.delazete.Literalura.repository;

import com.delazete.Literalura.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNombre(String nombre);
}