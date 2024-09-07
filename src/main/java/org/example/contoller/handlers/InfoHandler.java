package org.example.contoller.handlers;

import org.example.contoller.Command;
import org.example.contoller.Handler;
import org.example.contoller.commands.InfoCommand;
import org.example.exceptions.NotCorrectException;

/**
 * Handles the "info" command, responsible for providing information about the collection.
 * Implements the Handler interface to handle the "info" command.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 *
 * @see org.example.contoller.Handler
 * @see org.example.contoller.commands.InfoCommand
 */
public class InfoHandler implements Handler {

    /**
     * The Command object associated with this handler.
     */
    private Command command;

    /**
     * Processes the input arguments for the info command.
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
     * @return The InfoCommand object managed by this handler.
     */
    @Override
    public Command getCommand() {
        return command;
    }

    /**
     * Creates a new InfoCommand instance and assigns it to the command field.
     */
    @Override
    public void CreateCommand() {
        this.command = new InfoCommand();
    }
}
