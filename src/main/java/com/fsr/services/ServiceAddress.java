package com.fsr.services;

import com.fsr.daos.DAOAddress;
import com.fsr.entities.Address;
import java.util.List;

public class ServiceAddress implements IService<Address> {

  DAOAddress daoa = new DAOAddress();

  @Override
  public void create(Address t) {

    boolean success = daoa.create(t);
    if (success) {
      System.out.println("Adresse créée");
    } else {
      System.out.println("Adresse non créée");
    }
  }

  @Override
  public Address read(int id) {
    try {
      Address a = daoa.read(id);
      return a;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<Address> readAll() {
    try {
      List<Address> addresses = daoa.readAll();
      return addresses;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void update(Address entity) {
    boolean success = daoa.update(entity);
    if (success) {
      System.out.println("Adresse mise à jour");
    } else {
      System.out.println("Adresse non mise à jour");
    }
  }

  @Override
  public void delete(int id) {
    boolean success = daoa.delete(id);
    if (success) {
      System.out.println("Adresse supprimée");
    } else {
      System.out.println("Adresse non supprimée");
    }
  }
}
