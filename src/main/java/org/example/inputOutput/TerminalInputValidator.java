package org.example.inputOutput;

/**
 * Class for validating and storing terminal input.
 * This class encapsulates the command name and arguments received through the terminal.
 *
 * @author Aerosolus
 * @version 1.1
 * @since 1.1
 */
public class TerminalInputValidator {

    /**
     * The name of the command entered through the terminal.
     */
    private String commandName;

    /**
     * The arguments passed along with the command.
     */
    private String commandArguments;

    /**
     * Constructs a TerminalInputValidator with the given command name and arguments.
     *
     * @param commandName The name of the command entered through the terminal.
     * @param commandArguments The arguments passed along with the command.
     */
    public TerminalInputValidator(String commandName, String commandArguments) {
        this.commandName = commandName;
        this.commandArguments = commandArguments;
    }

    /**
     * Gets the name of the command entered through the terminal.
     *
     * @return The command name.
     */
    public String getCommandName() {
        return commandName;
    }

    /**
     * Gets the arguments passed along with the command.
     *
     * @return The command arguments.
     */
    public String getCommandArguments() {
        return commandArguments;
    }
}
