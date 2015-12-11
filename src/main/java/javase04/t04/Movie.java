package javase04.t04;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Movie implements Serializable {

    private static final String NEWLINE = System.getProperty("line.separator");
    private String title;
    private int year;
    private String description;
    private List<Actor> stars;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(year, movie.year) &&
                Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(" (").append(year).append(")").append(NEWLINE).append("Stars ");
        for (int i = 0; i < stars.size() - 1; i++) {
            sb.append(stars.get(i).getName()).append(", ");
        }
        sb.append(stars.get(stars.size() - 1).getName());
        sb.append(NEWLINE);
        sb.append(description).append(NEWLINE);
        return sb.toString();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Actor> getStars() {
        return stars;
    }

    public void setStars(List<Actor> stars) {
        this.stars = stars;
    }

    public Movie(String title, int year, String description, List<Actor> stars) {

        this.title = title;
        this.year = year;
        this.description = description;
        this.stars = stars;
    }
}
