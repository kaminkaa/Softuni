import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> distances = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        int index;
        int value;
        int sumRemovedElements = 0;

        while (true){
            if (distances.size() == 0) { break; }

            index = Integer.parseInt(reader.readLine());

            if (index < 0) {
                value = distances.get(0);
                distances.remove(0);
                sumRemovedElements += value;
                distances.add(0,distances.get(distances.size() - 1));
            } else if (index > distances.size() - 1) {
                value = distances.get(distances.size() - 1);
                distances.remove(distances.size() - 1);
                sumRemovedElements += value;
                distances.add(distances.get(0));
            } else {
                value = distances.get(index);
                distances.remove(index);
                sumRemovedElements += value;
            }

            for (int i = 0;  i < distances.size(); i++) {
                if (distances.get(i) <= value) {
                    distances.set(i, distances.get(i) + value);
                } else {
                    distances.set(i, distances.get(i) - value);
                }
            }
        }

        System.out.println(sumRemovedElements);
    }
}
