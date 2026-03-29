package Managers;
import LabWorks.*;
import Commands.*;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Управляет выполнением команд.
 * Хранит список доступных команд и историю их выполнения.
 */

public class CommandManager {
    public ArrayDeque<String> history =  new ArrayDeque<String>();
    Map<String, Command> commands =  new HashMap<>();
    public void register(Command command) {
        commands.put(command.getName(), command);
    }
    public void execute(String line) {
        if (line == null || line.trim().isEmpty()) {
            System.out.println("Команда не найдена\n");
            return;
        }
        String[] args = line.trim().split("\\s+", 2);
        Command command = commands.get(args[0]);
        String argument = args.length > 1 ? args[1] : null;
        if (command == null) {
            System.out.println("Команда не найдена\n");
            return;
        }
        history.addLast(command.getName());
        if (history.size() > 14) {
            history.removeFirst();
        }
        try {
            command.execute(argument);
        }
        catch (Exception e) {
            System.out.println("Неправильный ввод команды\n");
        }
    }
    public Map<String, Command> getCommands() {
        return commands;
    }
}
