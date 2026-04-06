package Commands;
import LabWorks.*;
import Managers.*;

import Managers.XmlWriter;

/**
 * Команда {@code save} сохраняет текущую коллекцию в XML файл.
 */
public class SaveCommand implements Command {

    XmlWriter xw;
    CollectionManager cm;

    public SaveCommand(XmlWriter xw, CollectionManager cm) {
        this.xw = xw;
        this.cm = cm;
    }

    /**
     * Выполняет сохранение коллекции.
     *
     * <p>Проверяет отсутствие аргументов и вызывает {@link XmlWriter#write()}.</p>
     *
     * <p>В случае ошибки выводит сообщение.</p>
     *
     * @param arg аргумент команды (должен быть {@code null})
     */
    public void execute(String arg) {
        if (arg != null && !arg.isEmpty()) {
            System.out.println("Команда save не принимает аргументы");
            return;
        }

        try {
            xw.write();
            System.out.println("Коллекция сохранена");
            cm.setModified(false);
        } catch (Exception e) {
            System.out.println("Коллекция не сохранена: " + e.getMessage());
        }
    }

    public String getName(){
        return "save";
    }

    public String getDescription(){
        return "Записывает в указанный файл коллекцию";
    }
}
