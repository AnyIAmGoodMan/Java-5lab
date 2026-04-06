package Commands;
import LabWorks.*;
import Managers.*;

import Managers.CollectionManager;

/**
 * Команда {@code remove_head} удаляет первый элемент коллекции.
 */
public class RemoveHeadCommand implements Command {

    CollectionManager cm;

    public RemoveHeadCommand(CollectionManager cm) {
        this.cm = cm;
    }

    /**
     * Удаляет и выводит первый элемент коллекции.
     *
     * <p>Если коллекция пуста — выводит сообщение.</p>
     *
     * @param arg аргумент команды (должен быть {@code null})
     */
    public void execute(String arg) {
        if (cm.size() == 0){
            System.out.println("Коллекция пуста\n");
        } else {
            System.out.println("Элемент " + cm.removeHead() + " удален\n");
            cm.setModified(true);
        }
    }

    public String getName() {
        return "remove_head";
    }

    public String getDescription() {
        return "Удаляет первый элемент коллекции";
    }
}
