package p01_Generic_Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        GenericBox<String> stringsBox = new GenericBox<>();

        for (int i = 0; i < n; i++) {
            String item = reader.readLine();

            stringsBox.add(item);
        }

        int[] indexes = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        swap(stringsBox, indexes[0], indexes[1]);

        System.out.println(stringsBox.toString());

        n = Integer.parseInt(reader.readLine());
        GenericBox<Integer> integersBox = new GenericBox<>();

        for (int i = 0; i < n; i++) {
            int item = Integer.parseInt(reader.readLine());

            integersBox.add(item);
        }

        indexes = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        swap(integersBox, indexes[0],indexes[1]);

        System.out.println(integersBox.toString());
    }

    private static <T> void swap(GenericBox<T> genericBox, int index1, int index2) {
        T item1 = genericBox.getItem(index1);
        T item2 = genericBox.getItem(index2);
        genericBox.remove(index1);
        genericBox.add(item2, index1);
        genericBox.remove(index2);
        genericBox.add(item1, index2);
    }
}
