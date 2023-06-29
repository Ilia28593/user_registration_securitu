package dev.exception;

/**
 * Исключение используется для ошибок аутентификации и авторизации.
 *
 * @author upagge 21.06.2022
 */
public class AuthException extends RuntimeException {

    public AuthException(String message) {
        super(message);
    }

}
