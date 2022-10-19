package com.fsr.daos;

import com.fsr.entities.Contact;
import com.fsr.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("DAOContact")
public class DAOContact implements IDAO<Contact> {

  @PersistenceContext private EntityManager em = JpaUtil.getEmf().createEntityManager();

  @Override
  @Transactional
  public boolean create(Contact entity) {
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
  public Contact read(int id) {
    try {
      Contact c = em.find(Contact.class, id);
      return c;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  @Transactional
  public List<Contact> readAll() {
    try {
      return em.createQuery("SELECT c FROM Contact c").getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  @Transactional
  public boolean update(Contact entity) {
    boolean success = false;
    try {
      Contact c = em.find(Contact.class, entity.getId());

      em.persist(c);


      c.setAdd(entity.getAdd());
      c.setEmail(entity.getEmail());
      c.setFirstName(entity.getFirstName());
      c.setLastName(entity.getLastName());
      c.setPhones(entity.getPhones());

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
      Contact c = em.find(Contact.class, id);
      em.remove(c);
      success = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return success;
  }
}
