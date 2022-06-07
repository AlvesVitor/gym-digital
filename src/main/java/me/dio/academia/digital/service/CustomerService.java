package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Customer;
import me.dio.academia.digital.entity.EvaluationPhysical;
import me.dio.academia.digital.entity.form.CustomerForm;
import me.dio.academia.digital.entity.form.CustomerUpdateForm;

import java.util.List;

public interface CustomerService {

    Customer create(CustomerForm form);

    Customer get(Long id);

    List<Customer> getAll(String dataDeNascimento);

    Customer update(Long id, CustomerUpdateForm formUpdate);

    void delete(Long id);

    List<EvaluationPhysical> getAllAvaluationPhysicalId(Long id);

}
