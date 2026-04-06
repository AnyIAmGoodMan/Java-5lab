package Managers;
import LabWorks.*;
import Commands.*;

import java.util.Scanner;

/**
 * Класс {@code Console} реализует консольный интерфейс взаимодействия с пользователем.
 *
 * <p>Считывает команды из стандартного ввода (stdin) и передаёт их
 * в {@link CommandManager} для выполнения.</p>
 *
 * <p>Работает в бесконечном цикле до принудительного завершения программы.</p>
 */

public class Console {
     /**
     * Текущая введённая строка команды.
     */
    private String line;

    /**
     * Сканер для чтения пользовательского ввода из консоли.
     */
    private Scanner sc = new Scanner(System.in);

    /**
     * Менеджер команд, отвечающий за выполнение пользовательских команд.
     */
    private CommandManager cmm;


    public Console(CommandManager cmm) {
        this.cmm = cmm;
    }

    /**
     * Запускает основной цикл консольного интерфейса.
     *
     * <p>Алгоритм работы:
     * <ol>
     *     <li>Вызывает команду {@code help} при старте</li>
     *     <li>Постоянно ожидает ввод пользователя</li>
     *     <li>Передаёт введённую строку в {@link CommandManager#execute(String)}</li>
     * </ol>
     *
     * <p>Особенности:
     * <ul>
     *     <li>Работает в бесконечном цикле</li>
     *     <li>Завершение возможно только извне (например, через команду exit)</li>
     * </ul>
     */
    public void run(){
        cmm.execute("help");
        while (true){
            System.out.print("Введите команду> ");
            line = sc.nextLine();
            cmm.execute(line);
        }
    }
}
