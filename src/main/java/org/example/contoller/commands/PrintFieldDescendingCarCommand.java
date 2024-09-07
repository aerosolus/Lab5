package org.example.contoller.commands;

import org.example.contoller.Command;
import org.example.utility.ServerEntryPoint;

/**
 * Represents a command to print the values of the 'car' field for all elements in descending order.
 * Implements the Command interface to handle the "print_field_descending_car" command.
 *
 * @author Aerosolus
 * @version 1.0
 *
 * @see org.example.contoller.Command
 * @see org.example.utility.ServerEntryPoint
 */
public class PrintFieldDescendingCarCommand implements Command {

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести значения поля car всех элементов в порядке убывания";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "print_field_descending_car ";
    }

    /**
     * Executes the print descending car operation, displaying the values of the 'car' field for all elements in descending order.
     */
    @Override
    public void execute(){
        ServerEntryPoint.collectionManager.printFieldDescendingCar();
    }
}
