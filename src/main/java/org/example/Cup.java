package org.example;

public class Cup extends Subject{
    private int volume;
    private String content;
    public Cup(int weight, int volume, String content)
    {
        super(weight);
        this.volume =volume;
        this.content = content;
    }
    public void setVolume(int newVolume)
    {
        this.volume = newVolume;
    }
    public void setContent(String newContent)
    {
        this.content = newContent;
    }
    public int getVolume()
    {
        return this.volume;
    }
    public String getContent()
    {
        return this.content;
    }

    public void accept(String content, int weight)
    {
        this.setContent(this.getContent()+content);
        this.setWeight(this.getWeight()+weight);
    }

}
