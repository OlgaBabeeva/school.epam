package javase04.t04;

import java.io.Serializable;

public class Actor implements Serializable {
    private final String name;
    private final int birthYear;
    private final String country;

    public Actor(String name, int birthYear, String country) {
        this.name = name;
        this.birthYear = birthYear;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " born in " + birthYear + " in " + country;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getCountry() {
        return country;
    }
}
