package Commands;
import LabWorks.*;
import Managers.*;

import Managers.CollectionManager;

/**
 * Команда filter_contains_name.
 * Выводит элементы коллекции, имя которых содержит указанную подстроку.
 */

public class FilterContainsName implements Command {
    CollectionManager cm;
    public FilterContainsName(CollectionManager cm){
        this.cm = cm;
    }

    /**
     * @param arg аргумент команды - строка которая ищется в именах (не может быть null)
     */
    public void execute(String arg){

        if (arg == null) {
            System.out.println("Введите строку\n");
            return;
        }else {
            System.out.println(cm.filterInName(arg) + "\n");
        }
    }
    public String getName(){
        return "filter_contains_name";
    }
    public String getDescription(){
        return "Выводит все элементы, имя которых содержит подстроку";
    }
}
