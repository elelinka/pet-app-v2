package pl.petapp.common;

public class OwnerNotFoundException extends RuntimeException {

    public OwnerNotFoundException(Long id) {
        super("Nie można znaleźć właściciela o id: " + id);
    }
}