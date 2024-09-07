package org.example.contoller.handlers;

import org.example.contoller.Command;
import org.example.contoller.Handler;
import org.example.contoller.commands.ExitCommand;
import org.example.exceptions.NotCorrectException;

/**
 * Handles the "exit" command, responsible for initiating the program termination process.
 * Implements the Handler interface to handle the "exit" command.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 *
 * @see org.example.contoller.Handler
 * @see org.example.contoller.commands.ExitCommand
 */
public class ExitHandler implements Handler {

    /**
     * The Command object associated with this handler.
     */
    private Command command;

    /**
     * Processes the input arguments for the exit command.
     *
     * @param args The input arguments provided by the user.
     * @throws NotCorrectException If the input arguments are invalid.
     */
    @Override
    public void handle(String args) throws NotCorrectException {
        if (args == "") {
            CreateCommand();
        } else {
            throw new NotCorrectException();
        }
    }

    /**
     * Retrieves the Command object associated with this handler.
     *
     * @return The ExitCommand object managed by this handler.
     */
    @Override
    public Command getCommand() {
        return command;
    }

    /**
     * Creates a new ExitCommand instance and assigns it to the command field.
     */
    @Override
    public void CreateCommand() {
        this.command = new ExitCommand();
    }
}
