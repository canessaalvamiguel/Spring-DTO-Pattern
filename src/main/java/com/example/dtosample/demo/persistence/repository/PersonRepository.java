package com.example.dtosample.demo.persistence.repository;

import com.example.dtosample.demo.persistence.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
