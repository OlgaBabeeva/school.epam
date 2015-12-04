package javase02.t01;

import java.util.Objects;

public class Pen {
    private final int price;
    private final PenColor color;

    public Pen(int price, PenColor color) {

        this.price = price;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return Objects.equals(price, pen.price) &&
                Objects.equals(color, pen.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, color);
    }

    @Override
    public String toString() {
        return "Pen{" +
                "price=" + price +
                ", color=" + color +
                '}';
    }


    public static void main(String[] args) {
        System.out.println(new Pen(20, PenColor.BLUE));
    }

}
