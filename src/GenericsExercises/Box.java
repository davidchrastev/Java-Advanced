package GenericsExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }
    public void add(T element) {
        values.add(element);
    }

    public Box() {
        this.values = new ArrayList<>();
    }
    public void swap(int firstIndex,int secondIndex) {
        Collections.swap(values, firstIndex, secondIndex);
    }
    public int countOfGreaterItems(T element) {
        return (int) values.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T value : values) {
            stringBuilder.append(String.format("%s: %s",value.getClass().getName(),value.toString())).append("\n");
        }
        return stringBuilder.toString();
    }
}
