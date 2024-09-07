package org.example.contoller.commands;

import org.example.contoller.Command;
import org.example.utility.ServerEntryPoint;

/**
 * Represents a command to remove all elements from the collection whose keys exceed a given value.
 * Implements the Command interface to handle the "remove_greater_key" command.
 *
 * @author Aerosolus
 * @version 1.0
 *
 * @see org.example.contoller.Command
 * @see org.example.utility.ServerEntryPoint
 */
public class RemoveGreaterKeyCommand implements Command {

    /**
     * The argument used to compare keys with the elements in the collection.
     */
    private Integer argument;

    /**
     * Constructs a new RemoveGreaterKeyCommand instance with the given argument.
     *
     * @param argument The value to compare keys against.
     */
    public RemoveGreaterKeyCommand(Integer argument){
        this.argument = argument;
    }

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "удалить из коллекции все элементы, ключ которых превышает заданный";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "remove_greater_key ";
    }

    /**
     * Executes the remove greater key operation, removing all elements whose keys exceed the given argument.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.removeGreaterKey(argument);
    }
}
