package Commands;
import LabWorks.*;
import Managers.*;

import Managers.CollectionManager;

import java.time.format.DateTimeFormatter;

/**
 * Команда info.
 * Выводит информацию о коллекции: тип, дату создания
 * и количество элементов.
 */

public class InfoCommand implements Command {

    CollectionManager manager;

    public InfoCommand(CollectionManager cm) {
        this.manager = cm;
    }

    /**
     * @param arg аргумент команды (должна быть null)
     */
    public void execute(String arg){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        System.out.println("Тип коллекции - ArrayDeque\n" + "Время создания - " + manager.getTime().format(formatter) +"\n" + "Количество элементов в коллекции - " + manager.size() + "\n");
    }
    public String getName(){
        return "info";
    }
    public String getDescription() {
        return "Показывает тип коллекции, время ее создания и количество элементов в ней";
    }
}
