package model;

import saveload.SaveData;

import java.util.ArrayList;

public class ShoppingList {

    private ArrayList<String> shoppingList;
    private ArrayList<Double> countList;
    private ArrayList<String> unitsOfMeasurementList;

    public ShoppingList(){}

    public ShoppingList(ArrayList<String> shoppingList, ArrayList<Double> countList, ArrayList<String> unitsOfMeasurementList) {
        this.shoppingList = shoppingList;
        this.countList = countList;
        this.unitsOfMeasurementList = unitsOfMeasurementList;
    }

    public ArrayList<String> getShoppingList(){
        return shoppingList;
    }

    public ArrayList<Double> getCountList(){
        return countList;
    }

    public void setShoppingList(ArrayList<String> shoppingList){
        this.shoppingList = shoppingList;
    }

    public void setCountList(ArrayList<Double> countList){
        this.countList = countList;
    }

    public ArrayList<String> getUnitsOfMeasurementList() {
        return unitsOfMeasurementList;
    }

    public void setUnitsOfMeasurementList(ArrayList<String> unitsOfMeasurementList) {
        this.unitsOfMeasurementList = unitsOfMeasurementList;
    }

    public void add(ArrayList<String> smallShoppingList, ArrayList<Double> smallCountList, SaveData sd){
        Double n;
        for (int i = 0; i < smallShoppingList.size(); i++) {
            if (shoppingList.indexOf(smallShoppingList.get(i)) == -1) {
                this.shoppingList.add(smallShoppingList.get(i));
                this.countList.add(smallCountList.get(i));
            } else {
                n = countList.get(shoppingList.indexOf(smallShoppingList.get(i))) + smallCountList.get(i);
                this.countList.set(shoppingList.indexOf(smallShoppingList.get(i)), n);
            }
        }
        sd.setShoppingList(this);
    }

    public void edit(int number, SaveData sd){
        this.shoppingList.remove(number);
        this.countList.remove(number);
        sd.setShoppingList(this);
    }

    public void clear(SaveData sd) {
        shoppingList.clear();
        countList.clear();
        sd.setShoppingList(this);
    }

    @Override
    public String toString() {
        return shoppingList.toString() + " " + countList.toString() + " " + unitsOfMeasurementList.toString() + "\n";
    }
}
