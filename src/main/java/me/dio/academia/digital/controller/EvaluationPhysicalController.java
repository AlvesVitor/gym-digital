package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.EvaluationPhysical;
import me.dio.academia.digital.entity.form.EvaluationPhysicalForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import me.dio.academia.digital.service.EvaluationPhysicalService;

@RestController
@RequestMapping("/evaluations")
public class EvaluationPhysicalController {

  @Autowired
  private EvaluationPhysicalService evaluationService;

  @PostMapping
  public EvaluationPhysical create(@RequestBody EvaluationPhysicalForm form) {
    return evaluationService.create(form);
  }

  @GetMapping
  public List<EvaluationPhysical> getAll(){
    return evaluationService.getAll();
  }

}
