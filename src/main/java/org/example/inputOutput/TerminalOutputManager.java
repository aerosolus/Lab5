package org.example.inputOutput;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Manages output to the terminal.
 * This class provides methods to print important messages and handle various output scenarios.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class TerminalOutputManager {

    /**
     * Output stream for writing to the terminal.
     */
    private final OutputStream outputStream;

    /**
     * Constructs a TerminalOutputManager with the given output stream.
     *
     * @param outputStream Output stream for writing to the terminal.
     */
    public TerminalOutputManager(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * Prints an important message to the terminal.
     *
     * @param string The message to be printed.
     */
    public void println(String string) {
        printlnImportantMessage(string);
    }

    /**
     * Prints a message indicating incorrect input.
     */
    public void printlnNotCorrectInput() {
        println("Был введен некорректный формат данных!");
    }

    /**
     * Prints an important message to the terminal.
     *
     * @param string The message to be printed.
     */
    public void printlnImportantMessage(String string) {
        try {
            outputStream.write(string.getBytes());
            outputStream.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints a prompt asking the user to enter a command.
     */
    public void printlnWriteCommand(){
        println("Введите команду:");
    }

    /**
     * Writes a string to the output stream followed by a newline character.
     *
     * @param string The string to be written.
     */
    public void printlnToTheOutputStream(String string)
    {
        try {
            outputStream.write(string.getBytes());
            outputStream.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
