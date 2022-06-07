package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Customer;
import me.dio.academia.digital.entity.EvaluationPhysical;
import me.dio.academia.digital.entity.form.CustomerForm;
import me.dio.academia.digital.entity.form.CustomerUpdateForm;

import java.util.List;

public interface CustomerService {
  /**
   * Cria um Aluno e salva no banco de dados.
   * @param form formulário referente aos dados para criação de um Aluno no banco de dados.
   * @return Aluno recém-criado.
   */
  Customer create(CustomerForm form);

  /**
   * Retorna um Aluno que está no banco de dados de acordo com seu Id.
   * @param id id do Aluno que será exibido.
   * @return Aluno de acordo com o Id fornecido.
   */
  Customer get(Long id);

  /**
   * Retorna os Alunos que estão no banco de dados.
   * @return Uma lista os Alunos que estão salvas no DB.
   */
  List<Customer> getAll(String dataDeNascimento);

  /**
   * Atualiza o Aluno.
   * @param id id do Aluno que será atualizado.
   * @param formUpdate formulário referente aos dados necessários para atualização do Aluno
   * no banco de dados.
   * @return Aluno recém-atualizado.
   */
  Customer update(Long id, CustomerUpdateForm formUpdate);

  /**
   * Deleta um Aluno específico.
   * @param id id do Aluno que será removido.
   */
  void delete(Long id);

  /**
   *
   * @param id id do aluno que será recuperada a lista de avaliações
   * @return uma lista com todas as avaliações do aluno de acordo com o Id
   */
  List<EvaluationPhysical> getAllAvaluationPhysicalId(Long id);


}
