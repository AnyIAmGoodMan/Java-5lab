import java.util.Scanner;

/**
 * Класс консольного интерфейса программы.
 * Считывает команды пользователя и передаёт их CommandManager.
 */

public class Console {
    String line;
    Scanner sc = new Scanner(System.in);
    CommandManager cmm;
    public Console(CommandManager cmm) {
        this.cmm = cmm;
    }
    public void run(){
        while (true){
            System.out.println("Введите команду>");
            line = sc.nextLine();
            cmm.execute(line);
        }
    }
}
