package javase02.t03;

import javase02.t02.Employee;
import javase02.t03.stationary.*;

public class Newbie {
    public static void main(String[] args) {
        Employee newbie = new Employee("Newbie");
        newbie.addStationary(new HolePunch(50));
        newbie.addStationary(new Marker(33));
        newbie.addStationary(new Notebook(79));
        newbie.addStationary(new Pen(12));
        newbie.addStationary(new Pencil(10));
        newbie.addStationary(new Pencil(13));
        newbie.addStationary(new PostItNotes(67));
        newbie.addStationary(new Stapler(99));

        System.out.println(newbie);
    }

}
