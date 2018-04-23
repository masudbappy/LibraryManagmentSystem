package com.masudbappy.unillib.repositories;

import com.masudbappy.unillib.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
