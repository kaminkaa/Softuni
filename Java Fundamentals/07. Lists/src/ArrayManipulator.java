import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayManipulator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       /* List<Integer> inputNumbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList()); */

       String[] inputNumbers = reader.readLine().split("\\s+");
       List<Integer> numbers = new ArrayList<>();

        for (String inputNumber : inputNumbers) {
            numbers.add(Integer.parseInt(inputNumber));
        }

        String command = reader.readLine();

        while (!command.equals("print")){
            String[] tokens = command.split("\\s+");

            switch (tokens[0]){
                case "add":
                    int index = Integer.parseInt(tokens[1]);
                    int element = Integer.parseInt(tokens[2]);
                    numbers.add(index,element);
                    break;

                case "addMany":
                    index = Integer.parseInt(tokens[1]);

                    List<Integer> elements = Arrays.stream(tokens)
                                                .skip(2)
                                                .map(Integer::valueOf)
                                                .collect(Collectors.toList());

                    numbers.addAll(index,elements);
                    break;

                case "contains":
                    element = Integer.parseInt(tokens[1]);
                    System.out.println(numbers.indexOf(element));
                    break;

                case "remove":
                    index = Integer.parseInt(tokens[1]);
                    numbers.remove(index);
                    break;

                case "shift":
                    int positions = Integer.parseInt(tokens[1]);
                    Collections.rotate(numbers,positions * -1);
                    break;

                case "sumPairs":
                    int first, second;
                    List<Integer> temp = new ArrayList<>();

                    for (int i = 1; i < numbers.size(); i+=2) {
                        first = numbers.get(i-1);
                        second = numbers.get(i);
                        temp.add(first + second);
                    }

                    if (numbers.size()%2 != 0){
                        temp.add(numbers.get(numbers.size() -1));
                    }

                    numbers.clear();
                    numbers.addAll(temp);
                    break;
            }

            command = reader.readLine();
        }
        System.out.println(numbers);
    }
}
