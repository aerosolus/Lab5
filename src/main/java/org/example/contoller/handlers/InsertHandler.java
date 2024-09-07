package org.example.contoller.handlers;

import org.example.inputOutput.HumanBeingFieldValuesGetter;
import org.example.Main;
import org.example.collectionEntities.HumanBeing;
import org.example.contoller.Command;
import org.example.contoller.Handler;
import org.example.contoller.commands.InsertCommand;
import org.example.exceptions.NotCorrectException;
import org.example.inputOutput.TerminalInputManager;
import org.example.utility.ServerEntryPoint;
import static org.example.Main.terminalOutputManager;

/**
 * Handles the "insert" command, responsible for adding a new HumanBeing to the collection.
 * Implements the Handler interface to handle the "insert" command for inserting a HumanBeing into the collection.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 *
 * @see Main
 * @see org.example.contoller.Handler
 * @see org.example.contoller.commands.InsertCommand
 */
public class InsertHandler implements Handler {

    /**
     * The Command object associated with this handler.
     */
    private Command command;

    /**
     * The HumanBeing object being inserted into the collection.
     */
    private HumanBeing humanBeing;

    /**
     * The key of the HumanBeing being inserted.
     */
    private Integer key;

    /**
     * Processes the input arguments for the insert command.
     *
     * @param args The input arguments provided by the user.
     * @throws NotCorrectException If the input arguments are invalid.
     */
    @Override
    public void handle(String args) throws NotCorrectException {
        if (args == "") {
            HumanBeingFieldValuesGetter humanBeingFieldValuesGetter =
                    new HumanBeingFieldValuesGetter(new TerminalInputManager(System.in, terminalOutputManager),
                    terminalOutputManager);
            this.key = humanBeingFieldValuesGetter.getHumanBeingKey();
            if (!ServerEntryPoint.collectionManager.containsKey(key)) {
                this.humanBeing = Main.terminalManager.createHumanBeing();
                terminalOutputManager.println("Заданный объект получил значение поля id, равное " + this.humanBeing.getId());
                CreateCommand();
            }
            else {
                terminalOutputManager.println("В коллекции уже присутствует элемент с таким ключом! Добавление запрещено.");
            }
        } else {
            throw new NotCorrectException();
        }
    }

    /**
     * Retrieves the Command object associated with this handler.
     *
     * @return The InsertCommand object managed by this handler.
     */
    @Override
    public Command getCommand() {
        return command;
    }

    /**
     * Creates a new InsertCommand instance with the current key and HumanBeing objects.
     */
    @Override
    public void CreateCommand(){
        this.command = new InsertCommand(key, humanBeing);
    }
}