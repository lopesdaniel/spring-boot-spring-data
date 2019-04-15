package com.danieldev.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danieldev.api.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

}
