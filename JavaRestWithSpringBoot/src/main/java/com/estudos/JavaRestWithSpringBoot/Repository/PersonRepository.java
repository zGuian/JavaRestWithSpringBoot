package com.estudos.JavaRestWithSpringBoot.Repository;

import com.estudos.JavaRestWithSpringBoot.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
