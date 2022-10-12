package com.fsr.daos;

import com.fsr.entities.PhoneNumber;
import com.fsr.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DAOPhoneNumber implements IDAO<PhoneNumber> {

  @Override
  public boolean create(PhoneNumber entity) {
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
  public PhoneNumber read(int id) {
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();
      PhoneNumber pn = em.find(PhoneNumber.class, id);
      return pn;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<PhoneNumber> readAll() {
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();

      return em.createQuery("SELECT pn FROM PhoneNumber pn").getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(PhoneNumber entity) {
    boolean success = false;
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();
      PhoneNumber pn = em.find(PhoneNumber.class, entity.getId());

      EntityTransaction tx = em.getTransaction();
      tx.begin();

      pn.setContact(entity.getContact());
      pn.setPhoneKind(entity.getPhoneKind());
      pn.setPhoneNumber(entity.getPhoneNumber());

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
      PhoneNumber pn = em.find(PhoneNumber.class, id);

      EntityTransaction tx = em.getTransaction();
      tx.begin();

      em.remove(pn);

      tx.commit();

      em.close();
      success = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return success;
  }
}
