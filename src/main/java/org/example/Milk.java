package org.example;

public class Milk extends Subject{

    public Milk(int weight) {
        super(weight);
    }

    @Override
    public void pour(Cup cup) {
        super.pour(cup);
        cup.accept(" Молоко ", this.getWeight());
        this.setWeight(0);
    }
}
