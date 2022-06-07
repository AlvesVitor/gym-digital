package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Customer;
import me.dio.academia.digital.entity.EvaluationPhysical;
import me.dio.academia.digital.entity.form.CustomerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import me.dio.academia.digital.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> create(@Valid @RequestBody CustomerForm form) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(form));
    }

    @GetMapping("/evaluation/{id}")
    public ResponseEntity<List<EvaluationPhysical>> getAllAvaluationPhysicalId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.getAllAvaluationPhysicalId(id));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll(@RequestParam(value = "birthDate",
            required = false) String birthDate) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.getAll(birthDate));
    }

}
