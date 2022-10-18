package com.fsr.api;

import com.fsr.entities.PhoneNum;
import com.fsr.services.ServicePhoneNum;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/phoneNumbers")
public class PhoneNumController {

  @Autowired
  @Qualifier("ServicePhoneNum")
  private ServicePhoneNum servicePhoneNum;
  private ApplicationContext context = new ClassPathXmlApplicationContext (new String("applicationContext.xml"));


  public PhoneNumController() {}

  // CREATE CONTROLLER
  @PostMapping(path = "", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> addPhoneNum(@RequestBody PhoneNum phoneNum) {
  
    PhoneNum pn = (PhoneNum)context.getBean("PN1");
    servicePhoneNum.create(pn);
    servicePhoneNum.create(phoneNum);

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(phoneNum.getId())
            .toUri();

    return ResponseEntity.created(location).build();
  }

  // READ CONTROLLERS
  @GetMapping(path = "/{id}", produces = "application/json")
  public PhoneNum getPhoneNumById(@PathVariable("id") int id) {
    return servicePhoneNum.read(id);
  }

  @GetMapping(path = "", produces = "application/json")
  public List<PhoneNum> getPhoneNums() {
    return servicePhoneNum.readAll();
  }

  // UPDATE CONTROLLER
  @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> updatePhoneNum(
      @PathVariable("id") int id, @RequestBody PhoneNum phoneNum) {
    servicePhoneNum.update(phoneNum);

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(phoneNum.getId())
            .toUri();

    return ResponseEntity.created(location).build();
  }

  // DELETE CONTROLLER
  @DeleteMapping(path = "/{id}", produces = "application/json")
  public void deletePhoneNum(@PathVariable("id") int id) {
    servicePhoneNum.delete(id);
  }
}
