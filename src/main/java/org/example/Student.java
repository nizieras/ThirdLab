package org.example;

public class Student {
    private String name;
    public Student(String name)
    {
        this.name = name;
    }
    public void setStudentName(String newName)
    {
        this.name = newName;
    }
    public String getStudentName()
    {
        return this.name;
    }

    public void makeCoffee(Sugar sugar, Coffee coffee, Kettle kettle, Cup cup, int temperature) {

        sugar.pourIn(cup);
        coffee.pourIn(cup);
        kettle.fillWithWater(cup, temperature);
    }

    public void makeTea(Sugar sugar, Kettle kettle, Cup cup, Tea tea)
    {
        sugar.pourIn(cup);
        tea.pourIn(cup);
        kettle.fillWithWater(cup, kettle.getTemperature());
    }

    public void makeCoffeeWithMilk(Sugar sugar, Coffee coffee, Kettle kettle, Cup cup, int temperature)
    {
        this.makeCoffee(sugar,coffee,kettle,cup,temperature);
        Milk milk = new Milk(10);
        milk.pour(cup);
    }
}
