import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> inputNumbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        String command = reader.readLine();

        while (!command.equals("Odd") && !command.equals("Even")){
            String[] tokens = command.split("\\s+");

            switch (tokens[0]){
                case "Delete":
                    int element = Integer.parseInt(tokens[1]);

                    for (int i = inputNumbers.size() - 1; i >= 0; i--) {
                        if (inputNumbers.get(i) == element){
                            inputNumbers.remove(inputNumbers.get(i));
                        }
                    }
                    break;

                case "Insert":
                    element = Integer.parseInt(tokens[1]);
                    int index = Integer.parseInt(tokens[2]);

                    inputNumbers.add(index,element);
                    break;
            }
            command = reader.readLine();
        }

        switch (command){
            case "Odd":
                for (int i = 0; i < inputNumbers.size(); i++) {
                    if (inputNumbers.get(i)%2 != 0){
                        System.out.print(inputNumbers.get(i) + " ");
                    }

                }
                break;

            case "Even":
                for (int i = 0; i < inputNumbers.size(); i++) {
                    if (inputNumbers.get(i)%2 == 0){
                        System.out.print(inputNumbers.get(i) + " ");
                    }

                }
                break;
        }
    }
}
