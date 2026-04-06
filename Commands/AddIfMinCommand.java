package Commands;
import LabWorks.*;
import Managers.*;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Команда {@code add_if_min} добавляет новый элемент {@link LabWork}
 * в коллекцию, если он меньше минимального элемента в коллекции.
 *
 * <p>Сравнение выполняется через {@link LabWork#compareTo(LabWork)}.</p>
 *
 * <p>Если коллекция пуста — элемент добавляется без сравнения.</p>
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

    /**
     * Выполняет команду.
     *
     * <p>Алгоритм:
     * <ol>
     *     <li>Проверяет, что аргументы отсутствуют</li>
     *     <li>Если коллекция пуста → вызывает {@link AddCommand}</li>
     *     <li>Иначе запрашивает данные нового элемента</li>
     *     <li>Находит минимальный элемент в коллекции</li>
     *     <li>Сравнивает новый элемент с минимальным</li>
     *     <li>Добавляет, если новый меньше</li>
     * </ol>
     *
     * @param arg аргумент команды (должен быть {@code null})
     */
    public void execute(String arg) {

        if (arg != null) {
            System.out.println("Команда не принимает аргументы\n");
            return;
        }

        if (cm.size() == 0) {
            System.out.println("Коллекция пуста, элемент добавлен\n");
            new AddCommand(cm).execute(null);
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

        Long id = cm.generateId();
        LabWork newLabWork = new LabWork(id, name, coordinates, null, minimalPoint, difficulty, author);
        LabWork min = null;

        for (LabWork lw : cm.getCollection()) {
            if (min == null || lw.compareTo(min) < 0) {
                min = lw;
            }
        }

        if (newLabWork.compareTo(min) < 0) {
            cm.add(newLabWork);
            System.out.println("Элемент добавлен\n");
            cm.setModified(true);
        } else {
            System.out.println("Элемент не меньше минимального\n");
        }
    }
}
