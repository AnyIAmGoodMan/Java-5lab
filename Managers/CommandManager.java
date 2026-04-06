package Managers;
import LabWorks.*;
import Commands.*;

import java.util.*;

/**
 * Класс {@code CommandManager} управляет регистрацией и выполнением команд.
 *
 * <p>Реализует паттерн "Команда" (Command pattern):
 * каждая команда представлена объектом, реализующим интерфейс {@link Command}.</p>
 *
 * <p>Функциональность:
 * <ul>
 *     <li>Хранение доступных команд</li>
 *     <li>Выполнение команд по имени</li>
 *     <li>Хранение истории последних выполненных команд (до 14)</li>
 *     <li>Контроль выполнения скриптов (для предотвращения рекурсии)</li>
 * </ul>
 */

public class CommandManager {
    /**
     * История выполненных команд (хранит только имена).
     * Максимальный размер — 14 элементов.
     */
    public ArrayDeque<String> history = new ArrayDeque<>();

    /**
     * Словарь зарегистрированных команд:
     * ключ — имя команды, значение — объект команды.
     */
    private Map<String, Command> commands = new HashMap<>();

    /**
     * Множество выполняемых скриптов.
     * Используется для предотвращения зацикливания (execute_script).
     */
    private Set<String> executingScripts = new HashSet<>();

    /**
     * Проверяет, выполняется ли в данный момент указанный скрипт.
     *
     * @param fileName имя файла скрипта
     * @return {@code true}, если скрипт уже выполняется, иначе {@code false}
     */
    public boolean isExecuting(String fileName) {
        return executingScripts.contains(fileName);
    }

    /**
     * Помечает скрипт как выполняемый.
     *
     * @param fileName имя файла скрипта
     */
    public void startScript(String fileName) {
        executingScripts.add(fileName);
    }

    /**
     * Удаляет скрипт из списка выполняемых.
     *
     * @param fileName имя файла скрипта
     */
    public void endScript(String fileName) {
        executingScripts.remove(fileName);
    }

    /**
     * Регистрирует новую команду.
     *
     * <p>Команда добавляется в словарь и становится доступной для вызова по имени.</p>
     *
     * @param command объект команды (не должен быть {@code null})
     */
    public void register(Command command) {
        commands.put(command.getName(), command);
    }

    /**
     * Выполняет команду, введённую пользователем.
     *
     * <p>Алгоритм:
     * <ol>
     *     <li>Проверяет корректность строки</li>
     *     <li>Разделяет строку на имя команды и аргумент</li>
     *     <li>Ищет команду в словаре</li>
     *     <li>Добавляет команду в историю</li>
     *     <li>Вызывает {@link Command#execute(String)}</li>
     * </ol>
     *
     * <p>Особенности:
     * <ul>
     *     <li>История ограничена 14 последними командами</li>
     *     <li>Аргумент может отсутствовать ({@code null})</li>
     *     <li>Ошибки выполнения команды перехватываются</li>
     * </ul>
     *
     * <p>Ошибки:
     * <ul>
     *     <li>Если команда не найдена — выводится сообщение</li>
     *     <li>Если произошла ошибка при выполнении — выводится сообщение об ошибке</li>
     * </ul>
     *
     * @param line строка, введённая пользователем
     */
    public void execute(String line) {
        if (line == null || line.trim().isEmpty()) {
            System.out.println("Команда не найдена\n");
            return;
        }
        String[] args = line.trim().split("\\s+", 2);
        Command command = commands.get(args[0]);
        String argument = args.length > 1 ? args[1] : null;
        if (command == null) {
            System.out.println("Команда не найдена\n");
            return;
        }
        history.addLast(command.getName());
        if (history.size() > 14) {
            history.removeFirst();
        }
        try {
            command.execute(argument);
        }
        catch (Exception e) {
            System.out.println("Неправильный ввод команды\n");
        }
    }
    public Map<String, Command> getCommands() {
        return commands;
    }
}
