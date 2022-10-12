package com.fsr.services;

import com.fsr.daos.DAOContact;
import com.fsr.entities.Contact;
import java.util.List;

public class ServiceContact implements IService<Contact> {

  DAOContact daoc = new DAOContact();

  @Override
  public void create(Contact t) {

    boolean success = daoc.create(t);
    if (success) {
      System.out.println("Contact créée");
    } else {
      System.out.println("Contact non créée");
    }
  }

  @Override
  public Contact read(int id) {
    try {
      Contact a = daoc.read(id);
      return a;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<Contact> readAll() {
    try {
      List<Contact> Contactes = daoc.readAll();
      return Contactes;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void update(Contact entity) {
    boolean success = daoc.update(entity);
    if (success) {
      System.out.println("Contact mise à jour");
    } else {
      System.out.println("Contact non mise à jour");
    }
  }

  @Override
  public void delete(int id) {
    boolean success = daoc.delete(id);
    if (success) {
      System.out.println("Contact supprimée");
    } else {
      System.out.println("Contact non supprimée");
    }
  }
}
