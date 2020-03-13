package saveload;

import model.Dish;
import model.ShoppingList;

import java.util.ArrayList;
import java.util.List;

public final class SaveData {

    private int counter = 0;
    private int lastCounterChange = 5;
    public static List<Dish> dishes;
    private List<String> likedDishes;
    private ShoppingList shoppingList;
    public static List<Dish> c1 = new ArrayList<>();
    public static List<Dish> c2 = new ArrayList<>();
    public static List<Dish> c3 = new ArrayList<>();
    public static List<Dish> c4 = new ArrayList<>();
    public static List<Dish> c5 = new ArrayList<>();
    public static List<Dish> c6 = new ArrayList<>();
    public static List<Dish> c7 = new ArrayList<>();
    public static List<Dish> c8 = new ArrayList<>();
    public static List<Dish> c9 = new ArrayList<>();
    public static List<Dish> c10 = new ArrayList<>();
    public static List<Dish> c11 = new ArrayList<>();

    public SaveData() {
        SaveLoad.load(this);
        for (int i = 0; i < dishes.size(); i++) {
            if (dishes.get(i).getCategory().equals("Супи та борщі")) {
                c1.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Гарячі страви")) {
                c2.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Салати")) {
                c3.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Закуски")) {
                c4.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Напої")) {
                c5.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Соуси")) {
                c6.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Випічка")) {
                c7.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Десерти")) {
                c8.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Заготовки")) {
                c9.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Каші")) {
                c10.add(dishes.get(i));
            } else if (dishes.get(i).getCategory().equals("Приготування молочних продуктів")) {
                c11.add(dishes.get(i));
            }
        }
    }

    public void load(String username){
        SaveLoad.load(this, username);
    }

    public void load() {
        SaveLoad.load(this);
    }

    public void save(String username){
        SaveLoad.save(this, username);
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
        this.likedDishes = likedDishes;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
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

    public List<Dish> getC8() {
        return c8;
    }

    public void setC8(List<Dish> c8) {
        SaveData.c8 = c8;
    }

    public List<Dish> getC9() {
        return c9;
    }

    public void setC9(List<Dish> c9) {
        SaveData.c9 = c9;
    }

    public List<Dish> getC10() {
        return c10;
    }

    public void setC10(List<Dish> c10) {
        SaveData.c10 = c10;
    }

    public List<Dish> getC11() {
        return c11;
    }

    public void setC11(List<Dish> c11) {
        SaveData.c11 = c11;
    }
}
