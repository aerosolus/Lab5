package org.example.contoller.commands;

import org.example.Main;
import org.example.collectionEntities.HumanBeing;
import org.example.contoller.Command;
import org.example.utility.ServerEntryPoint;

/**
 * Represents a command to add a new element to the collection with a specified key.
 * Implements the Command interface to handle the "insert" command.
 *
 * @author Aerosolus
 * @version 1.0
 *
 * @see Main
 * @see HumanBeing
 * @see org.example.contoller.Command
 * @see org.example.utility.ServerEntryPoint
 */
public class InsertCommand implements Command {

    /**
     * The argument representing the key for adding the element.
     */
    private Integer argument;

    /**
     * The HumanBeing object to be added to the collection.
     * */
    private HumanBeing humanBeing;

    /**
     * Constructs a new InsertCommand instance with the given argument and HumanBeing object.
     *
     * @param argument The key for adding the element to the collection.
     * @param humanBeing The HumanBeing object to be added.
     */
    public InsertCommand(Integer argument, HumanBeing humanBeing) {
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
        return getName() + "добавить новый элемент с заданным ключом";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "insert ";
    }

    /**
     * Executes the insert operation, adding the specified HumanBeing to the collection with the given key.
     */
    @Override
    public void execute(){
        ServerEntryPoint.collectionManager.addToCollection(argument, humanBeing);
    }
}
