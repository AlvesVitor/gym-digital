package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.EvaluationPhysical;
import me.dio.academia.digital.entity.form.EvaluationPhysicalForm;
import me.dio.academia.digital.entity.form.EvaluationPhysicalUpdateForm;

import java.util.List;

public interface EvaluationPhysicalService {

    /**
     * Cria uma EvaluationPhysical e salva no banco de dados.
     *
     * @param form - formulário referente aos dados para criação da
     * EvaluationPhysical no banco de dados.
     * @return - EvaluationPhysical recém-criada.
     */
    EvaluationPhysical create(EvaluationPhysicalForm form);

    /**
     * Retorna uma EvaluationPhysical que está no banco de dados de acordo com
     * seu Id.
     *
     * @param evaluationId - id da EvaluationPhysical que será exibida.
     * @return - EvaluationPhysical de acordo com o Id fornecido.
     */
    EvaluationPhysical get(Long evaluationId);

    /**
     * Retorna todas as EvaluationPhysical que estão no banco de dados.
     *
     * @return - Uma lista com todas as EvaluationPhysical que estão salvas no
     * DB.
     */
    List<EvaluationPhysical> getAll();

    /**
     * Atualiza a EvaluationPhysical.
     *
     * @param evaluationId - id da EvaluationPhysical que será atualizada.
     * @param formUpdate - formulário referente aos dados necessários para
     * atualização da Avaliação Física no banco de dados.
     * @return - EvaluationPhysical recém-atualizada.
     */
    EvaluationPhysical update(Long evaluationId, EvaluationPhysicalUpdateForm formUpdate);

    /**
     * Deleta uma EvaluationPhysical específica.
     *
     * @param evaluationId - id da EvaluationPhysical que será removida.
     */
    void delete(Long evaluationId);
}
