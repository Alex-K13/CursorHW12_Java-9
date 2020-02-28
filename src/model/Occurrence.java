package model;

public class Occurrence {
    public int frequency;
    public Occurrence prev;
    public Occurrence next;
    public int key;
    public String exchanges;

    public Occurrence(int key, String exchanges, int frequency) {
        this.key = key;
        this.exchanges = exchanges;
        this.frequency = frequency;
    }
    @Override
    public  String toString(){
        return exchanges;
    }
}
