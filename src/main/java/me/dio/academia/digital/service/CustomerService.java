package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Customer;
import me.dio.academia.digital.entity.EvaluationPhysical;
import me.dio.academia.digital.entity.form.CustomerForm;
import me.dio.academia.digital.entity.form.CustomerUpdateForm;

import java.util.List;

public interface CustomerService {

    /**
     * Cria um Customer e salva no banco de dados.
     *
     * @param form formulário referente aos dados para criação de um Customer no
     * banco de dados.
     * @return Customer recém-criado.
     */
    Customer create(CustomerForm form);

    /**
     * Retorna um Customer que está no banco de dados de acordo com seu Id.
     *
     * @param customerId id do Customer que será exibido.
     * @return Customer de acordo com o Id fornecido.
     */
    Customer getCustomerId(Long customerId);

    /**
     *
     * @param customerId id do Customer que será recuperada a lista de Avaluation
     * @return uma lista com todas as Avaluation do Customer de acordo com o Id
     */
    List<EvaluationPhysical> getAllAvaluationPhysicalId(Long customerId);

    /**
     * Retorna os Customer que estão no banco de dados.
     *
     * @return Uma lista os Customer que estão salvas no DB.
     */
    List<Customer> getAll(String birthDate);

    /**
     * Atualiza o Customer.
     *
     * @param customerId id do Customer que será atualizado.
     * @param formUpdate formulário referente aos dados necessários para
     * atualização do Customer no banco de dados.
     * @return Customer recém-atualizado.
     */
    Customer update(Long customerId, CustomerUpdateForm formUpdate);

    /**
     * Deleta um Customer específico.
     *
     * @param customerId id do Customer que será removido.
     */
    void delete(Long customerId);

}
