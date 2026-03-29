package Commands;
import LabWorks.*;
import Managers.*;

import Managers.CollectionManager;

/**
 * Команда show.
 * Выводит все элементы коллекции LabWork
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
     * @param arg аргумент команды (должна быть null)
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
