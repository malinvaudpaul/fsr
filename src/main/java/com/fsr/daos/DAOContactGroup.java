package com.fsr.daos;

import com.fsr.entities.ContactGroup;
import com.fsr.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DAOContactGroup implements IDAO<ContactGroup> {

  @Override
  public boolean create(ContactGroup entity) {
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
  public ContactGroup read(int id) {
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();
      ContactGroup c = em.find(ContactGroup.class, id);
      return c;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<ContactGroup> readAll() {
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();

      return em.createQuery("SELECT c FROM ContactGroup c").getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean update(ContactGroup entity) {
    boolean success = false;
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();
      ContactGroup cg = em.find(ContactGroup.class, entity.getGroupId());

      EntityTransaction tx = em.getTransaction();
      tx.begin();

      cg.setContactGroups(entity.getContactGroups());
      cg.setGroupName(entity.getGroupName());

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
      ContactGroup cg = em.find(ContactGroup.class, id);

      EntityTransaction tx = em.getTransaction();
      tx.begin();

      em.remove(cg);

      tx.commit();

      em.close();
      success = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return success;
  }
}
