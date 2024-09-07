package org.example.exceptions;

/**
 * Represents a NotCorrectException.
 * This exception is thrown when incorrect input is encountered during collection operations.
 * It signals that the input provided is not valid according to the system's expectations.
 * It extends the base Exception class to represent a general error condition.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class NotCorrectException extends Exception {

    /**
     * Returns a message describing the nature of the exception.
     * The default message indicates that invalid input occurred and work with the collection will be finished.
     *
     * @return A String containing the exception message.
     */
    public String getMessage() {
        return "Invalid input. Work with the collection will be finished";
    }
}