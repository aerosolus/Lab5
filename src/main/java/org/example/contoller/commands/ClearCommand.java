package org.example.contoller.commands;

import org.example.contoller.Command;
import org.example.utility.ServerEntryPoint;

/**
 * Represents a command to clear the collection managed by ServerEntryPoint.
 * Implements the Command interface to handle the "clear" command.
 *
 * @author Aerosolus
 * @version 1.0
 *
 * @see org.example.contoller.Command
 * @see org.example.utility.ServerEntryPoint
 */

public class ClearCommand implements Command {

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "очистить коллекцию";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "clear ";
    }

    /**
     * Executes the clear operation on the collection managed by ServerEntryPoint.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.clear();
    }
}
