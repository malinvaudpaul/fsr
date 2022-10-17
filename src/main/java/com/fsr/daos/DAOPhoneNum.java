package com.fsr.daos;

import com.fsr.entities.PhoneNum;
import com.fsr.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("DAOPhoneNum")
public class DAOPhoneNum implements IDAO<PhoneNum> {


  private EntityManager em = JpaUtil.getEmf().createEntityManager();

  @Override
  @Transactional
  public boolean create(PhoneNum entity) {
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
  public PhoneNum read(int id) {
    try {
      return em.find(PhoneNum.class, id);

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  @Transactional
  public List<PhoneNum> readAll() {
    try {
      return em.createQuery("SELECT pn FROM PhoneNum pn").getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  @Transactional
  public boolean update(PhoneNum entity) {
    boolean success = false;
    try {
      PhoneNum pn = em.find(PhoneNum.class, entity.getId());

      pn.setContact(entity.getContact());
      pn.setPhoneKind(entity.getPhoneKind());
      pn.setPhoneNum(entity.getPhoneNum());

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
      
      PhoneNum pn = em.find(PhoneNum.class, id);
      em.remove(pn);

      success = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return success;
  }
}
