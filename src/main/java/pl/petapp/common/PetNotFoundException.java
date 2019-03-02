package pl.petapp.common;

public class PetNotFoundException extends RuntimeException {

  public PetNotFoundException(Long id) {
      super("Nie można znaleźć zwierzaka o id: " + id);
  }
}
