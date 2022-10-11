package ExamPreparationLab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
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
    public Pet getOldestPet() {
        return this.data.stream().max(Comparator.comparing(Pet::getAge)).get();
    }
    public int getCount() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet : data) {
            stringBuilder.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return stringBuilder.toString();

    }
}

