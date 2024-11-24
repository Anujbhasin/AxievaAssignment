package com.Axieva.Assignment.repository;

import com.Axieva.Assignment.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {

    List<Contact> findByEmail(@Param("email")String email);

}
