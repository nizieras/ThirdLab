package org.example;

public class Tea extends LooseSubject{

    private String grade;
    public Tea(int weight, String grade) {
        super(weight);
        this.grade = grade;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public void pourIn(Cup cup) {
        super.pourIn(cup);
        cup.accept(" Чай ",this.getWeight() );
        this.setWeight(0);
        this.setGrade("нет");
    }
}
