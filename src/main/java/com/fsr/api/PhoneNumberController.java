package com.fsr.api;

import com.fsr.entities.PhoneNumber;
import com.fsr.services.ServicePhoneNumber;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(path = "/phoneNumbers")
public class PhoneNumberController {

  private ServicePhoneNumber servicePhoneNumber;

  public PhoneNumberController() {
    this.servicePhoneNumber = new ServicePhoneNumber();
  }

  // CREATE CONTROLLER
  @PostMapping(path = "", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> addphoneNumber(@RequestBody PhoneNumber phoneNumber) {
    /*Integer id = servicePhoneNumber.readAll().size() + 1;

    phoneNumber.setId(id);*/

    servicePhoneNumber.create(phoneNumber);

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(phoneNumber.getId())
            .toUri();

    return ResponseEntity.created(location).build();
  }

  // READ CONTROLLERS
  @GetMapping(path = "/{id}", produces = "application/json")
  public PhoneNumber getPhoneNumberById(@PathVariable("id") int id) {
    return servicePhoneNumber.read(id);
  }

  @GetMapping(path = "", produces = "application/json")
  public List<PhoneNumber> getPhoneNumbers() {
    return servicePhoneNumber.readAll();
  }

  // UPDATE CONTROLLER
  @PatchMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> updatePhoneNumber(
      @PathVariable("id") int id, @RequestBody PhoneNumber phoneNumber) {
    servicePhoneNumber.update(phoneNumber);

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(phoneNumber.getId())
            .toUri();

    return ResponseEntity.created(location).build();
  }

  // DELETE CONTROLLER
  @DeleteMapping(path = "/{id}", produces = "application/json")
  public void deletePhoneNumber(@PathVariable("id") int id) {
    servicePhoneNumber.delete(id);
  }
}
