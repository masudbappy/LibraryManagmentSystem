package com.masudbappy.unillib.repositories;

import com.masudbappy.unillib.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
