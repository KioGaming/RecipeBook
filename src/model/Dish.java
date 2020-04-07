package model;

import java.util.List;
import java.util.Objects;

public class Dish {

    private int id;
    private String title;
    private String photo;
    private String description;
    private String category;
    private List<String> recipe;
    private List<Shopping> groceryList;
    private int numberOfLikes;

    public Dish() {
    }

    public Dish(int id, String title, String photo, String description, String category, List<String> recipe, List<Shopping> groceryList,
                int numberOfLikes) {
        this.id = id;
        this.title = title;
        this.photo = photo;
        this.description = description;
        this.category = category;
        this.recipe = recipe;
        this.groceryList = groceryList;
        this.numberOfLikes = numberOfLikes;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<String> recipe) {
        this.recipe = recipe;
    }

    public List<Shopping> getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(List<Shopping> groceryList) {
        this.groceryList = groceryList;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getPhoto(), getDescription(), getCategory(), getRecipe(), getGroceryList(), getNumberOfLikes());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return getId() == dish.getId() &&
                getNumberOfLikes() == dish.getNumberOfLikes() &&
                getTitle().equals(dish.getTitle()) &&
                getPhoto().equals(dish.getPhoto()) &&
                getDescription().equals(dish.getDescription()) &&
                getCategory().equals(dish.getCategory()) &&
                getRecipe().equals(dish.getRecipe()) &&
                getGroceryList().equals(dish.getGroceryList());
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", recipe=" + recipe +
                ", groceryList=" + groceryList +
                ", numberOfLikes=" + numberOfLikes +
                '}';
    }
}
