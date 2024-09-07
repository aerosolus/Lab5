package org.example.exceptions;

/**
 * Represents a NoSuchCommandException.
 * This exception is thrown when an attempt is made to execute a command that does not exist or has incorrect arguments.
 * It signals that the command provided is either unknown or improperly formatted according to the system's expectations.
 * It extends the base Exception class to represent a specific error condition related to command handling.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class NoSuchCommandException extends Exception{
    public String getMessage() {
        return "Command with wrong argument. Type \"help\" to get all commands with their name and description";
    }
}
