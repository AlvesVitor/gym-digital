package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.EvaluationPhysical;
import me.dio.academia.digital.entity.form.EvaluationPhysicalForm;
import me.dio.academia.digital.entity.form.EvaluationPhysicalUpdateForm;

import java.util.List;

public interface EvaluationPhysicalService {

    EvaluationPhysical create(EvaluationPhysicalForm form);

    EvaluationPhysical get(Long id);

    List<EvaluationPhysical> getAll();

    EvaluationPhysical update(Long id, EvaluationPhysicalUpdateForm formUpdate);

    void delete(Long id);
}
