package saveload;

import model.Dish;
import model.ShoppingList;

import java.util.List;

public final class SaveData {

    private int counter = 0;
    private int lastCounterChange = 5;
    private List<Dish> dishes;
    private List<String> likedDishes;
    private ShoppingList shoppingList;

    public SaveData() {
        SaveLoad.load(this);
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
        this.dishes = dishes;
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
}
