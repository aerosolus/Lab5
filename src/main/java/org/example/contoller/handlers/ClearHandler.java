package org.example.contoller.handlers;

import org.example.contoller.Command;
import org.example.contoller.Handler;
import org.example.contoller.commands.ClearCommand;
import org.example.exceptions.NotCorrectException;

/**
 * Handles the "clear" command, responsible for clearing the collection.
 * Implements the Handler interface to handle the "clear" command.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 *
 * @see org.example.contoller.Handler
 * @see org.example.contoller.commands.ClearCommand
 */
public class ClearHandler implements Handler {

    /**
     * The Command object associated with this handler.
     */
    private Command command;

    /**
     * Processes the input arguments for the clear command.
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
     * @return The ClearCommand object managed by this handler.
     */
    @Override
    public Command getCommand() {
        return command;
    }

    /**
     * Creates a new ClearCommand instance and assigns it to the command field.
     */
    @Override
    public void CreateCommand() {
        this.command = new ClearCommand();
    }
}
