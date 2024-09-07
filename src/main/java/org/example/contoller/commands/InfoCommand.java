package org.example.contoller.commands;

import org.example.Main;
import org.example.contoller.Command;
import org.example.utility.ServerEntryPoint;

/**
 * Represents a command to display information about the collection.
 * Implements the Command interface to handle the "info" command.
 *
 * @author Aerosolus
 * @version 1.0
 *
 * @see Main
 * @see org.example.contoller.Command
 * @see org.example.utility.ServerEntryPoint
 */
public class InfoCommand implements Command {

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести в стандартный поток вывода информацию о коллекции";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "info ";
    }

    /**
     * Executes the info operation, displaying information about the collection.
     */
    @Override
    public void execute() {
        Main.terminalOutputManager.println(ServerEntryPoint.collectionManager.collectionInfo());
    }
}
