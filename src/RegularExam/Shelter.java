package RegularExam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }
    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }
    public boolean remove(String name) {
        for (Animal animal : data) {
            if (animal.getName().equals(name)) {
                data.remove(animal);
                return true;
            }
        }
        return false;
    }
    public Animal getAnimal(String name, String caretaker) {
        for (Animal animal : data) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                return animal;
            }
        }
        return null;
    }
    public Animal getOldestAnimal() {
        return data.stream().max(Comparator.comparing(Animal::getAge)).get();
    }
    public int getCount() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The shelter has the following animals:").append(System.lineSeparator());
        for (Animal animal : data) {
            stringBuilder.append(animal.getName()).append(" ").append(animal.getCaretaker()).append(System.lineSeparator());

        }
        return stringBuilder.toString();
    }
}
