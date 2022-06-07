package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationForm {

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "O Id do customer precisa ser positivo.")
  private Long customerId;
}
