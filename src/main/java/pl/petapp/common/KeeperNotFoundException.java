package pl.petapp.common;

public class KeeperNotFoundException extends RuntimeException {

    private final Long keeperId;

    public KeeperNotFoundException(String s, Long keeperId) {
        this.keeperId = keeperId;
    }
}