package org.example.contoller.commands;

import org.example.contoller.Command;
import org.example.utility.ServerEntryPoint;

/**
 * Represents a command to remove an element from the collection based on its key.
 * Implements the Command interface to handle the "remove_key" command.
 *
 * @author Aerosolus
 * @version 1.0
 *
 * @see org.example.contoller.Command
 * @see org.example.utility.ServerEntryPoint
 */
public class RemoveKeyCommand implements Command {

    /**
     * The key value used to identify the element to be removed from the collection.
     */
    private Integer key;

    /**
     * Constructs a new RemoveKeyCommand instance with the given key value.
     *
     * @param argument The key value to use for removing the element.
     */
    public RemoveKeyCommand(Integer argument){
        this.key = argument;
    }

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "удалить элемент из коллекции по его ключу";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "remove_key ";
    }

    /**
     * Executes the remove operation, deleting the element with the specified key from the collection.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.remove(key);
    }
}
