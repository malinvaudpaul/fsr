package com.fsr.api;

import com.fsr.entities.Address;
import com.fsr.services.ServiceAddress;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/addresses")
public class AddressController {

  @Autowired
  @Qualifier("ServiceAddress")
  private ServiceAddress serviceAddress;

  private ApplicationContext context = new ClassPathXmlApplicationContext (new String("applicationContext.xml"));
  public AddressController() {}

  // CREATE CONTROLLER
  @PostMapping(path = "", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> addAddress(@RequestBody Address address) {

    Address a = (Address) context.getBean("Address");

    serviceAddress.create(a);
    serviceAddress.create(address);


    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(address.getId())
            .toUri();

    return ResponseEntity.created(location).build();
  }

  // READ CONTROLLERS
  @GetMapping(path = "/{id}", produces = "application/json")
  public Address getAddressById(@PathVariable("id") int id) {
    Address address = serviceAddress.read(id);
    System.out.println(address);
    return address;
  }

  @GetMapping(path = "", produces = "application/json")
  public List<Address> getAddresses() {
    return serviceAddress.readAll();
  }

  // UPDATE CONTROLLER
  @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> updateAddress(
      @PathVariable("id") int id, @RequestBody Address address) {
      address.setId(id);
      serviceAddress.update(address);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(address.getId())
            .toUri();

    return ResponseEntity.created(location).build();
  }

  // DELETE CONTROLLER
  @DeleteMapping(path = "/{id}", produces = "application/json")
  public void deleteAddress(@PathVariable("id") int id) {
    serviceAddress.delete(id);
  }
}
