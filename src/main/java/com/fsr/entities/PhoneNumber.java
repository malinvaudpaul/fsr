package com.fsr.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PhoneNumber {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String phoneKind;
  private String phoneNumber;

  @ManyToOne
  @JoinColumn(name = "idContact")
  private Contact contact = null;

  public PhoneNumber() {}

  public PhoneNumber(int id, String phoneKind, String phoneNumber, Contact contact) {
    super();
    setId(id);
    setPhoneKind(phoneKind);
    setPhoneNumber(phoneNumber);
    setContact(contact);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPhoneKind() {
    return phoneKind;
  }

  public void setPhoneKind(String phoneKind) {
    this.phoneKind = phoneKind;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }
}
