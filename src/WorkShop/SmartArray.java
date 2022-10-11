package WorkShop;

/**
 * Custom implementation of List<> data structure
 */

import java.util.function.Consumer;

public class SmartArray<T> {
    private int[] data;

    private  int size;


    public SmartArray() {
        this.size = 0;
        this.data = new int[4];
    }

    public void add(int element) {
        if (size == data.length) {
            data = grow();
        }
        data[size++] = element;
    }

    private int[] grow() {
        int newLength = data.length * 2;

        int[] newData = new int[newLength];

        System.arraycopy(data, 0, newData, 0, data.length);

        return newData;

    }
    public boolean ensureIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return true;
    }
    public int get(int index) {
        ensureIndex(index);

        return data[index];
    }

    public int size() {
        return size;
    }

    public int remove(int index) {
        int removedElement = get(index);

        if (size - index >= 0)  {
            System.arraycopy(data, index + 1, data, index, size - index);
        }

        data[size - 1] = 0;
        size--;

        return removedElement;
    }
    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }
    public void add(int index, int element) {

        int lastElement = data[size - 1];

        for (int i = size - 1; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;

        add(lastElement);
    }
    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }
    }
}
