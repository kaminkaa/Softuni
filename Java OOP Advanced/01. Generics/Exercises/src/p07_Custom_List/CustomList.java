package p07_Custom_List;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable> {
    private List<T> customList;

    public CustomList() {
        this.customList = new ArrayList<>();
    }

    public void add(T element) {
        this.customList.add(element);
    }

    public T remove(int index) {
        return this.customList.remove(index);
    }

    boolean contains(T element) {
        return this.customList.contains(element);
    }

    void swap(int index1, int index2) {
        T item1 = this.customList.get(index1);
        T item2 = this.customList.get(index2);

        this.customList.remove(index1);
        this.customList.add(index1, item2);
        this.customList.remove(index2);
        this.customList.add(index2, item1);
    }

    int countGreaterThan(T element) {
        int count = 0;

        for (int i = 0; i < this.customList.size(); i++) {
            if (this.customList.get(i).compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public T getMax() {
        T max = this.customList.get(0);

        for (T t : customList) {
            if (t.compareTo(max) > 0) {
                max = t;
            }
        }

        return max;
    }

    public T getMin() {
        T min = this.customList.get(0);

        for (T t : customList) {
            if (t.compareTo(min) < 0) {
                min = t;
            }
        }

        return min;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T element : this.customList) {
            sb.append(element).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
