/**
 * Класс автора лабораторной работы.
 * Содержит информацию об имени, росте, паспорте,
 * цвете волос и местоположении.
 */

public class Person{
    private String name; //Поле не может быть null, Строка не может быть пустой
    private double height; //Значение поля должно быть больше 0
    private String passportID; //Длина строки должна быть не меньше 10, Строка не может быть пустой, Поле может быть null
    private Color hairColor; //Поле может быть null
    private Location location; //Поле не может быть null

    public String getName(){return name;}
    public double getHeight() {return height;}
    public String getPassportID() {return passportID;}
    public Color getHairColor() {return hairColor;}
    public Location getLocation() {return location;}

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Неправильный формат имени");
        }else{
            this.name = name;
    }}
    public void setHeight(double height) {
        if(height <= 0) {
            throw new IllegalArgumentException("Неправильный формат высоты");
        }else{
            this.height = height;
    }}
    public void setPassportID(String passportID) {
        if (passportID == null) {
            this.passportID = null;
        } else if (passportID.trim().isEmpty() || passportID.length() < 10) {
            throw new IllegalArgumentException("Неправильный формат паспортного айди");
        } else {
            this.passportID = passportID;
        }}
    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }
    public void setLocation(Location location) {
        if(location == null) {
            throw new IllegalArgumentException("Неправильный формат локации");
        }else {
            this.location = location;
        }}

    protected Person(String name, double height, String passportID, Color hairColor, Location location) {
        this.name = name;
        this.height = height;
        this.passportID = passportID;
        this.hairColor = hairColor;
        this.location = location;
    }
}
