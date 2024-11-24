package com.Axieva.Assignment.service;


import com.Axieva.Assignment.constants.EazySchoolConstants;
import com.Axieva.Assignment.model.Contact;
import com.Axieva.Assignment.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ContactService {


    @Autowired
    private ContactRepository contactRepository;


    public ContactService() {
        System.out.println("Contact Service Inisilized");
    }


}
