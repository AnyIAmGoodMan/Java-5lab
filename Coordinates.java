/**
 * Класс координат.
 * Содержит значения x и y для объекта LabWork.
 */

public class Coordinates{
    private long x;
    private Float y;

    public long getX() {return x;}
    public Float getY() {return y;}

    public void setX(long x) {
        this.x = x;
    }
    public void setY(Float y) {
        if (y == null || y > 352){
            throw new IllegalArgumentException("Неверный формат координаты y");
        }else{
            this.y = y;
        }}
    protected Coordinates(long x, Float y) {
        this.x = x;
        this.y = y;
    }
}
