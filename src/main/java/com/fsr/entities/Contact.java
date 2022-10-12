package com.fsr.entities;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Contact {

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "contact")
  Set<PhoneNumber> phones;

  private String firstName;
  private String lastName;
  private String email;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @OneToOne(cascade = CascadeType.PERSIST)
  private Address add;

  @ManyToMany(cascade = CascadeType.PERSIST)
  private Set<ContactGroup> books;

  public Contact() {}

  public Contact(String firstName, String lastName, String email, int id, Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.id = id;
    this.add = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstname) {
    this.firstName = firstname;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastname) {
    this.lastName = lastname;
  }

  public long getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Set<PhoneNumber> getPhones() {
    return phones;
  }

  public void setPhones(Set<PhoneNumber> phones) {
    this.phones = phones;
  }

  public Address getAddress() {
    return add;
  }

  public void setAddress(Address address) {
    this.add = address;
  }
}
