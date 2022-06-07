package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Registration;
import me.dio.academia.digital.entity.form.RegistrationForm;

import java.util.List;

public interface RegistrationService {

    /**
     * Cria uma Registration e salva no banco de dados.
     *
     * @param form - formulário referente aos dados para criação da Registration
     * no banco de dados.
     * @return - Registration recém-criada.
     */
    Registration create(RegistrationForm form);

    /**
     * Retorna uma Registration que está no banco de dados de acordo com seu Id.
     *
     * @param RegistrationId - id da Registration que será exibida.
     * @return - Registration de acordo com o Id fornecido.
     */
    Registration get(Long id);

    /**
     * Retorna todas as Registration que estão no banco de dados.
     *
     * @return - uma lista com todas as Registration que estão salvas no DB.
     */
    List<Registration> getAll(String bairro);

    /**
     * Deleta Registration específica.
     *
     * @param RegistrationId - id da Registration que será removida.
     */
    void delete(Long RegistrationId);

}
