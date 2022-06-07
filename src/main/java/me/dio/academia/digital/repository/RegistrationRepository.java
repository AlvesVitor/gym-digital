package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

  /**
   *
   * @param adress adress referência para o filtro
   * @return lista de alunos matriculados que residem no adress passado como parâmetro
   */
  @Query(value = "SELECT * FROM tb_registration m " +
      "INNER JOIN tb_customer a ON m.customer_id = a.id " +
      "WHERE a.address = :address", nativeQuery = true)
  List<Registration> findCustomerRegisteredByAddress(String address);


}
