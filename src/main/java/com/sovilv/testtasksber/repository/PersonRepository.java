package com.sovilv.testtasksber.repository;

import com.sovilv.testtasksber.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
