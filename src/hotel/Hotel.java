package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    List<Person> entities;
    String name;
    int capacity;

    public String getName() {
        return name;
    }
    public Hotel(String name,int capacity) {
        this.capacity = capacity;
        this.name = name;
        this.entities = new ArrayList<>();
    }
    public void add(Person person) {
        if (this.entities.size() < capacity) {
            entities.add(person);
        }
    }
    public boolean remove(String name) {
        for (Person person : this.entities) {
            if (person.getName().equals(name)) {
                return this.entities.remove(person);
            }
        }
        return false;
    }
    public Person getPerson(String name,String hometown) {
        for (Person person : this.entities) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                return person;
            }
        }
        return null;
    }
    public int getCount() {
        return this.entities.size();
    }
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("The people in the hotel ").append(getName()).append(" are:").append("\n");
        for (Person person : this.entities) {
            builder.append(person.toString()).append("\n");
        }
        return builder.toString();
    }
}
