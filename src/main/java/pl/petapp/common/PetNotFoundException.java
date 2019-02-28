package pl.petapp.common;

public class PetNotFoundException extends RuntimeException {

    private final Long petId;

    public PetNotFoundException(String s, Long petId) {
        this.petId = petId;
    }
}
