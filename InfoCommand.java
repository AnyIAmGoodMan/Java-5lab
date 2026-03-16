/**
 * Команда info.
 * Выводит информацию о коллекции: тип, дату создания
 * и количество элементов.
 */

public class InfoCommand implements Command {

    CollectionManager manager;

    public InfoCommand(CollectionManager cm) {
        this.manager = cm;
    }

    public void execute(String arg){
        System.out.println("Тип коллекции - ArrayDeque\n" + "Время создания - " + manager.getTime() +"\n" + "Количество элементов в коллекции - " + manager.size());
    }
    public String getName(){
        return "info";
    }
    public String getDescription() {
        return "Показывает тип коллекции, время ее создания и количество элементов в ней";
    }
}
