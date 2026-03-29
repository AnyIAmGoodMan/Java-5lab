package Commands;
import LabWorks.*;
import Managers.*;

/**
 * Команда history.
 * Показывает последние выполненные команды.
 */

public class HistoryCommand implements Command {

    private CommandManager cmm;

    public HistoryCommand(CommandManager cmm) {
        this.cmm = cmm;
    }

    public String getName() {
        return "history";
    }

    public String getDescription() {
        return "Выводит последние 14 команд";
    }

    /**
     * @param arg аргумент команды (должна быть null)
     */
    public void execute(String arg) {

        if (cmm.history.isEmpty()) {
            System.out.println("История пуста\n");
            return;
        }

        for (String commandName : cmm.history) {
            System.out.println(commandName);
        }
        System.out.println("\n");
    }
}
