package org.example.contoller;

import org.example.exceptions.NotCorrectException;

/**
 * Manages the creation and execution of commands within the system.
 * Defines the behavior for handling commands and creating new commands.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public interface Handler {

    /**
     * Processes the given arguments and executes the corresponding command.
     *
     * @param args The input arguments to be processed.
     * @throws NotCorrectException If the input arguments are invalid or cannot be processed.
     */
    public void handle(String args) throws NotCorrectException;

    /**
     * Retrieves the current command being handled.
     *
     * @return The Command object associated with the current handling operation.
     */
    public Command getCommand();

    /**
     * Creates a new command based on the current state or requirements.
     */
    public void CreateCommand();
}
