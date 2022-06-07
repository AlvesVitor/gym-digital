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
import java.util.Optional;
import me.dio.academia.digital.exception.CustomerNotFoundException;
import me.dio.academia.digital.exception.GenericException;
import me.dio.academia.digital.repository.CustomerRepository;
import me.dio.academia.digital.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer create(CustomerForm form) {
        try {
            Customer customer = new Customer(form.getName(), form.getCpf(), form.getAddress(),
                    form.getBirthDate());
            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new GenericException();
        }
    }

    @Override
    public Customer getCustomerId(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (!customer.isPresent()) {
            throw new CustomerNotFoundException();
        }
        return customer.get();
    }

    @Override
    public List<Customer> getAll(String birthDate) {

        if ("all".equals(birthDate)) {
            return customerRepository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(birthDate, JavaTimeUtils.LOCAL_DATE_FORMATTER_);
            return customerRepository.findByBirthDate(localDate);
        }

    }

    @Override
    public Customer update(Long customerId, CustomerUpdateForm formUpdate) {
        Optional<Customer> customer = customerRepository.findById(customerId);

        if (!customer.isPresent()) {
            throw new CustomerNotFoundException();
        }

        Customer customerUpdate = customer.get();

        customerUpdate.setName(formUpdate.getName());
        customerUpdate.setAddress(formUpdate.getAddress());
        customerUpdate.setBirthDate(formUpdate.getBirthDate());
        customerRepository.save(customerUpdate);

        return customerUpdate;
    }

    @Override
    public void delete(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (!customer.isPresent()) {
            throw new CustomerNotFoundException();
        }
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<EvaluationPhysical> getAllAvaluationPhysicalId(Long id) {

        Optional<Customer> customer = customerRepository.findById(id);
        if(!customer.isPresent()){
            throw new CustomerNotFoundException();
        }

        return customer.get().getEvaluations();

    }

}
