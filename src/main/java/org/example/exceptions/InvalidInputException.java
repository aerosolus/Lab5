package org.example.exceptions;

/**
 * Represents an InvalidInputException.
 * This custom exception is thrown when invalid input is detected during operations involving collections.
 * It extends NullPointerException to indicate that the cause of the error is likely related to null references.
 * This exception is typically used in scenarios where user input or data processing fails validation checks.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class InvalidInputException extends NullPointerException {

    /**
     * Returns a message describing the nature of the exception.
     * The default message indicates that incorrect input occurred and work with the collection has been terminated.
     *
     * @return A String containing the exception message.
     */
    public String getMessage() {
        return "Некорректный ввод. Работа с коллекцией завершена.";
    }
}