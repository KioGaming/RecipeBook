package model;

import java.util.List;
import java.util.Objects;

public class Playlist {

    private int id;
    private String title;
    private List<Dish> dishes;

    public Playlist(int id, String title, List<Dish> dishes) {
        this.id = id;
        this.title = title;
        this.dishes = dishes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dishes=" + dishes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Playlist)) return false;
        Playlist playlist = (Playlist) o;
        return getId() == playlist.getId() &&
                getTitle().equals(playlist.getTitle()) &&
                getDishes().equals(playlist.getDishes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDishes());
    }
}