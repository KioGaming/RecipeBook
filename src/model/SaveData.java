package model;

import login.SaveLoadRemote;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class SaveData implements Serializable {

    private static List<Dish> dishes;
    private static List<Dish> category1 = new ArrayList<>();
    private static List<Dish> category2 = new ArrayList<>();
    private static List<Dish> category3 = new ArrayList<>();
    private static List<Dish> category4 = new ArrayList<>();
    private static List<Dish> category5 = new ArrayList<>();
    private static List<Dish> category6 = new ArrayList<>();
    private static List<Dish> category7 = new ArrayList<>();

    private static int counter = 0;
    private static int lastCounterChange = 5;

    private static List<Playlist> playlists = new ArrayList<>();
    private static List<Dish> like = new ArrayList<>();

    private static int likeCounter = 0;
    private static int likeLastCounterChange = 15;

    public SaveData() {
        // reloadAllLists();
    }

    public void reloadAllLists() {
        category1 = new ArrayList<>();
        category2 = new ArrayList<>();
        category3 = new ArrayList<>();
        category4 = new ArrayList<>();
        category5 = new ArrayList<>();
        category6 = new ArrayList<>();
        category7 = new ArrayList<>();
        for (int i = 0; i < dishes.size(); i++) {
            if (dishes.get(i).getCategory().equals("Перші страви")) {
                category1.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Другі страви")) {
                category2.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Салати та закуски")) {
                category3.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Випічка")) {
                category4.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Торти")) {
                category5.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Десерти")) {
                category6.add(dishes.get(i));
            } else {
                category7.add(dishes.get(i));
            }
        }
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        SaveData.dishes = dishes;
    }

    public List<Dish> getCategory1() {
        return category1;
    }

    public List<Dish> getCategory2() {
        return category2;
    }

    public List<Dish> getCategory3() {
        return category3;
    }

    public List<Dish> getCategory4() {
        return category4;
    }

    public List<Dish> getCategory5() {
        return category5;
    }

    public List<Dish> getCategory6() {
        return category6;
    }

    public List<Dish> getCategory7() {
        return category7;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        SaveData.counter = counter;
        if (SaveData.counter < 0) {
            SaveData.counter = 0;
        }
    }

    public int getLastCounterChange() {
        return lastCounterChange;
    }

    public void setLastCounterChange(int lastCounterChange) {
        SaveData.lastCounterChange = lastCounterChange;
    }

    public List<Dish> getLike() {
        return like;
    }

    public void setLike(List<Dish> like) {
        SaveData.like = like;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        SaveData.playlists = playlists;
    }

    public void saveLikedDishes(int iduser, int iddish) {
        SaveLoadRemote.saveLikedDishes(iduser, iddish);
    }

    public void removeLikedDishes(int idUser, int iddish) {
        SaveLoadRemote.removeLikedDishes(idUser, iddish);
    }

    public int getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(int likeCounter) {
        SaveData.likeCounter = likeCounter;
        if (SaveData.likeCounter < 0) {
            SaveData.likeCounter = 0;
        }
    }

    public int getLikeLastCounterChange() {
        return likeLastCounterChange;
    }

    public void setLikeLastCounterChange(int likeLastCounterChange) {
        SaveData.likeLastCounterChange = likeLastCounterChange;
    }

    @Override
    public String toString() {
        return "SaveData{" +
                "counter=" + counter +
                ", lastCounterChange=" + lastCounterChange +
                ", likeCounter=" + likeCounter +
                ", likeLastCounterChange=" + likeLastCounterChange +
                "\nlikeLastCounterChange=" + dishes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaveData)) return false;
        SaveData saveData = (SaveData) o;
        return getCounter() == saveData.getCounter() &&
                getLastCounterChange() == saveData.getLastCounterChange() &&
                getLikeCounter() == saveData.getLikeCounter() &&
                getLikeLastCounterChange() == saveData.getLikeLastCounterChange();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCounter(), getLastCounterChange(), getLikeCounter(), getLikeLastCounterChange());
    }
}