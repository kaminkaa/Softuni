package p07_Custom_List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> customList = new CustomList<>();

        String command = reader.readLine();

        while (!"END".equals(command)) {
            String[] tokens = command.split(" ");
            String element;
            int index, index2;

            switch (tokens[0]) {
                case "Add":
                    element = tokens[1];
                    customList.add(element);
                    break;
                case "Remove":
                    index = Integer.parseInt(tokens[1]);
                    System.out.println(customList.remove(index));
                    break;
                case "Contains":
                    element = tokens[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    index = Integer.parseInt(tokens[1]);
                    index2 = Integer.parseInt(tokens[2]);
                    customList.swap(index, index2);
                    break;
                case "Greater":
                    element = tokens[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.println(customList.toString());
                    break;
                    default:
                        break;

            }

            command = reader.readLine();
        }
    }
}
