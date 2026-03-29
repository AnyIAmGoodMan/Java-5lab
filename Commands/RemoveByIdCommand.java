package Commands;
import LabWorks.*;
import Managers.*;

import Managers.CollectionManager;

/**
 * Команда remove_by_id.
 * Удаляет элемент коллекции с указанным id.
 */

public class RemoveByIdCommand implements Command {

    CollectionManager cm;

    public RemoveByIdCommand(CollectionManager cm) {
        this.cm  = cm;
    }

    /**
     * @param arg аргумент команды - айди по которому идет удаление (не может быть null)
     */
    public void execute(String arg) {
        if (arg == null) {
            System.out.println("Введите id");
            return;
        }else {
            try {
                Long id = Long.valueOf(arg);
                System.out.println(cm.removeById(id));
            } catch (NumberFormatException e) {
                System.out.println("id должен быть числом");
            }
        }
    }
    public String getDescription() {
        return "Удаляет элемент по айди";
    }
    public String getName(){
        return "remove_by_id";
    }
}
