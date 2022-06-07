package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Customer;
import me.dio.academia.digital.entity.EvaluationPhysical;
import me.dio.academia.digital.entity.form.EvaluationPhysicalForm;
import me.dio.academia.digital.entity.form.EvaluationPhysicalUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import me.dio.academia.digital.repository.CustomerRepository;
import me.dio.academia.digital.repository.EvaluationPhysicalRepository;
import me.dio.academia.digital.service.EvaluationPhysicalService;

@Service
public class EvaluationPhysicalServiceImpl implements EvaluationPhysicalService {

  @Autowired
  private EvaluationPhysicalRepository evaluationRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public EvaluationPhysical create(EvaluationPhysicalForm form) {
    EvaluationPhysical evaluation = new EvaluationPhysical();
    Customer customer = customerRepository.findById(form.getCustomerId()).get();

    evaluation.setCustomer(customer);
    evaluation.setWeight(form.getWeight());
    evaluation.setHeight(form.getHeight());

    return evaluationRepository.save(evaluation);
  }

  @Override
  public EvaluationPhysical get(Long id) {
    return null;
  }

  @Override
  public List<EvaluationPhysical> getAll() {

    return evaluationRepository.findAll();
  }

  @Override
  public EvaluationPhysical update(Long id, EvaluationPhysicalUpdateForm formUpdate) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }
}
