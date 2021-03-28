package org.example;

public class Kettle extends Subject{
    private int volume;
    private int temperature;
    public Kettle(int weight, int volume, int temperature)
    {
        super(weight);
        this.volume = volume;
        this.temperature = temperature;
    }
    public void setVolume(int newVolume)
    {
        this.volume = newVolume;
    }
    public void setTemperature(int newTemperature)
    {
        this.temperature = newTemperature;
    }
    public int getVolume()
    {
        return this.volume;
    }
    public int getTemperature()
    {
        return this.temperature;
    }

    public void watered(Cup cup)
    {
        cup.accept(" Вода ", cup.getVolume());
    }

    public void fillWithWater(Cup cup, int temperature)
    {
        this.HeatUp(temperature);
        this.watered(cup);
    }

    public void HeatUp(int temperature)
    {
        this.setTemperature(temperature);
    }
}
