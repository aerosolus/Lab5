package org.example.contoller.commands;

import org.example.collectionEntities.HumanBeing;
import org.example.contoller.Command;
import org.example.utility.ServerEntryPoint;

/**
 * Represents a command to update an element in the collection based on its ID.
 * Implements the Command interface to handle the "update" command.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 *
 * @see org.example.contoller.Command
 * @see org.example.utility.ServerEntryPoint
 */
public class UpdateCommand implements Command {

    /**
     * The ID of the element to be updated in the collection.
     */
    private Integer argument;

    /**
     * The HumanBeing object containing the new data to update the element.
     */
    private HumanBeing humanBeing;

    /**
     * Constructs a new UpdateCommand instance with the given argument and HumanBeing object.
     *
     * @param argument The ID of the element to be updated.
     * @param humanBeing The HumanBeing object containing the new data.
     */
    public UpdateCommand(Integer argument, HumanBeing humanBeing) {
        this.argument = argument;
        this.humanBeing = humanBeing;
    }

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "обновить значение элемента коллекции, id которого равен заданному";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "update ";
    }

    /**
     * Executes the update operation on the specified element in the collection
     * by passing the argument (ID) and the new HumanBeing object.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.update(argument, humanBeing);
    }
}
