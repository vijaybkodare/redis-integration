package com.fnaman.redisintegration.dao;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;

//import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  
  @Column(name = "FirstName")
  private String firstName;
  @Column(name = "LastName")
  private String lastName;
  @Column(name = "DateOfBirth")
  private LocalDate dateOfBirth;
  
  // Hibernate expects entities to have a no-arg constructor,
  // though it does not necessarily have to be public.
  private Employee() {}
  
  public Employee(String firstName, String lastName, LocalDate dateOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
  }
  
  public Integer getId() {
    return this.id;
  }
  
  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public LocalDate getDateOfBirth() {
    return this.dateOfBirth;
  }
}
