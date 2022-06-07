package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_evaluations")
public class EvaluationPhysical {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Column(name = "evaluation_date")
  private LocalDateTime evaluationDate = LocalDateTime.now();

  private double weight;

  @Column(name="height")
  private double height;

}
