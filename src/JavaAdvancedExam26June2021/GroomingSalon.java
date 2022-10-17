package JavaAdvancedExam26June2021;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    public List<Pet> data;
    public int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }
    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }
    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                data.remove(pet);
                return true;
            }
        }
        return false;
    }
    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }
    public int getCount() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The grooming salon has the following clients:").append(System.lineSeparator());

        for (Pet pet : data) {
            stringBuilder.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
