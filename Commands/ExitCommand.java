package Commands;
import LabWorks.*;
import Managers.*;

/**
 * Команда exit.
 * Завершает выполнение программы.
 */

public class ExitCommand implements Command {
    public void execute(String arg){
        System.exit(0);
    }
    public String getName(){
        return "exit";
    }
    public String getDescription() {
        return "Закрывает программу";
    }
}
