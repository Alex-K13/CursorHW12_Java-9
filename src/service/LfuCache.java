package service;


import model.Occurrence;

import java.util.HashMap;
import java.util.Map;

public class LfuCache {
    private Occurrence head;
    private Occurrence tail;
    private int capacity;

    private Map<Integer, Occurrence> map;

    public LfuCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }


    public void put(int key, Double exchanges) {
        if (map.containsKey(key)) {
            Occurrence occurrence = map.get(key);
            occurrence.exchanges = exchanges;
            occurrence.frequency = occurrence.frequency + 1;
            removeOccurrence(occurrence);
            addOccurrenceWithUpdatedFrequency(occurrence);
        } else {
            if (map.size() >= capacity) {
                map.remove(head.key);
                removeOccurrence(head);
            }
            Occurrence occurrence = new Occurrence(key, exchanges, 1);
            addOccurrenceWithUpdatedFrequency(occurrence);
            map.put(key, occurrence);
        }
    }

    public String get(int key) {
        if (map.get(key) == null) {
            return null;
        }
        Occurrence occurrence = map.get(key);
        removeOccurrence(occurrence);
        occurrence.frequency = occurrence.frequency + 1;
        addOccurrenceWithUpdatedFrequency(occurrence);
        return occurrence.exchanges;
    }

    private void removeOccurrence(Occurrence occurrence) {
        if (occurrence.prev != null) {
            occurrence.prev.next = occurrence.next;
        } else {
            head = occurrence.next;
        }

        if (occurrence.next != null) {
            occurrence.next.prev = occurrence.prev;
        } else {
            tail = occurrence.prev;
        }
    }

    private void addOccurrenceWithUpdatedFrequency(Occurrence occurrence) {
        if (tail != null && head != null) {
            Occurrence temp = head;
            while (true) {
                if (temp.frequency > occurrence.frequency) {
                    if (temp == head) {
                        occurrence.next = temp;
                        temp.prev = occurrence;
                        head = occurrence;
                        break;
                    } else {
                        occurrence.next = temp;
                        occurrence.prev = temp.prev;
                        temp.prev.next = occurrence;
                        break;
                    }
                } else {
                    temp = temp.next;
                    if (temp == null) {
                        tail.next = occurrence;
                        occurrence.prev = tail;
                        occurrence.next = null;
                        tail = occurrence;
                        break;
                    }
                }
            }
        } else {
            tail = occurrence;
            head = tail;
        }
    }

    public void iterateMap() {
        for (int i = 1; i <= map.size(); i++) {
            if (map.get(i) != null) {
                System.out.println("Exchanges " + i + ": " + map.get(i));
            }
        }
    }
}
