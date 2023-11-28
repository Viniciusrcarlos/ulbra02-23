package com.aula.ulbra.tde.repositories;

import com.aula.ulbra.tde.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
