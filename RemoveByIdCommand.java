/**
 * Команда remove_by_id.
 * Удаляет элемент коллекции с указанным id.
 */

public class RemoveByIdCommand implements Command {

    CollectionManager cm;

    public RemoveByIdCommand(CollectionManager cm) {
        this.cm  = cm;
    }

    public void execute(String arg) {
        if (arg == null) {
            System.out.println("Введите id");
            return;
        }else {
            System.out.println(cm.removeById(Long.valueOf(arg)));
        }
    }
    public String getDescription() {
        return "Удаляет элемент по айди";
    }
    public String getName(){
        return "remove_by_id";
    }
}
