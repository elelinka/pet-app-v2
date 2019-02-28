package pl.petapp.common;

public class OwnerNotFoundException extends RuntimeException {

    private final Long ownerId;

    public OwnerNotFoundException(String s, Long ownerId) {
        this.ownerId = ownerId;
    }
}