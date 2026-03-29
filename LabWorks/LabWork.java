package LabWorks;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс элемента коллекции.
 * Представляет лабораторную работу с её характеристиками:
 * именем, координатами, сложностью, автором и другими полями.
 * Реализуется сортировка по minimalPoint.
 */

public class LabWork implements  Comparable<LabWork>{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long minimalPoint; //Поле может быть null, Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле может быть null
    private Person author; //Поле может быть null

    public Long getId(){return id;}
    public String getName(){return name;}
    public Coordinates getCoordinates(){return coordinates;}
    public java.time.ZonedDateTime getCreationDate(){return creationDate;}
    public Long getMinimalPoint(){return minimalPoint;}
    public Difficulty getDifficulty(){return difficulty;}
    public Person getAuthor(){return author;}

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Неправильный формат имени");
        }else{
            this.name = name;
    }}
    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null){
            throw new IllegalArgumentException("Неправильный формат координат");
        }else{
            this.coordinates = coordinates;
    }}
    public void setMinimalPoint(Long minimalPoint) {
        if (minimalPoint != null && minimalPoint <= 0){
            throw new IllegalArgumentException("Неправильный формат ввода минимального балла");
        }else{
            this.minimalPoint = minimalPoint;
    }}
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
    public void setAuthor(Person author) {
        this.author = author;
    }

    public int compareTo(LabWork lw) {
        if (this.minimalPoint == null && lw.getMinimalPoint() == null)
            return this.id.compareTo(lw.getId());
        if (this.minimalPoint == null) return -1;
        if (lw.getMinimalPoint() == null) return 1;
        int res = this.minimalPoint.compareTo(lw.getMinimalPoint());
        if (res == 0) {
            return this.id.compareTo(lw.getId());
        }
        return res;
    }

    public LabWork(Long id, String name, Coordinates coordinates, ZonedDateTime ZonedDateTime, Long minimalPoint, Difficulty difficulty, Person author) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.ZonedDateTime.now();
        this.minimalPoint = minimalPoint;
        this.difficulty = difficulty;
        this.author = author;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return "LabWork {" +
                "id = " + id +
                ", name = " + name +
                ", coordinates = (" + coordinates.getX() + ", " + coordinates.getY() + ")" +
                ", creationDate = " + creationDate.format(formatter) +
                ", minimalPoint = " + minimalPoint +
                ", difficulty = " + difficulty +
                ", author = " + (author == null ? "null" :
                ", name = " + author.getName() +
                        ", height = " + author.getHeight() +
                        ", passportID = " + author.getPassportID() +
                        ", hairColor = " + author.getHairColor() +
                        ", location = (" +
                        author.getLocation().getX() + ", " +
                        author.getLocation().getY() + ", " +
                        author.getLocation().getName() + ")"
        ) + "}";
    }
}
