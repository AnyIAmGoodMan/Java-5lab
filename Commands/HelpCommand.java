package Commands;


import Managers.CommandManager;

/**
 * Команда help.
 * Выводит список доступных команд программы.
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

    public void execute(String arg) {
        /**
         * @param arg аргумент команды (должна быть null)
         */
        System.out.println("Имеющиеся команды:");
        for (Command command : commandManager.getCommands().values()) {
            System.out.println(command.getName() + " : " + command.getDescription());
        }
        System.out.println();
    }

                /* "\n"+
                "[Дополнительно]\n"+
                "String name - Не может быть null, Строка не может быть пустой\n" +
                "Long minimalPoint - Может быть null, Значение поля должно быть больше 0\n" +
                "Difficulty difficulty - Может быть null\n" +
                "long x(coordinates)\n" +
                "Float y(coordinates) - Максимальное значение: 352, не может быть null\n"+
                "String name(author) - Не может быть null, не может быть пустой\n" +
                "double height(author) - Значение должно быть больше 0\n" +
                "String passportID(author) - Длина должна быть не меньше 10, не может быть пустой, может быть null\n" +
                "Color hairColor(author) - Может быть null\n" +
                "Location location(author) - Не может быть null\n"+
                "Integer x(Location) - Не может быть null\n" +
                "Float y(Location) - Не может быть null\n" +
                "String name(Location) - Не может быть пустой, может быть null\n"
                 */
}
