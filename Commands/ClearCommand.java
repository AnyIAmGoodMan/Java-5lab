package Commands;
import LabWorks.*;
import Managers.*;


/**
 * Команда {@code clear} очищает коллекцию {@link LabWork}.
 *
 * <p>Удаляет все элементы из коллекции, управляемой {@link CollectionManager}.</p>
 */

public class ClearCommand  implements Command {

    private CollectionManager cm;

    public ClearCommand(CollectionManager cm) {
        this.cm = cm;
    }

    /**
     * Выполняет команду.
     *
     * <p>Если коллекция пуста — выводит сообщение.
     * Иначе очищает коллекцию.</p>
     *
     * @param arg аргумент команды (должен быть {@code null})
     */
    public void execute(String arg) {

        if (cm.size() == 0){
            System.out.println("Коллекция пуста\n");
        }else {
            cm.clear();
            System.out.println("Коллекция очищена\n");
            cm.setModified(true);
        }
    }
    public String getName() {
        return "clear";
    }
    public String getDescription() {
        return "Очищает коллекцию";
    }
}
