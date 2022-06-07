package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Customer;
import me.dio.academia.digital.entity.EvaluationPhysical;
import me.dio.academia.digital.entity.form.CustomerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import me.dio.academia.digital.entity.form.CustomerUpdateForm;
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

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerId(@PathVariable(value = "customerId", required = true) Long customerId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.getCustomerId(customerId));
    }

    @GetMapping("/evaluation/{id}")
    public ResponseEntity<List<EvaluationPhysical>> getAllAvaluationPhysicalId(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.getAllAvaluationPhysicalId(id));
    }

    @GetMapping("/birthdate/{birthDate}")
    public ResponseEntity<List<Customer>> getAll(@PathVariable(value = "birthDate",
            required = true) String birthDate) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.getAll(birthDate));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> update(@PathVariable(value = "customerId", required = true) Long customerId, @Valid @RequestBody CustomerUpdateForm formUpdate) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.update(customerId, formUpdate));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<?> delete(@PathVariable(value = "customerId", required = true) Long customerId) {
        customerService.delete(customerId);
        return ResponseEntity.ok().build();
    }

}
