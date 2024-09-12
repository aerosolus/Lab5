package org.example.contoller.handlers;

import org.example.Main;
import org.example.collectionEntities.HumanBeing;
import org.example.contoller.Command;
import org.example.contoller.Handler;
import org.example.contoller.commands.RemoveLowerCommand;
import org.example.exceptions.NotCorrectException;

/**
 * Handles the "remove lower" command,
 * responsible for executing the RemoveLowerCommand to remove elements from the collection
 * that are lower than a given HumanBeing entity.
 * Implements the Handler interface to handle the "remove_lower" command.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 *
 * @see org.example.contoller.Handler
 * @see org.example.contoller.commands.RemoveLowerCommand
 */
public class RemoveLowerHandler implements Handler {

    /**
     * The HumanBeing instance associated with this handler.
     */
    HumanBeing humanBeing;

    /**
     * The Command object associated with this handler.
     */
    private Command command;

    /**
     * Processes the input arguments for the remove_lower command.
     *
     * @param args The input arguments provided by the user.
     * @throws NotCorrectException If the input arguments are invalid.
     */
    @Override
    public void handle(String args) throws NotCorrectException {
        if (!Main.script) {
            if (args == "") {
                this.humanBeing = Main.terminalManager.createHumanBeing();
                CreateCommand();
            } else {
                throw new NotCorrectException();
            }
        } else {
            this.humanBeing = Main.terminalManager.readHumanBeing();
            CreateCommand();
        }
    }

    /**
     * Retrieves the Command object associated with this handler.
     *
     * @return The RemoveKeyCommand object managed by this handler.
     */
    @Override
    public Command getCommand() {
        return command;
    }

    /**
     * Creates a new RemoveLowerCommand with the current HumanBeing instance.
     */
    @Override
    public void CreateCommand() {
        this.command = new RemoveLowerCommand(humanBeing);
    }
}
