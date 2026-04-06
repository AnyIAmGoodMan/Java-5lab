package Commands;

import Managers.CommandManager;

/**
 * Команда {@code help} выводит список всех доступных команд.
 */
public class HelpCommand implements Command {

    CommandManager commandManager;

    public HelpCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public String getDescription() {
        return "Вывести список команд";
    }

    public String getName(){
        return "help";
    }

    /**
     * Выводит список зарегистрированных команд.
     *
     * <p>Проходит по всем командам в {@link CommandManager}
     * и выводит их имя и описание.</p>
     *
     * @param arg аргумент команды (должен быть {@code null})
     */
    public void execute(String arg) {

        System.out.println("Имеющиеся команды:");

        for (Command command : commandManager.getCommands().values()) {
            System.out.println(command.getName() + " : " + command.getDescription());
        }

        System.out.println();
    }
}
