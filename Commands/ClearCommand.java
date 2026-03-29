package Commands;
import LabWorks.*;
import Managers.*;

/**
 * Команда clear.
 * Очищает коллекцию.
 */

public class ClearCommand  implements Command {

    private CollectionManager cm;

    public ClearCommand(CollectionManager cm) {
        this.cm = cm;
    }

    /**
     * @param arg аргумент команды (должна быть null)
     */
    public void execute(String arg) {

        if (cm.size() == 0){
            System.out.println("Коллекция пуста\n");
        }else {
            cm.clear();
            System.out.println("Коллекция очищена\n");
        }
    }
    public String getName() {
        return "clear";
    }
    public String getDescription() {
        return "Очищает коллекцию";
    }
}
