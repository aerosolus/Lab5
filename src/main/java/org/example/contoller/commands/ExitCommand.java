package org.example.contoller.commands;

import org.example.contoller.Command;

/**
 * Represents a command to exit the program without saving any changes.
 * Implements the Command interface to handle the "exit" command.
 *
 * @author Aerosolus
 * @version 1.0
 *
 * @see org.example.contoller.Command
 */
public class ExitCommand implements Command {

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "завершить программу (без сохранения в файл)";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "exit ";
    }
    /**
     * Executes the exit operation, terminating the program immediately.
     */
    @Override
    public void execute() {
        System.exit(0);
    }
}
