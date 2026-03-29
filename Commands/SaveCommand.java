package Commands;
import LabWorks.*;
import Managers.*;

import Managers.XmlWriter;

/**
 * Команда save.
 * Сохраняет текущую коллекцию LabWork в XML файл.
 */

public class SaveCommand implements Command {
    XmlWriter xw;
    /**
     * @param arg аргумент команды - файл в который записываются LabWork-и (не может быть null)
     */
    public void execute(String arg) {
        if (arg == null){
            System.out.println("Пожалуйста введите название файла\n");
            return;
        }else {
            try {
                xw.write(arg);
                System.out.println("Запись произошла успешно\n");
            } catch (Exception e) {
                System.out.println("Ошибка записи файла\n");
            }
        }
    }
    public String getName(){
        return "save";
    }
    public String getDescription(){
        return "Записывает в указанный файл коллекцию";
    }
    public SaveCommand(XmlWriter xw) {
        this.xw = xw;
    }
}
