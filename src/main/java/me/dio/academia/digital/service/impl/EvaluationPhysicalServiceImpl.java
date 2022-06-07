package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Customer;
import me.dio.academia.digital.entity.EvaluationPhysical;
import me.dio.academia.digital.entity.form.EvaluationPhysicalForm;
import me.dio.academia.digital.entity.form.EvaluationPhysicalUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import me.dio.academia.digital.exception.CustomerNotFoundException;
import me.dio.academia.digital.exception.EvaluationPhysicalNotFoundException;
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
        
        Optional<Customer> customer = customerRepository.findById(form.getCustomerId());
        
        if (!customer.isPresent()) {
            throw new CustomerNotFoundException();
        }
        evaluation.setCustomer(customer.get());
        evaluation.setWeight(form.getWeight());
        evaluation.setHeight(form.getHeight());
        
        return evaluationRepository.save(evaluation);
    }
    
    @Override
    public EvaluationPhysical get(Long evaluationId) {
        Optional<EvaluationPhysical> evaluation = evaluationRepository.findById(evaluationId);
        if (!evaluation.isPresent()) {
            throw new EvaluationPhysicalNotFoundException();
        }
        return evaluation.get();
    }
    
    @Override
    public List<EvaluationPhysical> getAll() {
        return evaluationRepository.findAll();
    }
    
    @Override
    public EvaluationPhysical update(Long evaluationId, EvaluationPhysicalUpdateForm formUpdate) {
        Optional<EvaluationPhysical> evaluation = evaluationRepository.findById(evaluationId);
        if (!evaluation.isPresent()) {
            throw new EvaluationPhysicalNotFoundException();
        }
        EvaluationPhysical evaluationUpdate = evaluation.get();
        evaluationUpdate.setWeight(formUpdate.getWeight());
        evaluationUpdate.setHeight(formUpdate.getHeight());
        
        evaluationRepository.save(evaluationUpdate);
        return evaluationUpdate;
    }
    
    @Override
    public void delete(Long evaluationId) {
        Optional<EvaluationPhysical> evaluation = evaluationRepository.findById(evaluationId);
        if (!evaluation.isPresent()) {
            throw new EvaluationPhysicalNotFoundException();
        }
        evaluationRepository.deleteById(evaluationId);
    }
}
