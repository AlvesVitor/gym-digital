package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.EvaluationPhysical;
import me.dio.academia.digital.entity.form.EvaluationPhysicalForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import me.dio.academia.digital.entity.form.EvaluationPhysicalUpdateForm;
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

    @GetMapping("/{evaluationId}")
    public ResponseEntity<EvaluationPhysical> get(@PathVariable(value = "evaluationId") Long evaluationId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(evaluationService.get(evaluationId));
    }

    @GetMapping
    public ResponseEntity<List<EvaluationPhysical>> getAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(evaluationService.getAll());
    }

    @PutMapping("/{evaluationId}")
    public ResponseEntity<EvaluationPhysical> update(@PathVariable(value = "evaluationId") Long evaluationId,
            @RequestBody EvaluationPhysicalUpdateForm formUpdate) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(evaluationService.update(evaluationId, formUpdate));
    }

    @DeleteMapping("/{evaluationId}")
    public ResponseEntity<?> delete(@PathVariable(value = "evaluationId") Long evaluationId) {
        evaluationService.delete(evaluationId);
        return ResponseEntity.ok().build();

    }

}
