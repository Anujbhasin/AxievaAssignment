package com.Axieva.Assignment.rest;

import com.Axieva.Assignment.model.Contact;
import com.Axieva.Assignment.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/contact")
public class ContactRestController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/getMessagesByEmail/{email}")
    //@ResponseBody
    public List<Contact> getMessagesByStatus(@PathVariable String email){
        return contactRepository.findByEmail(email);
    }
    @GetMapping("/getAll")
   // @ResponseBody
    public List<Contact> getAll(){
            return contactRepository.findAll();

    }

}
