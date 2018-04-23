package com.masudbappy.unillib.repositories;

import com.masudbappy.unillib.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends JpaRepository<Book, Long > {
        Book findByTitle(String title);
}
