package Commands;
import LabWorks.*;
import Managers.*;

import Managers.CollectionManager;

/**
 * Команда remove_by_id.
 * Удаляет элемент коллекции с указанным id.
 */

public class RemoveHeadCommand implements Command {

    CollectionManager cm;

    /**
     * @param arg аргумент команды (должна быть null)
     */
    public void execute(String arg) {
        if (cm.size() == 0){
            System.out.println("Коллекция пуста\n");
        }else{
            System.out.println("Элемент " + cm.removeHead() + " удален\n");
        }
    }
    public RemoveHeadCommand(CollectionManager cm) {
        this.cm = cm;
    }
    public String getName() {
        return "remove_head";
    }
    public String getDescription() {
        return "Удаляет первый элемент коллекции";
    }
}
