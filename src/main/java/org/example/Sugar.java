package org.example;

public class Sugar extends LooseSubject{
    public Sugar(int weight)
    {
        super(weight);
    }

    @Override
    public void pourIn(Cup cup) {
        super.pourIn(cup);
        cup.accept(" Сахар ", this.getWeight());
        this.setWeight(0);
    }

}
