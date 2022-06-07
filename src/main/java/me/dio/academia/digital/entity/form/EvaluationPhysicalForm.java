package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationPhysicalForm {

  //@Positive(message = "O Id do customer precisa ser positivo.")
  private Long customerId;

  //@NotNull(message = "Preencha o campo corretamente.")
  //@Positive(message = "${validatedValue}' precisa ser positivo.")
  private double weight;

  //@NotNull(message = "Preencha o campo corretamente.")
  //@Positive(message = "${validatedValue}' precisa ser positivo.")
  //@DecimalMin(value = "150", message = "'${validatedValue}' precisa ser no mínimo {value}.")
  private double height;
}
