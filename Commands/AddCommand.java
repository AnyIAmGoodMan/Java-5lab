package Commands;
import LabWorks.*;
import Managers.*;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Команда add.
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


    /**
     @param arg аргумент команды (должна быть null)
     */
    public void execute(String arg) {

        if (arg != null) {
            System.out.println("Команда не принимает аргументы");
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
            System.out.print("Введите coordinates.y:");
            try {
                y = Float.valueOf(sc.nextLine());
                if (y > 352) {
                    System.out.println("y должно быть <= 352");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ожидалось число (float), меньшее 353");
            }
        }

        Coordinates coordinates = new Coordinates(x, y);

        Long minimalPoint = null;
        while (true) {
            System.out.print("Введите minimalPoint (пустая строка = null):");
            String mp = sc.nextLine();

            if (mp.equals("")) break;

            try {
                minimalPoint = Long.valueOf(mp);
                if (minimalPoint <= 0) {
                    System.out.println("minimalPoint должен быть больше 0");
                    continue;
                }
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
                System.out.print("Введите height:");
                try {
                    height = Double.valueOf(sc.nextLine());
                    if (height <= 0) {
                        System.out.println("Рост должен быть большее 0");
                        continue;
                    }
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
        LabWork labWork = new LabWork(id, name, coordinates, null, minimalPoint, difficulty, author);
        cm.add(labWork);
        System.out.println("Элемент добавлен");
    }
}
