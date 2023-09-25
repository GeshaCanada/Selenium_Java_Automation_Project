package ua.foxminded.scarb.helpers;

public class NotSupportedBrowserException extends RuntimeException {
    public NotSupportedBrowserException(String errorMessage) {
        super(errorMessage);
    }
}
