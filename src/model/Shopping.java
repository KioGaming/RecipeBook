package model;

public class Shopping {
    private String grocery;
    private Double weight;
    private String unitsOfMeasurement;
    // private CheckBox isSelected;

    public Shopping() {
    }

    public Shopping(String grocery, Double weight, String unitsOfMeasurement) {
        this.grocery = grocery;
        this.weight = weight;
        this.unitsOfMeasurement = unitsOfMeasurement;
        // this.isSelected.setSelected(false);
    }

    public String getGrocery() {
        return grocery;
    }

    public void setGrocery(String grocery) {
        this.grocery = grocery;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getUnitsOfMeasurement() {
        return unitsOfMeasurement;
    }

    public void setUnitsOfMeasurement(String unitsOfMeasurement) {
        this.unitsOfMeasurement = unitsOfMeasurement;
    }

   /* public void setIsSelected(boolean isSelected) {
        this.isSelected.setSelected(isSelected);
    }

    public boolean isSelected() {
        return this.isSelected.isSelected();
    }*/
}
