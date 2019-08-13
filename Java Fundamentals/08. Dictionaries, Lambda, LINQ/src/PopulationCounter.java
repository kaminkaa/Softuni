import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String,Integer>> populationStats = new LinkedHashMap<>();
        String[] input = console.nextLine().split("\\|");

        String city, country;
        int cityPopulation;

        while (!input[0].equals("report")){
            city = input[0];
            country = input[1];
            cityPopulation = Integer.parseInt(input[2]);

            populationStats.putIfAbsent(country, new LinkedHashMap<>());
            populationStats.get(country).put(city,cityPopulation);

            input = console.nextLine().split("\\|");
        }

        populationStats.entrySet().stream()
                .sorted(Comparator.comparing(a -> a.getValue().values().stream()
                                .mapToLong(Long::valueOf)
                                .sum(),
                        Comparator.reverseOrder()))

                .forEach(kvp -> {
                    long countryPopulation = kvp.getValue().values().stream()
                            .mapToLong(Long::valueOf)
                            .sum();
                    System.out.printf("%s (total population: %d)%n", kvp.getKey(),countryPopulation);

                    kvp.getValue().entrySet().stream()
                            .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                            .forEach(nestedKvp -> System.out.printf("=>%s: %d%n",nestedKvp.getKey(), nestedKvp.getValue()));
                });
    }
}
