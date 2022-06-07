package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Customer;
import me.dio.academia.digital.entity.EvaluationPhysical;
import me.dio.academia.digital.entity.form.CustomerForm;
import me.dio.academia.digital.entity.form.CustomerUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import me.dio.academia.digital.repository.CustomerRepository;
import me.dio.academia.digital.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerrepository;

  @Override
  public Customer create(CustomerForm form) {
    Customer customer = new Customer();
    customer.setName(form.getName());
    customer.setCpf(form.getCpf());
    customer.setAddress(form.getAddress());
    customer.setBirthDate(form.getBirthDate());

    return customerrepository.save(customer);
  }

  @Override
  public Customer get(Long id) {
    return null;
  }

  @Override
  public List<Customer> getAll(String birthDate) {

    if(birthDate == null) {
      return customerrepository.findAll();
    } else {
      LocalDate localDate = LocalDate.parse(birthDate, JavaTimeUtils.LOCAL_DATE_FORMATTER);
      return customerrepository.findByBirthDate(localDate);
    }

  }

  @Override
  public Customer update(Long id, CustomerUpdateForm formUpdate) {
    return null;
  }

  @Override
  public void delete(Long id) {
  }

  @Override
  public List<EvaluationPhysical> getAllAvaluationPhysicalId(Long id) {

    Customer customer = customerrepository.findById(id).get();

    return customer.getEvaluations();

  }

}
