package org.example;

public class Subject {
    private int weight;

    public Subject(int weight)
    {
        this.weight = weight;
    }
    public void setWeight(int newWeight)
    {
        this.weight = newWeight;
    }
    public int getWeight()
    {
        return this.weight;
    }

    public void pour(Cup cup){}
}
