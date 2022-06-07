package me.dio.academia.digital.entity.form;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerUpdateForm {

  private String name;

  private String address;

  private LocalDate birthDate;
}
