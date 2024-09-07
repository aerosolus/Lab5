package org.example.contoller.handlers;

import org.example.contoller.Command;
import org.example.contoller.Handler;
import org.example.contoller.commands.SaveCommand;
import org.example.exceptions.NotCorrectException;

/**
 * Handles the "save" command, responsible for executing the SaveCommand to save the collection to a file.
 * Implements the Handler interface to handle the "save" command.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 *
 * @see org.example.contoller.Handler
 * @see org.example.contoller.commands.SaveCommand
 */
public class SaveHandler implements Handler {

    /**
     * The Command object associated with this handler.
     */
    private Command command;

    /**
     * Processes the input arguments for the save command.
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
     * @return The SaveCommand object managed by this handler.
     */
    @Override
    public Command getCommand() {
        return command;
    }

    /**
     * Creates a new SaveCommand instance and assigns it to the command field.
     */
    @Override
    public void CreateCommand() {
        this.command = new SaveCommand();
    }
}
