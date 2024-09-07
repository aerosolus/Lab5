package org.example.contoller.handlers;

import org.example.contoller.Command;
import org.example.contoller.Handler;
import org.example.contoller.commands.ExecuteScriptCommand;
import org.example.exceptions.NotCorrectException;

/**
 * Handles the "execute_script" command, responsible for executing scripts from specified files.
 * Implements the Handler interface to handle the "execute_script" command.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 *
 * @see org.example.contoller.Handler
 * @see org.example.contoller.commands.ExecuteScriptCommand
 */
public class ExecuteScriptHandler implements Handler {

    /**
     * The Command object associated with this handler.
     */
    private Command command;

    /**
     * The filepath of the script to be executed.
     */
    private String filepath;

    /**
     * Processes the input arguments for the execute_script command.
     *
     * @param args The input arguments provided by the user.
     * @throws NotCorrectException If the input arguments are invalid.
     */
    @Override
    public void handle(String args) throws NotCorrectException {
        if (args != "") {
            filepath = args;
            CreateCommand();
        } else {
            throw new NotCorrectException();
        }
    }

    /**
     * Retrieves the Command object associated with this handler.
     *
     * @return The ExecuteScriptCommand object managed by this handler.
     */
    @Override
    public Command getCommand() {
        return command;
    }

    /**
     * Creates a new ExecuteScriptCommand instance with the specified filepath and assigns it to the command field.
     */
    @Override
    public void CreateCommand() {
        this.command = new ExecuteScriptCommand(filepath);
    }
}