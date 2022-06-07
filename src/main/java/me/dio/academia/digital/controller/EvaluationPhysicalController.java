package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.EvaluationPhysical;
import me.dio.academia.digital.entity.form.EvaluationPhysicalForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import me.dio.academia.digital.service.EvaluationPhysicalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/evaluations")
public class EvaluationPhysicalController {

  @Autowired
  private EvaluationPhysicalService evaluationService;

  @PostMapping
  public ResponseEntity<EvaluationPhysical> create(@RequestBody EvaluationPhysicalForm form) {
    return ResponseEntity.status(HttpStatus.CREATED).body(evaluationService.create(form));
  }

  @GetMapping
  public ResponseEntity<List<EvaluationPhysical>> getAll(){
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(evaluationService.getAll());
  }

}
