package com.sakthi.project.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // Auto-increment here
    private Long code;  // This will now auto-increment

    private String name;
    private String email;
    private String phone;

}