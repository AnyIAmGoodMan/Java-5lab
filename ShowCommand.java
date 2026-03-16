/**
 * Команда show.
 * Выводит все элементы коллекции LabWork.
 */

public class ShowCommand implements Command{

    CollectionManager manager;
    
    public String getName(){
        return "show";
    }
    public String getDescription(){
        return "Показывает все LabWork-и в коллекции";
    }
    public void execute(String arg){
        for(LabWork labWork : manager.getCollection()){
            System.out.println(labWork.toString());
        }
    }
    public ShowCommand(CollectionManager cm){
        this.manager = cm;
    }
}
