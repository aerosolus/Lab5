package org.example.contoller.commands;

import org.example.Main;
import org.example.contoller.Command;
import java.util.ArrayList;

/**
 * Represents a command to display help information about available commands.
 * Implements the Command interface to handle the "help" command.
 *
 * @author Aerosolus
 * @version 1.0
 *
 * @see Main
 * @see org.example.contoller.Command
 */
public class HelpCommand implements Command {

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести справку по доступным командам";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "help ";
    }

    /**
     * Executes the help operation, displaying a list of available commands.
     */
    @Override
    public void execute() {

        ArrayList<String> help_out = new ArrayList<>();
        help_out.add("   help : вывести справку по доступным командам");
        help_out.add("   info : вывести в стандартный поток вывода информацию о коллекции");
        help_out.add("   show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        help_out.add("   insert : добавить новый элемент с заданным ключом");
        help_out.add("   update : обновить значение элемента коллекции, id которого равен заданному");
        help_out.add("   remove_key : удалить элемент из коллекции по его ключу");
        help_out.add("   clear : очистить коллекцию");
        help_out.add("   save : сохранить коллекцию в файл");
        help_out.add("   execute_script : считать и исполнить скрипт из указанного файла");
        help_out.add("   exit : завершить программу (без сохранения в файл)");
        help_out.add("   remove_lower : удалить из коллекции все элементы, меньшие, чем заданный");
        help_out.add("   remove_greater_key : удалить из коллекции все элементы, ключ которых превышает заданный");
        help_out.add("   remove_lower_key : удалить из коллекции все элементы, ключ которых меньше, чем заданный");
        help_out.add("   print_ascending : вывести элементы коллекции в порядке возрастания");
        help_out.add("   print_descending : вывести элементы коллекции в порядке убывания");
        help_out.add("   print_field_descending_car : вывести значения поля car всех элементов в порядке убывания");
        String output = "";
        output += "Список доступных команд:\n";
        for (String comhelp : help_out) {
            output += "   " + comhelp + "\n";
        }
        Main.terminalOutputManager.println(output);
    }
}
