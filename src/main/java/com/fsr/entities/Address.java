package com.fsr.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "addresses")
@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String street;
  private String city;
  private String zip;
  private String country;

  public Address() {}

  public Address(String street, String city, String zip, String country) {
    this.street = street;
    this.city = city;
    this.zip = zip;
    this.country = country;
  }

  public String getStreet() {
    return street;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setStreet(String street) {
    this.street = street;
  }
}
