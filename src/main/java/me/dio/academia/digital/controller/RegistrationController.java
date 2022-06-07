package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Registration;
import me.dio.academia.digital.entity.form.RegistrationForm;
import me.dio.academia.digital.service.impl.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

  @Autowired
  private RegistrationServiceImpl registrationService;

  @PostMapping
  public ResponseEntity<Registration> create(@Valid @RequestBody RegistrationForm form) {
    return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.create(form));
  }

  @GetMapping
  public ResponseEntity<List<Registration>> getAll(@RequestParam(value = "address", required = false) String address) {
    return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.getAll(address));
  }

}

