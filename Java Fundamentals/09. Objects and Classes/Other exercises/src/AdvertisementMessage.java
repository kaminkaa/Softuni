import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());

        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.",
                "I can’t live without this product."};

        String[] events = {"Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!"};

        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        int phrasesIndex, eventsIndex,authorsIndex, citiesIndex;

        for (int i = 0; i < number; i++) {
            phrasesIndex = new Random().nextInt(phrases.length);
            eventsIndex = new Random().nextInt(events.length);
            authorsIndex = new Random().nextInt(authors.length);
            citiesIndex = new Random().nextInt(cities.length);

            System.out.println(phrases[phrasesIndex] + " " +
                        events[eventsIndex] + " " + authors[authorsIndex] +
                        " - " + cities[citiesIndex]);
        }
    }
}
