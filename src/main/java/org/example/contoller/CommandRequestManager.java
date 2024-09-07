package org.example.contoller;

import org.example.Main;
import org.example.contoller.handlers.*;
import org.example.exceptions.NotCorrectException;
import java.util.HashMap;

/**
 * Manages command requests and executes corresponding handlers.
 * This class serves as a central manager for handling various commands in the system.
 * It maintains a map of command names to their corresponding handler objects and
 * provides methods for executing commands based on user input.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 *
 * @see Main
 * @see org.example.contoller.handlers
 * @see java.util.HashMap
 */

public class CommandRequestManager {

    /**
     * A HashMap storing command names as keys and their corresponding Handler objects as values.
     */
    private HashMap<String, Handler> commands;

    /**
     * Constructs a new CommandRequestManager instance, initializing the commands map.
     * This constructor populates the map with various handlers for different commands.
     */
    public CommandRequestManager() {
        commands = new HashMap<>();
        initializeCommands();
    }

    /**
     * Initializes the commands map with handler objects for various commands.
     */
    private void initializeCommands() {
        commands.put("help", new HelpHandler());
        commands.put("info", new InfoHandler());
        commands.put("show", new ShowHandler());
        commands.put("insert", new InsertHandler());
        commands.put("update", new UpdateHandler());
        commands.put("remove_key", new RemoveKeyHandler());
        commands.put("clear", new ClearHandler());
        commands.put("save", new SaveHandler());
        commands.put("execute_script", new ExecuteScriptHandler());
        commands.put("exit", new ExitHandler());
        commands.put("remove_lower", new RemoveLowerHandler());
        commands.put("remove_greater_key", new RemoveGreaterKeyHandler());
        commands.put("remove_lower_key", new RemoveLowerKeyHandler());
        commands.put("print_ascending", new PrintAscendingHandler());
        commands.put("print_descending", new PrintDescendingHandler());
        commands.put("print_field_descending_car", new PrintFieldDescendingCarHandler());
    }

    /**
     * Prepares for shipment by executing the specified command handler
     * based on the input arguments.
     *
     * @param commandName The name of the command to be executed.
     * @param arguments The arguments for the command.
     */
    public void preparationForShipment(String commandName, String arguments){
        try {
            Handler handler = commands.get(commandName);
            handler.handle(arguments);
            Main.serverEntryPoint.performCom(handler);
        } catch (NullPointerException | NotCorrectException exp) {
            Main.terminalOutputManager.println("Команда введена некорректно!");
        }
    }
}
