package saveload;

import model.Dish;
import model.ShoppingList;

import java.util.ArrayList;
import java.util.List;

public final class SaveData {

    private int counter = 0;
    private int lastCounterChange = 5;
    private static List<Dish> dishes;
    private static List<String> likedDishes;
    private static ShoppingList shoppingList;
    private static List<Dish> c1 = new ArrayList<>();
    private static List<Dish> c2 = new ArrayList<>();
    private static List<Dish> c3 = new ArrayList<>();
    private static List<Dish> c4 = new ArrayList<>();
    private static List<Dish> c5 = new ArrayList<>();
    private static List<Dish> c6 = new ArrayList<>();
    private static List<Dish> c7 = new ArrayList<>();

    public SaveData() {
    }

    public void load(int iduser, String username) {
        SaveLoad.load(this, iduser);
        for (int i = 0; i < dishes.size(); i++) {
            if (dishes.get(i).getCategory().equals("Перші страви")) {
                c1.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Другі страви")) {
                c2.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Салати та закуски")) {
                c3.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Випічка")) {
                c4.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Торти")) {
                c5.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Десерти")) {
                c6.add(dishes.get(i));
            } else {
                c7.add(dishes.get(i));
            }
        }
    }

    public void saveLikedDishes(int iduser, String title) {
        SaveLoad.saveLikedDishes(this, iduser, title);
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        SaveData.dishes = dishes;
    }

    public List<String> getLikedDishes() {
        return likedDishes;
    }

    public void setLikedDishes(List<String> likedDishes) {
        SaveData.likedDishes = likedDishes;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        SaveData.shoppingList = shoppingList;
    }

    @Override
    public String toString() {
        return dishes.toString()  + "\n" + likedDishes.toString() + "\n" + shoppingList.toString() + "\n";
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void addCounter() {
        this.counter += 10;
    }

    public int getLastCounterChange() {
        return lastCounterChange;
    }

    public void setLastCounterChange(int lastCounterChange) {
        this.lastCounterChange = lastCounterChange;
    }

    public List<Dish> getC1() {
        return c1;
    }

    public void setC1(List<Dish> c1) {
        SaveData.c1 = c1;
    }

    public List<Dish> getC2() {
        return c2;
    }

    public void setC2(List<Dish> c2) {
        SaveData.c2 = c2;
    }

    public List<Dish> getC3() {
        return c3;
    }

    public void setC3(List<Dish> c3) {
        SaveData.c3 = c3;
    }

    public List<Dish> getC4() {
        return c4;
    }

    public void setC4(List<Dish> c4) {
        SaveData.c4 = c4;
    }

    public List<Dish> getC5() {
        return c5;
    }

    public void setC5(List<Dish> c5) {
        SaveData.c5 = c5;
    }

    public List<Dish> getC6() {
        return c6;
    }

    public void setC6(List<Dish> c6) {
        SaveData.c6 = c6;
    }

    public List<Dish> getC7() {
        return c7;
    }

    public void setC7(List<Dish> c7) {
        SaveData.c7 = c7;
    }

    public void removeLikedDishes(int idUser, String title) {
        SaveLoad.removeLikedDishes(this, idUser, title);
    }
}
