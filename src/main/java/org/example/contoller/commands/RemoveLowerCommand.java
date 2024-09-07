package org.example.contoller.commands;

import org.example.collectionEntities.HumanBeing;
import org.example.contoller.Command;
import org.example.utility.ServerEntryPoint;

/**
 * Represents a command to remove all elements from the collection that are lower than a given HumanBeing entity.
 * Implements the Command interface to handle the "remove_lower" command.
 *
 * @author Aerosolus
 * @version 1.0
 *
 * @see org.example.contoller.Command
 * @see org.example.utility.ServerEntryPoint
 */
public class RemoveLowerCommand implements Command {

    /**
     * The HumanBeing entity used to compare with elements in the collection.
     */
    private HumanBeing humanBeing;

    /**
     * Constructs a new RemoveLowerCommand instance with the given HumanBeing entity.
     *
     * @param humanBeing The HumanBeing entity to use for comparison.
     */
    public RemoveLowerCommand(HumanBeing humanBeing){
        this.humanBeing = humanBeing;
    }

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "удалить из коллекции все элементы, меньшие, чем заданный";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "remove_lower ";
    }

    /**
     * Executes the remove lower operation,
     * removing all elements from the collection that are lower than the given HumanBeing entity.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.removeLower(humanBeing);
    }
}
