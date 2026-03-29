package LabWorks;

/**
 * Класс местоположения.
 * Используется для хранения координат и названия места.
 */

public class Location {
    private Integer x; //Поле не может быть null
    private Float y; //Поле не может быть null
    private String name; //Строка не может быть пустой, Поле может быть null

    public Integer getX() {return x;}
    public Float getY() {return y;}
    public String getName() {return name;}

    public void setX(Integer x) {
        if (x == null){
            throw new IllegalArgumentException("Неправильный формат координаты x");
        }else{
            this.x = x;
    }}
    public void setY(Float y) {
        if(y == null){
            throw new IllegalArgumentException("Неправильный формат координаты y");
        }else{
            this.y = y;
    }}
    public void setName(String name) {
        if (name != null && name.trim().isEmpty()){
            throw new IllegalArgumentException("Неправильный формат имени");
        }else{
            this.name = name;
    }}

    public Location(Integer x, Float y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
}
