package org.example.contoller.handlers;

import org.example.contoller.Command;
import org.example.contoller.Handler;
import org.example.contoller.commands.RemoveKeyCommand;
import org.example.exceptions.NotCorrectException;

/**
 * Handles the "remove_key" command,
 * responsible for executing the RemoveKeyCommand to remove an element from the collection based on its key.
 * Implements the Handler interface to handle the "remove_key" command.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 *
 * @see org.example.contoller.Handler
 * @see org.example.contoller.commands.RemoveKeyCommand
 */
public class RemoveKeyHandler implements Handler {

    /**
     * The key value used to identify the element to be removed from the collection.
     */
    private Integer key;

    /**
     * The Command object associated with this handler.
     */
    private Command command;

    /**
     * Processes the input arguments for the remove_key command.
     *
     * @param args The input arguments provided by the user.
     * @throws NotCorrectException If the input arguments are invalid.
     */
    @Override
    public void handle(String args) throws NotCorrectException {
        if (args != ""){
            try {
                key = Integer.parseInt(args);
            } catch (Exception e) {
                throw new NotCorrectException();
            }
            CreateCommand();
        } else {
            throw new NotCorrectException();
        }
    }

    /**
     * Retrieves the Command object associated with this handler.
     *
     * @return The RemoveKeyCommand object managed by this handler.
     */
    @Override
    public Command getCommand() {
        return command;
    }

    /**
     * Creates a new RemoveKeyCommand instance with the stored key and assigns it to the command field.
     * */
    @Override
    public void CreateCommand() {
        this.command = new RemoveKeyCommand(key);
    }
}
