package javase02.t04;

import javase02.t02.Employee;
import javase02.t02.Stationery;
import javase02.t03.stationary.*;

import java.util.Comparator;
import java.util.List;

public class NewbieSort {

    public static void main(String[] args) {
        Employee newbie = new Employee("Newbie");
        newbie.addStationary(new PostItNotes(67));
        newbie.addStationary(new Pencil(13));
        newbie.addStationary(new Notebook(50));
        newbie.addStationary(new HolePunch(50));
        newbie.addStationary(new Pen(12));
        newbie.addStationary(new Pencil(4));
        newbie.addStationary(new Stapler(99));
        newbie.addStationary(new Pencil(50));
        newbie.addStationary(new Marker(33));

        System.out.println(newbie);

        List<Stationery> newbieKit = newbie.getStationeryList();

        Comparator<Stationery> byName =
                (Stationery o1, Stationery o2) -> o1.getName().compareTo(o2.getName());
        newbieKit.sort(byName);
        System.out.println(newbie);

        Comparator<Stationery> byPrice =
                (Stationery o1, Stationery o2) -> Integer.compare(o1.getPrice(), o2.getPrice());
        newbieKit.sort(byPrice);
        System.out.println(newbie);

        newbieKit.stream().sorted(byPrice.thenComparing(byName))
                .forEach(System.out::println);
    }

}
