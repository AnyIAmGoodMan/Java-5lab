import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Управляет выполнением команд.
 * Хранит список доступных команд и историю их выполнения.
 */

public class CommandManager {
    ArrayDeque<String> history =  new ArrayDeque<String>();
    Map<String, Command> commands =  new HashMap<>();
    public void register(Command command) {
        commands.put(command.getName(), command);
    }
    public void execute(String line) {
        if (line == null || line.trim().isEmpty()) {
            System.out.println("Команда не найдена");
            return;
        }
        String[] args = line.split("\\s+");
        Command command = commands.get(args[0]);
        String argument = args.length >= 2 ? args[1] : null;
        if (command == null) {
            System.out.println("Команда не найдена");
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
            System.out.println("Неправильный ввод команды");
        }
    }
}
