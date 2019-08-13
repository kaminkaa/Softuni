package p05_Generic_Count;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        /*GenericBoxComparable<String> stringsBoxComparable = new GenericBoxComparable<>();

        for (int i = 0; i < n; i++) {
            String item = reader.readLine();
            stringsBoxComparable.add(item);
        }

        String element = reader.readLine();

        System.out.println(elementsGreaterThan(stringsBoxComparable, element));*/

        GenericBoxComparable<Double> doublesBoxComparable = new GenericBoxComparable<>();

        for (int i = 0; i < n; i++) {
            double item = Double.parseDouble(reader.readLine());
            doublesBoxComparable.add(item);
        }

        double element = Double.parseDouble(reader.readLine());

        System.out.println(elementsGreaterThan(doublesBoxComparable, element));
    }

    private static <T extends Comparable> int elementsGreaterThan(GenericBoxComparable<T> box, T item) {
        int count = 0;

        for (int i = 0; i < box.size(); i++) {
            if (box.getItem(i).compareTo(item) > 0) {
                count++;
            }
        }

        return count;
    }
}
