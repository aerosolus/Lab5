package org.example;

import org.example.contoller.CommandRequestManager;
import org.example.inputOutput.TerminalInputManager;
import org.example.inputOutput.TerminalManager;
import org.example.inputOutput.TerminalOutputManager;
import org.example.utility.ServerEntryPoint;

/**
 * The main entry point of the application.
 * This class initializes and manages the core components of the system.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class Main {

    /**
     * Flag indicating whether the program should run in script mode.
     */
    public static boolean script = false;

    /**
     * Manager for handling terminal output.
     */
    public static TerminalOutputManager terminalOutputManager;

    /**
     * Entry point for server operations.
     */
    public static ServerEntryPoint serverEntryPoint;

    /**
     * Manager for handling terminal input.
     */
    public static TerminalInputManager terminalInputManager;

    /**
     * Manager for handling terminal interactions and command processing.
     */
    public static TerminalManager terminalManager;

    /**
     * The main entry point of the application.
     * Initializes all necessary components and starts the main loop.
     *
     * @param args Command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
            serverEntryPoint = new ServerEntryPoint();
            terminalOutputManager = new TerminalOutputManager(System.out);
            terminalInputManager = new TerminalInputManager(System.in, terminalOutputManager);
            CommandRequestManager commandRequestManager = new CommandRequestManager();
            terminalManager = new TerminalManager(commandRequestManager, terminalInputManager, terminalOutputManager);
            terminalManager.start();
    }
}