package Commands;
import LabWorks.*;
import Managers.*;

import Managers.CollectionManager;

/**
 * Команда print_field_descending_difficulty.
 * Выводит значения сложности элементов коллекции
 * в порядке убывания.
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
     * @param arg аргумент команды - искомая сложность (не может быть null)
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
