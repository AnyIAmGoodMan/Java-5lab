package Commands;
import LabWorks.*;
import Managers.*;

import Managers.CollectionManager;

import java.util.Arrays;

/**
 * Команда count_by_difficulty.
 * Подсчитывает количество элементов коллекции с указанной сложностью.
 */

public class CountByDifficultyCommand implements Command {

    CollectionManager cm;

    public CountByDifficultyCommand(CollectionManager cm) {
        this.cm = cm;
    }

    public String getName() {
        return "count_by_difficulty";
    }

    public String getDescription() {
        return "Подсчитывает количество элементов в коллекции с данной сложностью";
    }

    /**
     * @param arg аргумент команды (не может быть null)
     */
    public void execute(String arg) {

        if (arg == null) {
            System.out.println("Введите difficulty"+ Arrays.toString(Difficulty.values()));
            return;
        }
        Difficulty difficulty;
        try {
            difficulty = Difficulty.valueOf(arg);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверное значение. Доступные: " + Arrays.toString(Difficulty.values()));
            return;
        }
        System.out.println(cm.countByDifficulty(difficulty));
    }
}
