import java.util.Scanner;
import java.util.Arrays;

/**
 * Команда добавления элемента в коллекцию.
 * Запрашивает данные у пользователя и создаёт объект LabWork.
 */

public class AddCommand implements Command {

    CollectionManager cm;

    public AddCommand(CollectionManager cm) {
        this.cm = cm;
    }

    public String getName() {
        return "add";
    }

    public String getDescription() {
        return "Добавляет новый элемент в коллекцию";
    }

    public void execute(String arg) {

        if (arg != null) {
            System.out.println("Команда не принимает аргументы");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите name:");
        String name = sc.nextLine();

        long x;
        while (true) {
            System.out.println("Введите coordinates.x:");
            try {
                x = Long.valueOf(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
            }
        }

        Float y;
        while (true) {
            System.out.println("Введите coordinates.y:");
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
            System.out.println("Введите minimalPoint (пустая строка = null):");
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

            System.out.println("Введите difficulty " + Arrays.toString(Difficulty.values()) + " (пустая строка = null):");
            String diffStr = sc.nextLine();

            if (diffStr.equals("")) break;

            try {
                difficulty = Difficulty.valueOf(diffStr);
                break;
            } catch (Exception e) {
                System.out.println("Неверное значение. Попробуйте снова.");
            }
        }

        System.out.println("Введите имя автора:");
        String authorName = sc.nextLine();

        Person author = null;

        if (!authorName.equals("")) {

            double height;
            while (true) {
                System.out.println("Введите height:");
                try {
                    height = Double.valueOf(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Ошибка ввода. Попробуйте снова.");
                }
            }

            System.out.println("Введите passportID:");
            String passportID = sc.nextLine();
            if (passportID.equals("")) passportID = null;

            Color hairColor = null;
            while (true) {

                System.out.println("Введите hairColor " + Arrays.toString(Color.values()) + " (пустая строка = null):");
                String hair = sc.nextLine();

                if (hair.equals("")) break;

                try {
                    hairColor = Color.valueOf(hair);
                    break;
                } catch (Exception e) {
                    System.out.println("Неверное значение. Попробуйте снова.");
                }
            }

            Integer lx;
            while (true) {
                System.out.println("Введите location.x:");
                try {
                    lx = Integer.valueOf(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Ошибка ввода. Попробуйте снова.");
                }
            }

            Float ly;
            while (true) {
                System.out.println("Введите location.y:");
                try {
                    ly = Float.valueOf(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Ошибка ввода. Попробуйте снова.");
                }
            }

            System.out.println("Введите location.name:");
            String lname = sc.nextLine();
            if (lname.equals("")) lname = null;

            Location location = new Location(lx, ly, lname);

            author = new Person(authorName, height, passportID, hairColor, location);
        }

        Long id = cm.generateId();

        LabWork labWork = new LabWork(id, name, coordinates, null, minimalPoint, difficulty, author);

        cm.add(labWork);

        System.out.println("Элемент добавлен");
    }
}
