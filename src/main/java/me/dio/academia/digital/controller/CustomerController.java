package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Customer;
import me.dio.academia.digital.entity.EvaluationPhysical;
import me.dio.academia.digital.entity.form.CustomerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import me.dio.academia.digital.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @PostMapping
  public Customer create(@Valid @RequestBody CustomerForm form) {
    return customerService.create(form);
  }

  @GetMapping("/evaluation/{id}")
  public List<EvaluationPhysical> getAllAvaluationPhysicalId(@PathVariable Long id) {
    return customerService.getAllAvaluationPhysicalId(id);
  }

  @GetMapping
  public List<Customer> getAll(@RequestParam(value = "birthDate", required = false)
                                  String birthDate){
    return customerService.getAll(birthDate);
  }


}
