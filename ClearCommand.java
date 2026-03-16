/**
 * Команда очистки коллекции.
 */

public class ClearCommand  implements Command {

    private CollectionManager cm;

    public ClearCommand(CollectionManager cm) {
        this.cm = cm;
    }
    public void execute(String arg) {
        if (cm.size() == 0){
            System.out.println("Коллекция пуста");
        }else {
            cm.clear();
            System.out.println("Коллекция очищена");
        }
    }
    public String getName() {
        return "clear";
    }
    public String getDescription() {
        return "Очищает коллекцию";
    }
}
