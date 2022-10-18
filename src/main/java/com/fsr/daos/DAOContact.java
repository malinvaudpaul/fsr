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

      c.setAddress(entity.getAddress());
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

/*Contact c2 = new Contact("Jean", "PIERRE", "JeanPierre@gmail.com");

phoneNum pn1 = new phoneNum();
phoneNum pn2 = new phoneNum();
phoneNum pn3 = new phoneNum();
Address a1 = new Address();
Address a2 = new Address();

pn1.setPhoneKind("Samsung");
pn1.setphoneNum("0742652475");

pn2.setPhoneKind("Xiaomi");
pn2.setphoneNum("0643651284");

pn3.setPhoneKind("Apple");
pn3.setphoneNum("0712774511");

a1.setCity("Nanterre");
a1.setCountry("France");
a1.setStreet("19 rue des arbres");
a1.setZip("92000");

a2.setCity("Paris");
a2.setCountry("France");
a2.setStreet("5 avenue de l'elite");
a2.setZip("75000");

a1.setContact(c1);
c1.setAddress(a1);

a2.setContact(c2);
c2.setAddress(a2);

pn1.setContact(c1);
pn2.setContact(c1);
pn3.setContact(c2);

c1.getPhones().add(pn1);
c1.getPhones().add(pn2);
c2.getPhones().add(pn3);

ContactGroup contactgroup = new ContactGroup("my group");
contactgroup.addContact(c1);
contactgroup.addContact(c2);*/
