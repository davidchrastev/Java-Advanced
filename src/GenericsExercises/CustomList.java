package GenericsExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public int size() {
        return values.size();
    }
    public T getElement(int index) {
        return values.get(index);
    }

    public CustomList() {
        values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public T remove(int index) {
        return values.remove(index);
    }
    public boolean contains(T element) {
        return values.contains(element);
    }
    public void swap(int index, int index2) {
        Collections.swap(values, index, index2);
    }
    public int countOfGreaterItems(T element) {
        return (int) values.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }
    public T getMax() {
        return values.stream().max((f, s) -> f.compareTo(s)).get();
    }
    public T getMin() {
        return values.stream().min((f, s) -> f.compareTo(s)).get();
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (T value : values) {
            stringBuilder.append(value).append("\n");
        }
        return stringBuilder.toString().trim();
    }
}
