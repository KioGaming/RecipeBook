package saveload;

import model.Dish;
import model.Playlist;

import java.util.ArrayList;
import java.util.List;

public final class SaveData {

    private static List<Dish> dishes;
    private static List<Dish> category1 = new ArrayList<>();
    private static List<Dish> category2 = new ArrayList<>();
    private static List<Dish> category3 = new ArrayList<>();
    private static List<Dish> category4 = new ArrayList<>();
    private static List<Dish> category5 = new ArrayList<>();
    private static List<Dish> category6 = new ArrayList<>();
    private static List<Dish> category7 = new ArrayList<>();

    private int counter = 0;
    private int lastCounterChange = 5;

    private static List<Playlist> playlists = new ArrayList<>();
    private static List<Dish> like = new ArrayList<>();

    private int likeCounter = 0;
    private int likeLastCounterChange = 15;

    public SaveData(int idUser) {
        SaveLoad.load(this, idUser);
        reloadAllLists();
    }

    public void reloadAllLists() {
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
        this.counter = counter;
        if (this.counter < 0) {
            this.counter = 0;
        }
    }

    public int getLastCounterChange() {
        return lastCounterChange;
    }

    public void setLastCounterChange(int lastCounterChange) {
        this.lastCounterChange = lastCounterChange;
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
        SaveLoad.saveLikedDishes(iduser, iddish);
    }

    public void removeLikedDishes(int idUser, int iddish) {
        SaveLoad.removeLikedDishes(idUser, iddish);
    }

    public int getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(int likeCounter) {
        this.likeCounter = likeCounter;
        if (this.likeCounter < 0) {
            this.likeCounter = 0;
        }
    }

    public int getLikeLastCounterChange() {
        return likeLastCounterChange;
    }

    public void setLikeLastCounterChange(int likeLastCounterChange) {
        this.likeLastCounterChange = likeLastCounterChange;
    }

    @Override
    public String toString() {
        return "SaveData{" +
                "counter=" + counter +
                ", lastCounterChange=" + lastCounterChange +
                ", likeCounter=" + likeCounter +
                ", likeLastCounterChange=" + likeLastCounterChange +
                '}';
    }
}