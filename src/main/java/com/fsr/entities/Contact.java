package com.fsr.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "contacts")
@Entity
public class Contact {

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "contact")
  Set<PhoneNum> phones = new HashSet<PhoneNum>();

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  private String email;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "id_address")
  private Address add;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
      name = "CTC_GRP",
      joinColumns = @JoinColumn(name = "CTC_ID"),
      inverseJoinColumns = @JoinColumn(name = "GRP_ID"))
  private Set<ContactGroup> books = new HashSet<ContactGroup>();

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

  public Set<PhoneNum> getPhones() {
    return phones;
  }

  public void setPhones(Set<PhoneNum> phones) {
    this.phones = phones;
  }

  public Address getAddress() {
    return add;
  }

  public void setAddress(Address address) {
    this.add = address;
  }
}
