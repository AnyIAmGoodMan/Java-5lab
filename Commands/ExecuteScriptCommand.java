package Commands;
import LabWorks.*;
import Managers.*;

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

    /**
     * @param arg аргумент команды - файл с исполняемыми командами (не может быть null)
     */
    public void execute(String arg) {

        if (scriptRunning){
            System.out.println("Скрипт уже выполняется\n");
            return;
        }

        if (arg == null) {
            System.out.println("Введите имя файла");
            return;
        }

        if (!arg.endsWith(".xml")) {
            System.out.println("Файл должен быть в формате xml\n");
            return;
        }

        File file = new File(arg);

        if (!file.canRead()) {
            System.out.println("Нет прав на чтение файла");
            return;
        }

        if (!file.exists()) {
            System.out.println("Файл не найден\n");
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
            System.out.println("Ошибка открытия файла\n");
        }
        finally {
            scriptRunning = false;
        }
    }
}
