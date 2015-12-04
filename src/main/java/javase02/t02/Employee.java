package javase02.t02;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private List<Stationery> stationeryList = new ArrayList<>();

    public Employee(String name) {
        this.name = name;
    }

    public List<Stationery> getStationeryList() {
        return stationeryList;

    }

    public void addStationary(Stationery stationery) {
        stationeryList.add(stationery);
    }

    public void removeStationary(Stationery stationery) {
        stationeryList.remove(stationery);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Stationery stationery : stationeryList) {
            sb.append(stationery);
            sb.append("\n");
        }
        return name + " has \n" + sb.toString();
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Stationery stationery : stationeryList) {
            totalPrice += stationery.getPrice();
        }
        return totalPrice;
    }

}
