package org.example.contoller.handlers;

import org.example.contoller.Command;
import org.example.contoller.Handler;
import org.example.contoller.commands.PrintDescendingCommand;
import org.example.exceptions.NotCorrectException;

/**
 * Handles the "print_descending" command, responsible for printing the collection in descending order.
 * Implements the Handler interface to handle the "print_descending" command.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 *
 * @see org.example.contoller.Handler
 * @see org.example.contoller.commands.PrintDescendingCommand
 */
public class PrintDescendingHandler implements Handler {
    private Command command;

    /**
     * Processes the input arguments for the print_descending command.
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
     * @return The PrintDescendingCommand object managed by this handler.
     */
    @Override
    public Command getCommand() {
        return command;
    }

    /**
     * Creates a new PrintDescendingCommand instance and assigns it to the command field.
     */
    @Override
    public void CreateCommand() {
        this.command = new PrintDescendingCommand();
    }
}