public class PrintFieldDescendingDifficultyCommand implements Command {

    /**
     * Команда print_field_descending_difficulty.
     * Выводит значения сложности элементов коллекции
     * в порядке убывания.
     */

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

    public void execute(String arg) {
        if (cm.PFDD().isEmpty()) {
            System.out.println("Подходящих значений нет");
            return;
        }

        for (Difficulty difficulty : cm.PFDD()) {
            System.out.println(difficulty);
        }
    }
}
