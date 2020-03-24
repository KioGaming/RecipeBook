package model;

import exception.ModelException;

import java.util.ArrayList;

public class Dish {

    private String title;
    private String photo;
    private String description;
    private String category;
    private ArrayList<String> recipe;
    private ArrayList<String> groceryList;
    private ArrayList<String> countList;
    private ArrayList<String> unitsOfMeasurementList;
    private int numberOfLikes;

    public Dish(){}

    public Dish(String title, String photo, String description, String category, ArrayList<String> recipe, ArrayList<String> groceryList,
                ArrayList<String> countList, ArrayList<String> unitsOfMeasurementList, int numberOfLikes) throws ModelException {
        if (title.length() == 0) {
            throw new ModelException(ModelException.PROGRAM_ERROR);
        }
        if (photo.length() == 0) {
            throw new ModelException(ModelException.PROGRAM_ERROR);
        }
        if (description.length() == 0) {
            throw new ModelException(ModelException.PROGRAM_ERROR);
        }
        if (recipe.size() == 0) {
            throw new ModelException(ModelException.PROGRAM_ERROR);
        }
        if (groceryList.size() == 0) {
            throw new ModelException(ModelException.PROGRAM_ERROR);
        }
        if (unitsOfMeasurementList.size() == 0) {
            throw new ModelException(ModelException.PROGRAM_ERROR);
        }
        this.title = title;
        this.photo = photo;
        this.description = description;
        this.category = category;
        this.recipe = recipe;
        this.groceryList = groceryList;
        this.countList = countList;
        this.unitsOfMeasurementList = unitsOfMeasurementList;
        this.numberOfLikes = numberOfLikes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getRecipe() {
        return recipe;
    }

    public void setRecipe(ArrayList<String> recipe) {
        this.recipe = recipe;
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(ArrayList<String> groceryList) {
        this.groceryList = groceryList;
    }

    public ArrayList<String> getCountList() {
        return countList;
    }

    public void setCountList(ArrayList<String> countList) {
        this.countList = countList;
    }

    public ArrayList<String> getUnitsOfMeasurementList() {
        return unitsOfMeasurementList;
    }

    public void setUnitsOfMeasurementList(ArrayList<String> unitsOfMeasurementList) {
        this.unitsOfMeasurementList = unitsOfMeasurementList;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return title + " " + photo + " " + description + " " + category + " " + recipe.toString() + " " + groceryList.toString() + " " + countList.toString() + unitsOfMeasurementList.toString() + " " + numberOfLikes + "\n";
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
