import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputLine = Arrays.stream(reader.readLine().split("\\s+"))
                                    .collect(Collectors.toList());

        String command = reader.readLine();

        while (true) {
            if (command.equals("3:1")) { break; }

            String[] tokens = command.split("\\s+");
            String commandName = tokens[0].toLowerCase();

            switch (commandName) {
                case "merge" :
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    StringBuilder sbMerger;

                    if (startIndex <0 || startIndex > inputLine.size()-1) {
                        startIndex = 0;
                    }

                    if (endIndex > inputLine.size()-1) {
                        endIndex = inputLine.size()-1;
                    }

                    sbMerger = MergeStartEnd(inputLine,startIndex,endIndex);
                    inputLine.add(startIndex,sbMerger.toString());
                    for (int i = endIndex+1; i >= startIndex+1; i--) {
                        inputLine.remove(i);
                    }
                    break;

                case "divide":
                    int index = Integer.parseInt(tokens[1]);
                    int partitions = Integer.parseInt(tokens[2]);
                    if (partitions == 0) {
                        break;
                    }
                    String element = inputLine.get(index);
                    String[] parts = new String[partitions];
                    int step = element.length() / partitions;
                    int j = 0;

                    // IF STRING IS EXACTLY DIVIDABLE
                    if (isExactlyDividable(element,partitions)) {
                        for (int i = 0; i < element.length(); i+=step){
                            parts[j] = element.substring(i,i+step);
                            j++;
                        }

                        j = 0;
                        for (int i = index; i < index + partitions; i++){
                            inputLine.add(i,parts[j]);
                            j++;
                        }
                        inputLine.remove(index+partitions);
                    }
                    // IF STRING IS NOT EXACTLY DIVIDABLE
                    else {
                        int remainder = element.length() % partitions;
                        for (int i = 0; i < element.length() - step - remainder; i+=step){
                            parts[j] = element.substring(i,i+step);
                            j++;
                        }
                        parts[j] = element.substring(element.length() - step - remainder, element.length());
                        j = 0;
                        for (int i = index; i < index + partitions; i++){
                            inputLine.add(i,parts[j]);
                            j++;
                        }
                        inputLine.remove(index+partitions);
                    }

                    break;
            }

            command = reader.readLine();
        }

        System.out.println(String.join(" ", inputLine));
    }

    static boolean isExactlyDividable (String element, int partitions) {
        if (element.length()%partitions == 0) {
            return true;
        } else {
            return false;
        }
    }
    static StringBuilder MergeStartEnd (List<String> inputLine, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(inputLine.get(i));
        }
        return sb;
    }
}
