package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Customer;
import me.dio.academia.digital.entity.Registration;
import me.dio.academia.digital.entity.form.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import me.dio.academia.digital.exception.CustomerNotFoundException;
import me.dio.academia.digital.exception.RegistrationNotFoundException;
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
        Optional<Customer> customer = customerRepository.findById(form.getCustomerId());

        if (!customer.isPresent()) {
            throw new CustomerNotFoundException();
        }
        registration.setCustomer(customer.get());

        return registrationRepository.save(registration);
    }

    @Override
    public Registration get(Long RegistrationId) {
        Optional<Registration> registration = registrationRepository.findById(RegistrationId);
        if (!registration.isPresent()) {
            throw new RegistrationNotFoundException();
        }
        return registration.get();
    }

    @Override
    public List<Registration> getAll(String bairro) {

        if (bairro == null) {
            return registrationRepository.findAll();
        } else {
            return registrationRepository.findCustomerRegisteredByAddress(bairro);
        }

    }

    @Override
    public void delete(Long RegistrationId) {
         Optional<Registration> registration = registrationRepository.findById(RegistrationId);
        if (!registration.isPresent()) {
            throw new RegistrationNotFoundException();
        }
        
        registrationRepository.deleteById(RegistrationId);
    }

}
