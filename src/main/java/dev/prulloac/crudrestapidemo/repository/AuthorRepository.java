package dev.prulloac.crudrestapidemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.prulloac.crudrestapidemo.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{   
    Optional<Author> findByName(String name); 
} 