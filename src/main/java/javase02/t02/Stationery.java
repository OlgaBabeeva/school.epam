package javase02.t02;

import java.util.Objects;

public abstract class Stationery {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stationery that = (Stationery) o;
        return Objects.equals(price, that.price) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return name + ": $" + price;
    }

    public Stationery(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Stationery(int price) {
        this.price = price;
        this.name = this.getClass().getSimpleName();
    }
}
