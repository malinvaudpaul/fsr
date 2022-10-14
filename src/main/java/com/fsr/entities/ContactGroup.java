package com.fsr.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "contact_groups")
@Entity
public class ContactGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int groupId;

  private String groupName;

  @ManyToMany(cascade = CascadeType.PERSIST)
  private Set<Contact> contacts = new HashSet<Contact>();

  public String getGroupName() {
    return groupName;
  }

  public void addContact(Contact contact) {
    this.contacts.add(contact);
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public Set<Contact> getContactGroups() {
    return contacts;
  }

  public void setContactGroups(Set<Contact> contactGroups) {
    this.contacts = contactGroups;
  }

  public ContactGroup() {}

  public ContactGroup(String groupName) {
    this.groupName = groupName;
  }

  public ContactGroup(String groupName, Set<Contact> contactGroups) {
    this.groupName = groupName;
    this.contacts = contactGroups;
  }

  public int getGroupId() {
    return groupId;
  }

  public void setGroupId(int groupId) {
    this.groupId = groupId;
  }
}
