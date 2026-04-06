package Commands;
import LabWorks.*;
import Managers.*;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Команда {@code update_id} обновляет элемент коллекции по указанному id.
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

    /**
     * Обновляет элемент коллекции.
     *
     * <p>Алгоритм:
     * <ol>
     *     <li>Проверяет корректность id</li>
     *     <li>Ищет элемент в коллекции</li>
     *     <li>Запрашивает новые значения полей</li>
     *     <li>Удаляет старый элемент</li>
     *     <li>Создаёт и добавляет новый</li>
     * </ol>
     *
     * <p>Если элемент с указанным id не найден — выводит сообщение.</p>
     *
     * @param arg id элемента (не может быть {@code null})
     */
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

        String name;

        while (true) {
            System.out.print("Введите name:");
            name = sc.nextLine();
            if (!name.trim().isEmpty()) {
                break;
            }
            System.out.println("Имя не может быть пустым");
        }

        long x;
        while (true) {
            System.out.print("Введите coordinates.x:");
            try {
                x = Long.valueOf(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ожидалось целое число (long)");
            }
        }

        Float y;
        while (true) {
            System.out.print("Введите coordinates.y (<= 352):");
            try {
                String input = sc.nextLine();
                BigDecimal bd = new BigDecimal(input);

                if (bd.compareTo(new BigDecimal("352")) > 0) {
                    System.out.println("y должно быть <= 352");
                    continue;
                }

                y = bd.floatValue();
                break;

            } catch (NumberFormatException e) {
                System.out.println("Ожидалось число (float), меньшее 353");
            }
        }

        Coordinates coordinates = new Coordinates(x, y);

        Long minimalPoint = null;
        while (true) {
            System.out.print("Введите minimalPoint (пустая строка = null):");
            String mp = sc.nextLine().trim();

            if (mp.equals("")) break;

            try {
                BigDecimal bd = new BigDecimal(mp);

                if (bd.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("minimalPoint должен быть больше 0");
                    continue;
                }

                minimalPoint = bd.longValue();
                break;

            } catch (NumberFormatException e) {
                System.out.println("Ожидалось целое число (Long), большее 0");
            }
        }

        Difficulty difficulty = null;
        while (true) {
            System.out.print("Введите difficulty " + Arrays.toString(Difficulty.values()) + " (пустая строка = null):");
            String diffStr = sc.nextLine();

            if (diffStr.equals("")) break;

            try {
                difficulty = Difficulty.valueOf(diffStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Неверное значение. Доступные: " + Arrays.toString(Difficulty.values()) + "или null");
            }
        }

        String authorName;
        Person author = null;
        while (true) {
            System.out.print("Введите имя автора (если строка пустая, то author = null):");
            authorName = sc.nextLine().trim();

            if (authorName.equals("")) {
                author = null;
                break;
            }

            if (authorName.isEmpty()) {
                System.out.println("Имя автора не может быть пустым");
                continue;
            }
            break;
        }

        if (!authorName.equals("")) {

            double height;
            while (true) {
                System.out.print("Введите height (> 0):");
                try {
                    String input = sc.nextLine();
                    BigDecimal bd = new BigDecimal(input);

                    if (bd.compareTo(BigDecimal.ZERO) <= 0) {
                        System.out.println("Рост должен быть большее 0");
                        continue;
                    }

                    height = bd.doubleValue();
                    break;

                } catch (NumberFormatException e) {
                    System.out.println("Ожидалось число (double)");
                }
            }

            String passportID;
            while (true) {
                System.out.print("Введите passportID (пустая строка = null):");
                passportID = sc.nextLine().trim();

                if (passportID.equals("")) {
                    passportID = null;
                    break;
                }

                if (passportID.length() < 10) {
                    System.out.println("passportID должен быть не менее 10 символов");
                    continue;
                }

                break;
            }

            Color hairColor = null;
            while (true) {
                System.out.print("Введите hairColor " + Arrays.toString(Color.values()) + " (пустая строка = null):");
                String hair = sc.nextLine().trim();

                if (hair.equals("")) break;

                try {
                    hairColor = Color.valueOf(hair);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Неверное значение. Доступные: " + Arrays.toString(Color.values()) + "или null");
                }
            }

            Integer lx;
            while (true) {
                System.out.print("Введите location.x:");
                try {
                    lx = Integer.valueOf(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ожидалось целое число (Integer)");
                }
            }

            Float ly;
            while (true) {
                System.out.print("Введите location.y:");
                try {
                    ly = Float.valueOf(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ожидалось число (Float)");
                }
            }

            String lname;
            while (true) {
                System.out.print("Введите location.name (пустая строка = null):");
                lname = sc.nextLine().trim();

                if (lname.equals("")) {
                    lname = null;
                    break;
                }

                if (lname.isEmpty()) {
                    System.out.println("Имя не может быть пустым");
                    continue;
                }
                break;
            }

            Location location = new Location(lx, ly, lname);
            author = new Person(authorName, height, passportID, hairColor, location);
        }

        LabWork labWork = new LabWork(id, name, coordinates, null, minimalPoint, difficulty, author);

        cm.removeById(id);
        cm.add(labWork);

        System.out.println("Элемент обновлен\n");
        cm.setModified(true);
    }
}
