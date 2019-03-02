package pl.petapp.common;

public class KeeperNotFoundException extends RuntimeException {

    public KeeperNotFoundException(Long id) {
        super("Nie można znaleźć opiekuna o id: " + id);
    }
}