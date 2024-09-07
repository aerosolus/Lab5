package org.example.contoller.commands;

import org.example.Main;
import org.example.contoller.Command;

/**
 * Represents a command to execute a script file.
 * Implements the Command interface to handle the "execute_script" command.
 *
 * @author Aerosolus
 * @version 1.0
 *
 * @see org.example.contoller.Command
 * @see org.example.Main
 */
public class ExecuteScriptCommand implements Command {

    /**
     * The path to the script file to be executed.
     */
    private String filepath;

    /**
     * Constructs an ExecuteScriptCommand instance with the specified path to the script file.
     *
     * @param filepath The path to the script file.
     */
    public ExecuteScriptCommand(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "считать и исполнить скрипт из указанного файла";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "execute_script ";
    }

    /**
     * Executes the script file specified in the constructor.
     */
    @Override
    public void execute() {
        Main.terminalInputManager.readScript(filepath);
    }
}