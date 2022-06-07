package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Customer;
import me.dio.academia.digital.entity.Registration;
import me.dio.academia.digital.entity.form.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import me.dio.academia.digital.repository.CustomerRepository;
import me.dio.academia.digital.repository.RegistrationRepository;
import me.dio.academia.digital.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

  @Autowired
  private RegistrationRepository registrationRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public Registration create(RegistrationForm form) {
    Registration registration = new Registration();
    Customer customer = customerRepository.findById(form.getCustomerId()).get();

    registration.setCustomer(customer);

    return registrationRepository.save(registration);
  }

  @Override
  public Registration get(Long id) {
    return registrationRepository.findById(id).get();
  }

  @Override
  public List<Registration> getAll(String bairro) {

    if(bairro == null){
      return registrationRepository.findAll();
    }else{
      return registrationRepository.findCustomerRegisteredByAddress(bairro);
    }

  }

  @Override
  public void delete(Long id) {}



}
