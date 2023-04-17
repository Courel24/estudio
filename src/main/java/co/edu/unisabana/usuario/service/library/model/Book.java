package co.edu.unisabana.usuario.service.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Data
public class Book {

  private String name;
  private int year;
  private String author;
  private boolean rRated;
  private final CategoryBook category;

}
