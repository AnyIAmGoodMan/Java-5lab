import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Команда execute_script.
 * Выполняет команды, записанные в указанном файле.
 */

public class ExecuteScriptCommand implements Command {
    private static boolean scriptRunning = false;
    CommandManager cmm;

    public ExecuteScriptCommand(CommandManager cmm) {
        this.cmm = cmm;
    }

    public String getName() {
        return "execute_script";
    }

    public String getDescription() {
        return "Исполняет команды из xml файла";
    }

    public void execute(String arg) {

        if (scriptRunning){
            System.out.println("Скрипт уже выполняется");
            return;
        }

        if (arg == null) {
            System.out.println("Введите имя файла");
            return;
        }

        if (!arg.endsWith(".xml")) {
            System.out.println("Файл должен быть в формате xml");
            return;
        }

        File file = new File(arg);

        if (!file.exists()) {
            System.out.println("Файл не найден");
            return;
        }

        scriptRunning = true;

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String line = sc.nextLine().trim();

                if (line.equals("")) {
                    continue;
                }

                cmm.execute(line);
            }

            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка открытия файла");
        }

        scriptRunning = false;
    }
}
