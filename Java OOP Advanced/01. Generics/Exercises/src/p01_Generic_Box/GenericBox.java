package p01_Generic_Box;

import java.util.ArrayList;
import java.util.List;

public class GenericBox<T> {
    private List<T> items;

    public GenericBox() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        this.items.add(item);
    }

    public void add(T item, int index) {
        this.items.add(index, item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public void remove(int index) {
        this.items.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T item : items) {
            sb.append(item.getClass().getCanonicalName())
                    .append(": ")
                    .append(item)
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}

