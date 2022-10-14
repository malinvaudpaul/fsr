package com.fsr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "phone_nums")
@Entity
public class PhoneNum {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "phone_kind")
  private String phoneKind;

  @Column(name = "phone_num")
  private String phoneNum;

  @ManyToOne
  @JoinColumn(name = "id_contact")
  private Contact contact;

  public PhoneNum() {}

  public PhoneNum(int id, String phoneKind, String phoneNum, Contact contact) {
    super();
    setId(id);
    setPhoneKind(phoneKind);
    setPhoneNum(phoneNum);
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

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }
}
