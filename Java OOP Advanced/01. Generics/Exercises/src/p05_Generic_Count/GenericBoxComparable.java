package p05_Generic_Count;

import java.util.ArrayList;
import java.util.List;

public class GenericBoxComparable<T extends Comparable> {
    private List<T> items;

    public GenericBoxComparable() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        this.items.add(item);
    }

    public int size() {
        return this.items.size();
    }

    public T getItem(int index) {
        return this.items.get(index);
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
