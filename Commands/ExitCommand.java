package Commands;

import LabWorks.*;
import Managers.*;

import java.util.Scanner;

/**
 * Команда {@code exit} завершает выполнение программы.
 */
public class ExitCommand implements Command {

    CollectionManager cm;

    public ExitCommand(CollectionManager cm) {
        this.cm = cm;
    }
    /**
     * Завершает программу.
     *
     * <p>Использует {@link System#exit(int)} для немедленного завершения JVM.</p>
     *
     * @param arg аргумент команды (игнорируется)
     */
    public void execute(String arg){
        if (cm.getModified()) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Коллекция изменена. Выйти без сохранения? (y/n): ");

            String answer = sc.nextLine();

            if (!answer.equalsIgnoreCase("y")) {
                System.out.println("Выход отменен");
                return;
            }
        }

        System.exit(0);
    }

    public String getName(){
        return "exit";
    }

    public String getDescription() {
        return "Закрывает программу";
    }
}
