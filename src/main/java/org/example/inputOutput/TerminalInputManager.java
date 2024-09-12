package org.example.inputOutput;

import org.example.Main;
import org.example.exceptions.InvalidInputException;

import java.io.*;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Manages input from the terminal and script file.
 * This class provides methods to read terminal input and parse commands,
 * as well as manage script execution.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class TerminalInputManager {

    /**
     * Input stream for reading from the terminal or script file.
     */
    private InputStream inputStream;

    /**
     * Queue to store parsed commands from scripts.
     */
    ArrayDeque<String[]> scriptBox = new ArrayDeque<>();

    /**
     * Output manager for handling terminal output.
     */
    private final TerminalOutputManager outputManager;

    /**
     * Constructs a TerminalInputManager with the given input stream and output manager.
     *
     * @param inputStream   Input stream for reading from the terminal or script file.
     * @param outputManager Output manager for handling terminal output.
     */
    public TerminalInputManager(InputStream inputStream, TerminalOutputManager outputManager) {
        this.inputStream = inputStream;
        this.outputManager = outputManager;
    }

    /**
     * Reads input from the terminal and parses it into a TerminalInputValidator object.
     *
     * @return A TerminalInputValidator object representing the parsed command.
     * @throws NoSuchElementException if the end of the input stream is reached unexpectedly.
     */
    public TerminalInputValidator readTerminal() {
        try {
            Scanner scanners = new Scanner(inputStream);
            String readLine = scanners.nextLine();
            if (readLine.trim().contains(" ")) {
                return
                        new TerminalInputValidator(readLine.trim().split(" ")[0],
                                readLine.trim().split(" ")[readLine.trim().split(" ").length - 1]);
            } else {
                return
                        new TerminalInputValidator(readLine.trim().split(" ")[0], "");
            }
        } catch (NoSuchElementException e) {
            outputManager.println("Строка по некой причине не была прочитана!");
            outputManager.println("Вероятно использовано сочетание Ctrl + D, которое приводит к завершению работы программы.");
            System.exit(1);
        } catch (Exception e) {
            outputManager.printlnWriteCommand();
        }
        return null; //for better program failing, bad parsing -> end;
    }

    /**
     * Field for setting maximum recursion depth
     */
    private static final int recursion_depth = 100;

    /**
     * Field for counting current recursion depth
     */
    private static int recursion_count = 0;

    /**
     * Reads a script file and stores parsed commands in the scriptBox queue.
     *
     * @param scriptPath Path to the script file to read.
     */
    public void readScript(String scriptPath) {
        if (recursion_count++ >= recursion_depth) {
            outputManager.println("Некорректный ввод данных скрипта.");
            throw new InvalidInputException();
        }
        Main.script = true;
        File scriptFile = new File(scriptPath);
        Scanner scriptScanner = null;
        try {
            scriptScanner = new Scanner(scriptFile);
        } catch (FileNotFoundException e) {
            Main.script = false;
            System.out.println("Файл не найден");
        }
        if (scriptScanner != null) {
            while (scriptScanner.hasNextLine()) {
                String readLine = scriptScanner.nextLine();
                if (readLine.isEmpty()) {
                    outputManager.println("Некорректный ввод данных скрипта.");
                    throw new InvalidInputException();
                }
                //System.out.println(readLine);
                if (readLine.trim().contains(" ")) {
                    //scriptBox.add(readLine.split(" "));
                    scriptBox.add(readLine.trim().split(" "));
                    //System.out.println(Arrays.toString(readLine.split(" ")));
                } else {
                    scriptBox.add(new String[]{readLine, ""});
                }
            }
        }
    }

    /**
     * Retrieves the next line of input from the terminal.
     *
     * @return The next line of input as a string, or null if the end of the input stream is reached unexpectedly.
     * @throws NoSuchElementException if the end of the input stream is reached unexpectedly.
     */
    public String getNextLine() {
        try {
            Scanner scanners = new Scanner(inputStream);
            return scanners.nextLine();
        } catch (NoSuchElementException e) {
            outputManager.println("Строка по некой причине не была прочитана!");
            outputManager.println("Вероятно использовано сочетание Ctrl + D, которое приводит к завершению работы программы.");
            System.exit(1);
        }
        return null;
    }
}
