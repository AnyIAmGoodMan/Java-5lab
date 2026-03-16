import java.util.Scanner;
import java.util.Arrays;

/**
 * Команда добавления элемента в коллекцию, если его элемент, по которому сортируется коллекция меньше минимального.
 * Запрашивает данные у пользователя и создаёт объект LabWork, если элемент меньше минимального в коллекции.
 */

public class AddIfMinCommand implements Command {

    CollectionManager cm;

    public AddIfMinCommand(CollectionManager cm) {
        this.cm = cm;
    }

    public String getName() {
        return "add_if_min";
    }

    public String getDescription() {
        return "Добавляет элемент, если он меньше минимального в коллекции";
    }

    public void execute(String arg) {

        if (arg != null) {
            System.out.println("Команда не принимает аргументы");
            return;
        }

        if (cm.size() == 0) {
            System.out.println("Коллекция пуста, элемент добавлен");
            new AddCommand(cm).execute(null);
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите name:");
        String name = sc.nextLine();

        long x;
        while (true) {
            System.out.println("Введите x:");
            try {
                x = Long.valueOf(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
            }
        }

        Float y;
        while (true) {
            System.out.println("Введите y:");
            try {
                y = Float.valueOf(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
            }
        }

        Coordinates coordinates = new Coordinates(x, y);

        Long minimalPoint = null;
        while (true) {
            System.out.println("Введите minimalPoint:");
            String mp = sc.nextLine();

            if (mp.equals("")) break;

            try {
                minimalPoint = Long.valueOf(mp);
                break;
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
            }
        }

        Difficulty difficulty = null;

        while (true) {

            System.out.println("Введите difficulty " + Arrays.toString(Difficulty.values()) + ":");
            String diffStr = sc.nextLine();

            if (diffStr.equals("")) break;

            try {
                difficulty = Difficulty.valueOf(diffStr);
                break;
            } catch (Exception e) {
                System.out.println("Неверное значение. Попробуйте снова.");
            }
        }

        Long id = cm.generateId();

        LabWork newLabWork = new LabWork(id, name, coordinates, null, minimalPoint, difficulty, null);

        LabWork min = null;

        for (LabWork lw : cm.getCollection()) {
            if (min == null || lw.compareTo(min) < 0) {
                min = lw;
            }
        }

        if (newLabWork.compareTo(min) < 0) {
            cm.add(newLabWork);
            System.out.println("Элемент добавлен");
        } else {
            System.out.println("Элемент не меньше минимального");
        }
    }
}
