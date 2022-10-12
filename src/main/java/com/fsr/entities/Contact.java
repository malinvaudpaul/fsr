package com.fsr.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Contact {

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "contact")
  Set<PhoneNumber> phones = new HashSet<PhoneNumber>();

  private String firstName;
  private String lastName;
  private String email;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idContact;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "idAddresse")
  private Address address;

  public Contact() {}

  public Contact(String firstName, String lastName, String email, long idContact) {
    this(firstName, lastName, email);
    this.idContact = idContact;
  }

  public Contact(String firstName, String lastName, String email) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
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

  public long getIdContact() {
    return idContact;
  }

  public void setIdContact(long idContact) {
    this.idContact = idContact;
  }

  public Set<PhoneNumber> getPhones() {
    return phones;
  }

  public void setPhones(Set<PhoneNumber> phones) {
    this.phones = phones;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
