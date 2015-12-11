package javase04.t04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieCollection implements Serializable {

    private List<Movie> collection = new ArrayList<>();

    public List<Movie> getCollection() {
        return collection;
    }

    public void setCollection(List<Movie> collection) {
        this.collection = collection;
    }

    public void addMovie(Movie movie) {
        collection.add(movie);
    }

    public MovieCollection(List<Movie> collection) {

        this.collection = collection;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Movie movie : collection) {
            sb.append(movie);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void save(String fileTo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileTo))) {
            out.writeObject(this);
            System.out.printf("Serialized data is saved in " + fileTo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieCollection that = (MovieCollection) o;
        return Objects.equals(collection, that.collection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collection);
    }

    public static MovieCollection open(String fileFrom) {
        MovieCollection movieCollection = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileFrom))) {
            movieCollection = (MovieCollection) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return movieCollection;
    }

    public static void main(String[] args) {

    }
}
