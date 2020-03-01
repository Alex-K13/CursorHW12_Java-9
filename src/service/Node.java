package src.service;

public class Node {
    public int frequency;
    public Node prev;
    public Node next;
    public int key;
    public String exchanges;

    public Node(int key, String exchanges, int frequency) {
        this.key = key;
        this.exchanges = exchanges;
        this.frequency = frequency;
    }
    @Override
    public  String toString(){
        return exchanges;
    }
}


