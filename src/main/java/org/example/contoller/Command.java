package org.example.contoller;

/**
 * Represents a command that can be executed within the system.
 * Defines the structure for commands that can be executed.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public interface Command {

    /**
     * Returns a brief description of the command.
     *
     * @return A string describing the purpose of the command.
     */
    public String getDescription();

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    public String getName();

    /**
     * Executes the command.
     */
    public void execute();

}
