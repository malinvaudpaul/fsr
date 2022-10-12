package com.fsr.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "phone_num")
@Entity
public class PhoneNum {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String phoneKind;
  private String phoneNum;

  @ManyToOne private Contact contact;

  public PhoneNum() {}

  public PhoneNum(int id, String phoneKind, String phoneNum, Contact contact) {
    super();
    setId(id);
    setPhoneKind(phoneKind);
    setphoneNum(phoneNum);
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

  public String getphoneNum() {
    return phoneNum;
  }

  public void setphoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }
}
