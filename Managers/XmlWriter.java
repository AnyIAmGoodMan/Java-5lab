package Managers;
import LabWorks.*;
import Commands.*;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс записи XML.
 * Сохраняет элементы коллекции LabWork в файл XML.
 */

public class XmlWriter {
    CollectionManager manager;

    public XmlWriter(CollectionManager manager) {
        this.manager = manager;
    }

    public void write(String fileName) {

        try {
            FileWriter writer = new FileWriter(fileName, false);

            writer.write("<LabWork>\n");

            for (LabWork labWork : manager.getCollection()) {

                writer.write("<LabWork>\n");

                writer.write("<name>" + labWork.getName() + "</name>\n");

                if (labWork.getMinimalPoint() != null) {
                    writer.write("<minimalPoint>" + labWork.getMinimalPoint() + "</minimalPoint>\n");
                }

                if (labWork.getDifficulty() != null) {
                    writer.write("<difficulty>" + labWork.getDifficulty() + "</difficulty>\n");
                }

                writer.write("<coordinates>\n");
                writer.write("<x>" + labWork.getCoordinates().getX() + "</x>\n");
                writer.write("<y>" + labWork.getCoordinates().getY() + "</y>\n");
                writer.write("</coordinates>\n");

                if (labWork.getAuthor() != null) {

                    writer.write("<author>\n");

                    writer.write("<name>" + labWork.getAuthor().getName() + "</name>\n");
                    writer.write("<height>" + labWork.getAuthor().getHeight() + "</height>\n");

                    if (labWork.getAuthor().getPassportID() != null) {
                        writer.write("<passportID>" + labWork.getAuthor().getPassportID() + "</passportID>\n");
                    }

                    if (labWork.getAuthor().getHairColor() != null) {
                        writer.write("<hairColor>" + labWork.getAuthor().getHairColor() + "</hairColor>\n");
                    }

                    writer.write("<location>\n");
                    writer.write("<x>" + labWork.getAuthor().getLocation().getX() + "</x>\n");
                    writer.write("<y>" + labWork.getAuthor().getLocation().getY() + "</y>\n");

                    if (labWork.getAuthor().getLocation().getName() != null) {
                        writer.write("<name>" + labWork.getAuthor().getLocation().getName() + "</name>\n");
                    }

                    writer.write("</location>\n");

                    writer.write("</author>\n");
                }

                writer.write("</LabWork>\n");
            }

            writer.write("</LabWork>\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Ошибка записи в файл\n");
        }
    }
}
