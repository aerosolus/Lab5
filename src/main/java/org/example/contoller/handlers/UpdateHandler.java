package org.example.contoller.handlers;


import org.example.Main;
import org.example.collectionEntities.HumanBeing;
import org.example.contoller.Command;
import org.example.contoller.Handler;
import org.example.contoller.commands.UpdateCommand;
import org.example.exceptions.NotCorrectException;
import org.example.inputOutput.HumanBeingFieldValuesGetter;
import org.example.inputOutput.TerminalInputManager;
import org.example.utility.ServerEntryPoint;

import static org.example.Main.terminalManager;
import static org.example.Main.terminalOutputManager;

/**
 * Handles the "update" command, responsible for updating an existing element in the collection.
 * Implements the Handler interface to handle the "update" command for updating a HumanBeing in the collection.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 *
 * @see Main
 * @see org.example.contoller.Handler
 * @see org.example.contoller.commands.UpdateCommand
 */
public class UpdateHandler implements Handler {

    /**
     * The Command object associated with this handler.
     */
    private Command command;

    /**
     * The HumanBeing object being updated in the collection.
     */
    private HumanBeing humanBeing;

    /**
     * The ID of the element to be updated in the collection.
     */
    private Integer id;

    /**
     * The key value for the HumanBeing object to be updated.
     */
    private Integer key;

    /**
     * Handles the "update" command.
     * Parses the input argument as an integer ID.
     * Retrieves the HumanBeing object associated with the given ID.
     * Prompts the user for field values to update.
     * Creates a new UpdateCommand with the retrieved HumanBeing object.
     *
     * @param args The command line argument (ID of the element to update).
     * @throws NotCorrectException if the input is invalid or the element with the specified ID doesn't exist.
     */
    @Override
    public void handle(String args) throws NotCorrectException {
        if (!Main.script) {
            if (args != "") {
                try {
                    id = Integer.parseInt(args);
                } catch (Exception e) {
                    throw new NotCorrectException();
                }
                if (ServerEntryPoint.collectionManager.containsId(id)) {
                    HumanBeingFieldValuesGetter humanBeingFieldValuesGetter =
                            new HumanBeingFieldValuesGetter(new TerminalInputManager(System.in, terminalOutputManager),
                                    terminalOutputManager);
                    this.key = humanBeingFieldValuesGetter.getHumanBeingKey();
                    this.humanBeing = terminalManager.updateHumanBeing(id);
                    CreateCommand();
                } else {
                    terminalOutputManager.println("В коллекции отсутствует элемент с указанным значением поля id!");
                }
            } else {
                throw new NotCorrectException();
            }
        } else {
            id = Integer.parseInt(args);
            if (ServerEntryPoint.collectionManager.containsId(id)) {
                this.key = terminalManager.readHumanBeingKey();
                this.humanBeing = terminalManager.readUpdateHumanBeing(id);
                CreateCommand();
            } else {
                terminalOutputManager.println("В коллекции отсутствует элемент с указанным значением поля id!");
            }
        }
    }

    /**
     * Retrieves the Command object associated with this handler.
     *
     * @return The UpdateCommand object managed by this handler.
     */
    @Override
    public Command getCommand() {
        return command;
    }

    /**
     * Creates a new UpdateCommand instance with the retrieved key and HumanBeing objects.
     * Sets the newly created UpdateCommand as the current command for handling.
     */
    @Override
    public void CreateCommand() {
        this.command = new UpdateCommand(key, humanBeing);
    }
}
