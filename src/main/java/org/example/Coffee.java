package org.example;



public class Coffee extends LooseSubject{
    private String taste;
    public Coffee(int weight, String taste)
    {
        super(weight);
        this.taste = taste;
    }
    public void setTaste(String newTaste)
    {
        this.taste = newTaste;
    }
    public String getTaste()
    {
        return this.taste;
    }

    @Override
    public void pourIn(Cup cup) {
        super.pourIn(cup);
        cup.accept(" Кофе ", this.getWeight());
        this.setWeight(0);
        this.setTaste("отсутствует");
    }

}
