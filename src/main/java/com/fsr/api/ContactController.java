package com.fsr.api;

import com.fsr.entities.Contact;
import com.fsr.services.ServiceContact;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/contacts")
public class ContactController {

  @Autowired
  @Qualifier("ServiceContact")
  private ServiceContact serviceContact;

  public ContactController() {
  }

  // CREATE CONTROLLER
  @PostMapping(path = "", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> addContact(@RequestBody Contact contact) {
    /*Integer id = serviceContact.readAll().size() + 1;

    contact.setIdContact(id);  -> Pas la peine, l'id est renseigné automatiquement*/

    serviceContact.create(contact);

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(contact.getId())
            .toUri();

    return ResponseEntity.created(location).build();
  }

  // READ CONTROLLERS
  @GetMapping(path = "/{id}", produces = "application/json")
  public Contact getContactById(@PathVariable("id") int id) {
    return serviceContact.read(id);
  }

  @GetMapping(path = "", produces = "application/json")
  public List<Contact> getContacts() {
    return serviceContact.readAll();
  }

  // UPDATE CONTROLLER
  @PatchMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> updateContact(
      @PathVariable("id") int id, @RequestBody Contact contact) {
    serviceContact.update(contact);

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(contact.getId())
            .toUri();

    return ResponseEntity.created(location).build();
  }

  // DELETE CONTROLLER
  @DeleteMapping(path = "/{id}", produces = "application/json")
  public void deleteContact(@PathVariable("id") int id) {
    serviceContact.delete(id);
  }
}
