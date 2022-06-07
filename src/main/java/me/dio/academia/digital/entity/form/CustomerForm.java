package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerForm {

  @NotEmpty(message = "Preencha o campo corretamente.")
  @Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String name;

  @NotEmpty(message = "Preencha o campo corretamente.")
  //@CPF(message = "'${validatedValue}' é inválido!")
  private String cpf;

  @NotEmpty(message = "Preencha o campo corretamente.")
  @Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String address;

  @NotNull(message = "Prencha o campo corretamente.")
  @Past(message = "Data '${validatedValue}' é inválida.")
  private LocalDate birthDate;
}
