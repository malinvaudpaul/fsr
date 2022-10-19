package com.fsr.daos;

import com.fsr.entities.Address;
import com.fsr.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("DAOAddress")
public class DAOAddress implements IDAO<Address> {

  @PersistenceContext private EntityManager em = JpaUtil.getEmf().createEntityManager();

  @Override
  @Transactional
  public boolean create(Address entity) {
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
  public Address read(int id) {
    try {
      Address a = this.em.find(Address.class, id);
      return a;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  @Transactional
  public List<Address> readAll() {
    try {
      return this.em.createQuery("SELECT c FROM Address c").getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  @Transactional
  public boolean update(Address entity) {
    boolean success = false;
    try {
      Address a = this.em.find(Address.class, entity.getId());

      em.persist(a);
      a.setStreet(entity.getStreet());
      a.setCity(entity.getCity());
      a.setZip(entity.getZip());
      a.setCountry(entity.getCountry());

      
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

      Address a = this.em.find(Address.class, id);
      em.remove(a);
      success = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return success;
  }
}
