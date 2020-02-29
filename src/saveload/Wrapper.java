package saveload;

import model.Dish;
import model.ShoppingList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "data")
public class Wrapper {

    private Dish dish;
    private List<String> likedDishes;
    private ShoppingList shoppingList;

    @XmlElement(name = "dish")
    public Dish getDish() {
        return dish;
    }

    public void setDishes(Dish dish){
        this.dish = dish;
    }

    @XmlElement(name = "likedDishes")
    public List<String> getLikedDishes() {
        return likedDishes;
    }

    public void setLikedDishes(List<String> likedDishes) {
        this.likedDishes = likedDishes;
    }

    @XmlElement(name = "shoppingList")
    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
}
