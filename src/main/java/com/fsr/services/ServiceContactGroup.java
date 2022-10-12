package com.fsr.services;

import com.fsr.daos.DAOContactGroup;
import com.fsr.entities.ContactGroup;
import java.util.List;

public class ServiceContactGroup implements IService<ContactGroup> {

  DAOContactGroup daocg = new DAOContactGroup();

  @Override
  public void create(ContactGroup t) {

    boolean success = daocg.create(t);
    if (success) {
      System.out.println("ContactGroup créée");
    } else {
      System.out.println("ContactGroup non créée");
    }
  }

  @Override
  public ContactGroup read(int id) {
    try {
      ContactGroup a = daocg.read(id);
      return a;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<ContactGroup> readAll() {
    try {
      List<ContactGroup> ContactGroupes = daocg.readAll();
      return ContactGroupes;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void update(ContactGroup entity) {
    boolean success = daocg.update(entity);
    if (success) {
      System.out.println("ContactGroup mise à jour");
    } else {
      System.out.println("ContactGroup non mise à jour");
    }
  }

  @Override
  public void delete(int id) {
    boolean success = daocg.delete(id);
    if (success) {
      System.out.println("ContactGroup supprimée");
    } else {
      System.out.println("ContactGroup non supprimée");
    }
  }
}
