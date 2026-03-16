/**
 * Команда help.
 * Выводит список доступных команд программы.
 */

public class HelpCommand implements Command {
    public String getDescription() {
        return "Вывести список команд";
    }
    public String getName(){
        return "help";
    }

    public void execute(String arg) {
        System.out.println("help : вывести справку\n" +
                        "info : информация о коллекции\n" +
                        "show : вывести элементы коллекции\n" +
                        "add : добавить элемент\n" +
                        "update_id id : обновить элемент\n" +
                        "remove_by_id id : удалить элемент\n" +
                        "clear : очистить коллекцию\n" +
                        "save file : сохранить коллекцию\n" +
                        "execute_script file : выполнить команды из файла\n" +
                        "exit : завершить программу\n" +
                        "remove_head : удалить первый элемент\n" +
                        "add_if_min : добавить если минимальный\n" +
                        "history : последние 14 команд\n" +
                        "count_by_difficulty difficulty : подсчёт\n" +
                        "filter_contains_name name : фильтр\n" +
                        "print_field_descending_difficulty : вывести difficulty"
        );
    }
}
