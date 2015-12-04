package javase02.t06;

import javase02.t07.ClassInfo;

@ClassInfo(date = "01 Dec 2015")
public class AtomicSubmarine {

    private AtomicSubmarineEngine engine;


    public AtomicSubmarine() {
        engine = new AtomicSubmarineEngine();
    }

    public void move() {
        engine.start();
    }

    class AtomicSubmarineEngine {
        public void start() {
            System.out.println("We all live in a yellow submarine");
        }
    }

    public static void main(String[] args) {
        AtomicSubmarine yellowSubmarine = new AtomicSubmarine();
        yellowSubmarine.move();
    }
}
