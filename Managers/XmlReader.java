package Managers;
import LabWorks.*;
import Commands.*;


import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.io.File;

/**
 * Класс чтения XML файла.
 * Загружает элементы LabWork из файла и добавляет их в коллекцию.
 */

public class XmlReader {
    boolean inCoordinates;
    boolean inPerson;
    boolean inLocation;
    LabWork lw = null;
    Long id = Long.valueOf(0);
    public void read(String fileName, CollectionManager cm) {
        File file = new File(fileName);
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Файл не найден\n");
        }
        while (sc.hasNextLine()) {

            String line = sc.nextLine().trim();
            if (!line.contains("<")) continue;
            String value = line.replaceAll("<.*?>", "");
            String tag = line.substring(line.indexOf("<")+1, line.indexOf(">"));

            if (tag.equals("LabWork")){
                id += 1; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
                ZonedDateTime creationDate = ZonedDateTime.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
                lw = new LabWork(id, "default", new Coordinates(1, 1f), creationDate, 1L, null, null);
                }

            if (tag.equals("name") && !inLocation && !inPerson){lw.setName(value);}
            if (tag.equals("minimalPoint")){lw.setMinimalPoint(Long.valueOf(value));}
            if (tag.equals("difficulty")){lw.setDifficulty(Difficulty.valueOf(value));}

            if (tag.equals("coordinates")){
                inCoordinates = true;
                Coordinates coordinates = new Coordinates(1, 1f);
                lw.setCoordinates(coordinates);
            }
            if (tag.equals("/coordinates")){inCoordinates = false;}

            if (tag.equals("x") && inCoordinates){lw.getCoordinates().setX(Long.valueOf(value));}
            if (tag.equals("y")  && inCoordinates){lw.getCoordinates().setY(Float.valueOf(value));}

            if (tag.equals("author")){
                inPerson = true;
                Person author = new Person("Unknown", 1.0, null, null, new Location(0, 0f, "Unknown"));
                lw.setAuthor(author);
            }
            if (tag.equals("/author")){inPerson = false;}

            if (tag.equals("name") && !inLocation && inPerson){lw.getAuthor().setName(value);}
            if (tag.equals("hairColor")){lw.getAuthor().setHairColor(Color.valueOf(value));}
            if (tag.equals("height")){lw.getAuthor().setHeight(Double.valueOf(value));}
            if (tag.equals("passportID")){lw.getAuthor().setPassportID(value);}

            if (tag.equals("location")){
                inLocation = true;
                Location location = new Location(0, 0f, "Unknown");
                lw.getAuthor().setLocation(location);
            }
            if  (tag.equals("/location")){inLocation = false;}

            if (tag.equals("x") && inLocation){lw.getAuthor().getLocation().setX(Integer.valueOf(value));}
            if (tag.equals("y")  && inLocation){lw.getAuthor().getLocation().setY(Float.valueOf(value));}
            if (tag.equals("name") && inLocation){lw.getAuthor().getLocation().setName(value);}

            if (tag.equals("/LabWork")){
                cm.add(lw);
                cm.updateNextId(lw.getId());
                lw = null;
                inPerson = false;
                inLocation = false;
                inCoordinates = false;
            }
        }

        sc.close();
    }
}
