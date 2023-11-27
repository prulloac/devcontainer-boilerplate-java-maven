package dev.prulloac.crudrestapidemo.repository;

import dev.prulloac.crudrestapidemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
