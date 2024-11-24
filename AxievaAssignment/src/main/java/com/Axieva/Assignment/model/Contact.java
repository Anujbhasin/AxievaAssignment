package com.Axieva.Assignment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "contact_msg")
public class Contact extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name="contact_id")
    private int contactId;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3,message = "Name must be  at least  3 Characters long")
    private String name;
    @NotBlank(message = "Mobile cannot be blank")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile must be  at least  10 digits")
    private String mobileNum;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Please provide valid Email")
    private String email;

    @NotBlank(message = "Subject cannot be blank")
    @Size(min = 5,message = "Subject must be  at least  5 Characters long")
    private  String subject;

    @NotBlank(message = " Message cannot be blank")
    @Size(min = 10,message = "Message must be  at least  10 Characters long")
    private String message;

    private String status;


}
