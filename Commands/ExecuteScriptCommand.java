package Commands;

import LabWorks.*;
import Managers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Команда {@code execute_script} выполняет команды,
 * записанные в указанном файле.
 *
 * <p>Считывает файл построчно и передаёт каждую строку
 * в {@link CommandManager} для выполнения.</p>
 *
 * <p>Поддерживает защиту от рекурсивного вызова скриптов
 * (когда один скрипт вызывает сам себя напрямую или через другие скрипты).</p>
 */
public class ExecuteScriptCommand implements Command {

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
     * Выполняет команды из файла.
     *
     * <p>Алгоритм работы:
     * <ol>
     *     <li>Проверяет наличие аргумента (имя файла)</li>
     *     <li>Проверяет существование файла и права доступа</li>
     *     <li>Проверяет, не выполняется ли файл уже (защита от рекурсии)</li>
     *     <li>Добавляет файл в список выполняемых скриптов</li>
     *     <li>Считывает файл построчно</li>
     *     <li>Каждую строку передаёт в {@link CommandManager#execute(String)}</li>
     *     <li>После выполнения удаляет файл из списка выполняемых</li>
     * </ol>
     *
     * <p>Особенности:
     * <ul>
     *     <li>Пустые строки игнорируются</li>
     *     <li>Используется {@link Scanner} для чтения файла</li>
     *     <li>Используется механизм {@link CommandManager} для предотвращения рекурсии</li>
     * </ul>
     *
     * @param arg аргумент команды — имя файла (не может быть {@code null})
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
