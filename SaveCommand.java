/**
 * Команда save.
 * Сохраняет текущую коллекцию LabWork в XML файл.
 */

public class SaveCommand implements Command {
    XmlWriter xw;
    public void execute(String arg) {
        if (arg == null){
            System.out.println("Пожалуйста введите название файла");
            return;
        }else {
            xw.write(arg);
            System.out.println("Запись произошла успешно");
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
