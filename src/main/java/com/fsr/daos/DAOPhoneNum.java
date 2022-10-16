package com.fsr.daos;

import com.fsr.entities.PhoneNum;
import com.fsr.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Repository;

@Repository("DAOPhoneNum")
public class DAOPhoneNum implements IDAO<PhoneNum> {

  @Override
  public boolean create(PhoneNum entity) {
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
  public PhoneNum read(int id) {
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();
      PhoneNum pn = em.find(PhoneNum.class, id);
      return pn;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<PhoneNum> readAll() {
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();

      return em.createQuery("SELECT pn FROM PhoneNum pn").getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(PhoneNum entity) {
    boolean success = false;
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();
      PhoneNum pn = em.find(PhoneNum.class, entity.getId());

      EntityTransaction tx = em.getTransaction();
      tx.begin();

      pn.setContact(entity.getContact());
      pn.setPhoneKind(entity.getPhoneKind());
      pn.setPhoneNum(entity.getPhoneNum());

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
      PhoneNum pn = em.find(PhoneNum.class, id);

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
