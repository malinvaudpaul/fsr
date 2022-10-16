package com.fsr.services;

import com.fsr.daos.DAOPhoneNum;
import com.fsr.entities.PhoneNum;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ServicePhoneNum")
public class ServicePhoneNum implements IService<PhoneNum> {

  @Autowired
  @Qualifier("DAOPhoneNum")
  DAOPhoneNum daopn;

  @Override
  public void create(PhoneNum t) {

    boolean success = daopn.create(t);
    if (success) {
      System.out.println("phoneNum créée");
    } else {
      System.out.println("phoneNum non créée");
    }
  }

  @Override
  public PhoneNum read(int id) {
    try {
      return daopn.read(id);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<PhoneNum> readAll() {
    try {
      return daopn.readAll();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void update(PhoneNum entity) {
    boolean success = daopn.update(entity);
    if (success) {
      System.out.println("phoneNum mise à jour");
    } else {
      System.out.println("phoneNum non mise à jour");
    }
  }

  @Override
  public void delete(int id) {
    boolean success = daopn.delete(id);
    if (success) {
      System.out.println("phoneNum supprimée");
    } else {
      System.out.println("phoneNum non supprimée");
    }
  }
}
