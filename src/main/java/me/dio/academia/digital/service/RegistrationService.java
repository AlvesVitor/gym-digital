package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Registration;
import me.dio.academia.digital.entity.form.RegistrationForm;

import java.util.List;

public interface RegistrationService {

    Registration create(RegistrationForm form);

    Registration get(Long id);

    List<Registration> getAll(String bairro);

    void delete(Long id);

}
