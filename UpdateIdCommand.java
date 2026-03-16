import java.util.Scanner;
import java.util.Arrays;

/**
 * Команда update_id.
 * Обновляет элемент коллекции с указанным id, запрашивая новые значения его полей.
 */


public class UpdateIdCommand implements Command {

    CollectionManager cm;

    public UpdateIdCommand(CollectionManager cm) {
        this.cm = cm;
    }

    public String getName() {
        return "update_id";
    }

    public String getDescription() {
        return "Обновляет элемент коллекции по id";
    }

    public void execute(String arg) {

        if (arg == null) {
            System.out.println("Введите id");
            return;
        }

        Long id;

        try {
            id = Long.valueOf(arg);
        } catch (Exception e) {
            System.out.println("Неверный формат id");
            return;
        }

        boolean found = false;

        for (LabWork lw : cm.getCollection()) {
            if (lw.getId().equals(id)) {
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Элемента с таким id нет");
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
                System.out.println("Неверное значение difficulty");
            }
        }

        System.out.println("Введите author name:");
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

            if (passportID.equals("")) {
                passportID = null;
            }

            Color hairColor = null;

            while (true) {

                System.out.println("Введите hairColor " + Arrays.toString(Color.values()) + ":");
                String hair = sc.nextLine();

                if (hair.equals("")) break;

                try {
                    hairColor = Color.valueOf(hair);
                    break;
                } catch (Exception e) {
                    System.out.println("Неверное значение hairColor");
                }
            }

            Integer lx;

            while (true) {
                System.out.println("Введите location x:");
                try {
                    lx = Integer.valueOf(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Ошибка ввода. Попробуйте снова.");
                }
            }

            Float ly;

            while (true) {
                System.out.println("Введите location y:");
                try {
                    ly = Float.valueOf(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Ошибка ввода. Попробуйте снова.");
                }
            }

            System.out.println("Введите location name:");
            String lname = sc.nextLine();

            if (lname.equals("")) {
                lname = null;
            }

            Location location = new Location(lx, ly, lname);

            author = new Person(authorName, height, passportID, hairColor, location);
        }

        LabWork labWork = new LabWork(id, name, coordinates, null, minimalPoint, difficulty, author);

        cm.removeById(id);
        cm.add(labWork);

        System.out.println("Элемент обновлен");
    }
}
