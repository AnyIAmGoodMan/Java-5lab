package Commands;
import LabWorks.*;
import Managers.*;

import Managers.CollectionManager;

/**
 * Команда {@code show} выводит все элементы коллекции {@link LabWork}.
 */
public class ShowCommand implements Command {

    CollectionManager manager;

    public String getName(){
        return "show";
    }

    public String getDescription(){
        return "Показывает все LabWork-и в коллекции";
    }

    /**
     * Выводит все элементы коллекции.
     *
     * <p>Перебирает коллекцию из {@link CollectionManager}
     * и выводит строковое представление каждого элемента.</p>
     *
     * @param arg аргумент команды (должен быть {@code null})
     */
    public void execute(String arg){
        for(LabWork labWork : manager.getCollection()){
            System.out.println(labWork.toString());
        }
        System.out.println("\n");
    }

    public ShowCommand(CollectionManager cm){
        this.manager = cm;
    }
}
