package model;

import java.util.Objects;

public class Shopping {

    private String grocery;
    private String weight;

    public Shopping(String grocery, String weight) {
        this.grocery = grocery;
        this.weight = weight;
    }

    public Shopping() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shopping)) return false;
        Shopping shopping = (Shopping) o;
        return getGrocery().equals(shopping.getGrocery()) &&
                getWeight().equals(shopping.getWeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGrocery(), getWeight());
    }
}
