package org.example.contoller.commands;

import org.example.contoller.Command;
import org.example.utility.ServerEntryPoint;

/**
 * Represents a command to display all elements of the collection in string representation.
 * Implements the Command interface to handle the "show" command.
 *
 * @author Aerosolus
 * @version 1.0
 *
 * @see org.example.contoller.Command
 * @see org.example.utility.ServerEntryPoint
 */
public class ShowCommand implements Command {

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "show ";
    }

    /**
     * Executes the show operation, displaying all elements of the collection in string representation.
     */
    @Override
    public void execute(){
        ServerEntryPoint.collectionManager.showCollection();
    }
}
