package com.fsr.services;

import com.fsr.daos.DAOPhoneNumber;
import com.fsr.entities.PhoneNumber;
import java.util.List;

public class ServicePhoneNumber implements IService<PhoneNumber> {

  DAOPhoneNumber daopn = new DAOPhoneNumber();

  @Override
  public void create(PhoneNumber t) {

    boolean success = daopn.create(t);
    if (success) {
      System.out.println("PhoneNumber créée");
    } else {
      System.out.println("PhoneNumber non créée");
    }
  }

  @Override
  public PhoneNumber read(int id) {
    try {
      PhoneNumber a = daopn.read(id);
      return a;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<PhoneNumber> readAll() {
    try {
      List<PhoneNumber> PhoneNumberes = daopn.readAll();
      return PhoneNumberes;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void update(PhoneNumber entity) {
    boolean success = daopn.update(entity);
    if (success) {
      System.out.println("PhoneNumber mise à jour");
    } else {
      System.out.println("PhoneNumber non mise à jour");
    }
  }

  @Override
  public void delete(int id) {
    boolean success = daopn.delete(id);
    if (success) {
      System.out.println("PhoneNumber supprimée");
    } else {
      System.out.println("PhoneNumber non supprimée");
    }
  }
}
