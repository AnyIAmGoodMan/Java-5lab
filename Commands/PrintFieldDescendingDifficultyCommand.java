package Commands;
import LabWorks.*;
import Managers.*;

import Managers.CollectionManager;

/**
 * Команда {@code print_field_descending_difficulty} выводит значения
 * сложности элементов коллекции в порядке убывания.
 *
 * <p>Список формируется в {@link CollectionManager#PFDD()}.</p>
 */
public class PrintFieldDescendingDifficultyCommand implements Command {

    private CollectionManager cm;

    public PrintFieldDescendingDifficultyCommand(CollectionManager cm) {
        this.cm = cm;
    }

    public String getName() {
        return "print_field_descending_difficulty";
    }

    public String getDescription() {
        return "Выводит значения difficulty всех элементов в порядке убывания";
    }

    /**
     * Выводит значения {@link Difficulty} в порядке убывания.
     *
     * <p>Если список пуст — выводит сообщение.</p>
     *
     * @param arg аргумент команды (игнорируется)
     */
    public void execute(String arg) {
        if (cm.PFDD().isEmpty()) {
            System.out.println("Подходящих значений нет\n");
            return;
        }

        for (Difficulty difficulty : cm.PFDD()) {
            System.out.println(difficulty);
        }

        System.out.println("\n");
    }
}
