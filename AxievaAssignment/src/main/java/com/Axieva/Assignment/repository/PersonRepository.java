package com.Axieva.Assignment.repository;


import com.Axieva.Assignment.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Object> {

    public Person readByEmail(String email);
}
