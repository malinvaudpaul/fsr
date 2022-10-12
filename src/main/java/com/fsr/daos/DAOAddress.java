package com.fsr.daos;

import com.fsr.entities.Address;
import com.fsr.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DAOAddress implements IDAO<Address> {

  @Override
  public boolean create(Address entity) {
    boolean success = false;
    try {

      EntityManager em = JpaUtil.getEmf().createEntityManager();

      EntityTransaction tx = em.getTransaction();
      tx.begin();

      em.persist(entity);

      tx.commit();

      em.close();
      success = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return success;
  }

  @Override
  public Address read(int id) {
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();
      Address a = em.find(Address.class, id);
      return a;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<Address> readAll() {
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();

      return em.createQuery("SELECT c FROM Address c").getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(Address entity) {
    boolean success = false;
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();
      Address a = em.find(Address.class, entity.getIdAddress());

      EntityTransaction tx = em.getTransaction();
      tx.begin();

      a.setStreet(entity.getStreet());
      a.setCity(entity.getCity());
      a.setZip(entity.getZip());
      a.setCountry(entity.getCountry());

      tx.commit();

      em.close();
      success = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return success;
  }

  @Override
  public boolean delete(int id) {
    boolean success = false;
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();
      Address a = em.find(Address.class, id);

      EntityTransaction tx = em.getTransaction();
      tx.begin();

      em.remove(a);

      tx.commit();

      em.close();
      success = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return success;
  }
}
