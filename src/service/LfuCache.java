package src.service;

import java.util.HashMap;
import java.util.Map;

public class LfuCache {
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;

    public LfuCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
    }

    public boolean contains(int key) {
        return map.containsKey(key);
    }

    public String get(int key) {

        if (!map.containsKey(key)) {
            return null;
        }

        Node item = map.get(key);
        removeNode(item);
        item.frequency = item.frequency + 1;
        addNodeWithUpdatedFrequency(item);

        return item.exchanges;
    }

    public void put(int key, String exchanges) {

        if (map.containsKey(key)) {
            Node item = map.get(key);
            item.exchanges = exchanges;
            item.frequency = item.frequency + 1;
            removeNode(item);
            addNodeWithUpdatedFrequency(item);
        } else {
            if (map.size() >= capacity) {
                map.remove(head.key);
                removeNode(head);
            }

            Node node = new Node(key, exchanges, 1);
            addNodeWithUpdatedFrequency(node);
            map.put(key, node);
        }
    }

    private void removeNode(Node node) {

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void addNodeWithUpdatedFrequency(Node node) {

        if (tail != null && head != null) {
            Node temp = head;
            while (temp != null) {
                if (temp.frequency > node.frequency) {
                    if (temp == head) {
                        node.next = temp;
                        temp.prev = node;
                        head = node;
                        break;
                    } else {
                        node.next = temp;
                        node.prev = temp.prev;
                        temp.prev.next = node;
                        break;
                    }
                } else {
                    temp = temp.next;
                    if (temp == null) {
                        tail.next = node;
                        node.prev = tail;
                        node.next = null;
                        tail = node;
                        break;
                    }
                }
            }
        } else {
            tail = node;
            head = tail;
        }
    }

    public void iterateMap() {
        for (int i = 1; i <= map.size(); i++) {
            if (map.get(i) != null) {
                System.out.println("Exchange " + i + ": " + map.get(i));
            }
        }
    }
}
