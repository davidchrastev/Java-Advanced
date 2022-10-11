package JavaAdvancedExam19February2022;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name,int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < capacity) {
            data.add(parrot);
        }
    }
    public boolean remove(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                data.remove(parrot);
                return true;
            }
        }
        return false;
    }
    public String sellParrot(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                return parrot.toString();
            }
        }
        return name;
    }
    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> soldParrots = new ArrayList<>();
        for (Parrot parrot : this.data) {
            if (parrot.getSpecies().equals(species)) {
                soldParrots.add(parrot);
                parrot.setAvailable(false);
            }
        }
        return soldParrots;
    }
    public int count() {
        return data.size();
    }
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parrots available at " + name + ":").append("\n");
        for (Parrot parrot : this.data) {
            if (parrot.isAvailable()) {
                stringBuilder.append(parrot).append("\n");
            }
        }
        return stringBuilder.toString();
    }


}
