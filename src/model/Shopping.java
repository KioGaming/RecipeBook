package model;

public class Shopping {
    private String grocery;
    private String weight;

    public Shopping() {
    }

    public Shopping(String grocery, String weight) {
        this.grocery = grocery;
        this.weight = weight;
    }

    public String getGrocery() {
        return grocery;
    }

    public void setGrocery(String grocery) {
        this.grocery = grocery;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String toString() {
        return grocery + " " + weight;
    }
}
