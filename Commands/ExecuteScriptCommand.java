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

        if (arg == null) {
            System.out.println("Введите имя файла");
            return;
        }

        File file = new File(arg);

        if (!file.exists()) {
            System.out.println("Файл не найден");
            return;
        }

        if (!file.canRead()) {
            System.out.println("Нет прав на чтение файла");
            return;
        }

        String path = file.getAbsolutePath();
        
        if (cmm.isExecuting(path)) {
            System.out.println("Обнаружена рекурсия! Скрипт уже выполняется.");
            return;
        }

        cmm.startScript(path);

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();

                if (line.isEmpty()) continue;

                cmm.execute(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка открытия файла");
        } finally {
            cmm.endScript(path);
        }
    }
}
