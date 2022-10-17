package com.fsr.daos;

import com.fsr.entities.ContactGroup;
import com.fsr.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("DAOContactGroup")
public class DAOContactGroup implements IDAO<ContactGroup> {

  private EntityManager em = JpaUtil.getEmf().createEntityManager();

  @Override
  @Transactional
  public boolean create(ContactGroup entity) {
    boolean success = false;
    try {

      em.persist(entity);
      success = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return success;
  }

  @Override
  @Transactional
  public ContactGroup read(int id) {
    try {
      ContactGroup c = em.find(ContactGroup.class, id);
      return c;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  @Transactional
  public List<ContactGroup> readAll() {
    try {
      return em.createQuery("SELECT c FROM ContactGroup c").getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  @Transactional
  public boolean update(ContactGroup entity) {
    boolean success = false;
    try {
      ContactGroup cg = em.find(ContactGroup.class, entity.getGroupId());

      cg.setContactGroups(entity.getContactGroups());
      cg.setGroupName(entity.getGroupName());

      success = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return success;
  }

  @Override
  @Transactional
  public boolean delete(int id) {
    boolean success = false;
    try {
      ContactGroup cg = em.find(ContactGroup.class, id);
      em.remove(cg);

      success = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return success;
  }
}
