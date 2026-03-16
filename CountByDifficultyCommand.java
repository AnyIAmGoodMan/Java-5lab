import java.util.Collection;

/**
 * Команда count_by_difficulty.
 * Подсчитывает количество элементов коллекции с указанной сложностью.
 */

public class CountByDifficultyCommand implements Command{

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

    public void execute(String arg) {
        if (arg == null) {
            System.out.println("Введите difficulty"+ java.util.Arrays.toString(Difficulty.values()) + ":");
            return;
        }
        Difficulty difficulty;
        try {
            difficulty = Difficulty.valueOf(arg);
        } catch (IllegalArgumentException e) {
            System.out.println("Такой сложности не существует");
            return;
        }
        System.out.println(cm.countByDifficulty(difficulty));
    }
}
