package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  /**
   *
   * @param birthDate: data de nascimento dos alunos
   * @return lista com todos os alunos com a data de nascimento passada como parâmetro da função
   */
  List<Customer> findByBirthDate(LocalDate birthDate);

}
