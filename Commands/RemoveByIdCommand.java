package Commands;
import LabWorks.*;
import Managers.*;

import Managers.CollectionManager;

/**
 * Команда {@code remove_by_id} удаляет элемент коллекции
 * по заданному идентификатору.
 */
public class RemoveByIdCommand implements Command {

    CollectionManager cm;

    public RemoveByIdCommand(CollectionManager cm) {
        this.cm  = cm;
    }

    /**
     * Выполняет удаление элемента по id.
     *
     * <p>Преобразует аргумент в {@link Long} и вызывает
     * {@link CollectionManager#removeById(long)}.</p>
     *
     * <p>Если аргумент отсутствует или некорректен — выводит сообщение.</p>
     *
     * @param arg строковое представление id (не может быть {@code null})
     */
    public void execute(String arg) {
        if (arg == null) {
            System.out.println("Введите id");
            return;
        } else {
            try {
                Long id = Long.valueOf(arg);
                System.out.println(cm.removeById(id));
                cm.setModified(true);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат id (слишком большое или некорректное число)");
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
