package org.example.contoller.commands;

import org.example.contoller.Command;
import org.example.utility.ServerEntryPoint;

/**
 * Represents a command to print the elements of the collection in descending order.
 * Implements the Command interface to handle the "print_descending" command.
 *
 * @author Aerosolus
 * @version 1.0
 *
 * @see org.example.contoller.Command
 * @see org.example.utility.ServerEntryPoint
 */
public class PrintDescendingCommand implements Command {

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести элементы коллекции в порядке убывания";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "print_descending ";
    }

    /**
     * Executes the print ascending operation, printing the elements of the collection in ascending order.
     */
    @Override
    public void execute(){
        ServerEntryPoint.collectionManager.printCollectionDescending();
    }
}
