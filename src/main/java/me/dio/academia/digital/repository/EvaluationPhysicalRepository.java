package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.EvaluationPhysical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationPhysicalRepository extends JpaRepository<EvaluationPhysical, Long> {

}
