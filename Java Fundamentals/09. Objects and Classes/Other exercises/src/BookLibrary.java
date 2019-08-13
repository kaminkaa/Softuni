import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class BookLibrary {
    public static void main(String[] args) throws ParseException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Library library = new Library();
        library.name = "My library";
        library.books = new ArrayList<>();

        String[] input;
        String title, author, publisher;
        LocalDate releaseDate;
        int isbn;
        double price;

        for (int i = 0; i < n; i++) {
            input = reader.readLine().split("\\s+");

            title = input[0];
            author = input[1];
            publisher = input[2];
            releaseDate = (LocalDate.parse(input[3], DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            isbn = Integer.parseInt(input[4]);
            price = Double.parseDouble(input[5]);

            Book book = new Book(title, author, publisher, releaseDate, isbn, price);

            library.books.add(book);
        }

        Comparator<Map.Entry<String, List<Book>>> compareByTotalPrice
                = Comparator.comparing(kvp -> kvp.getValue().stream().map(Book::getPrice)
                    .mapToDouble(Double::valueOf).sum(),Comparator.reverseOrder());

        Comparator<Map.Entry<String, List<Book>>> compareByName
                = Comparator.comparing(Map.Entry::getKey);

        library.getBooks().stream()
                .collect(Collectors.groupingBy(Book::getAuthor))
                .entrySet()
                .stream()
                .sorted(compareByTotalPrice.thenComparing(compareByName))
                .forEach(kvp -> {
                    double totalPrice = kvp.getValue().stream()
                            .map(Book::getPrice)
                            .mapToDouble(Double::valueOf)
                            .sum();
                    System.out.printf("%s -> %.2f\n", kvp.getKey(),totalPrice);
                });
    }

    static class Book {
        public String title;
        public String author;
        public String publisher;
        public LocalDate releaseDate;
        public int isbn;
        public double price;

        public Book (String title, String author, String publisher, LocalDate releaseDate, int isbn, double price) {
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.releaseDate = releaseDate;
            this.isbn = isbn;
            this.price = price;
        }

        public String getTitle() { return title; }

        public String getAuthor () {
            return author;
        }

        public double getPrice() {
            return price;
        }

        public LocalDate getReleaseDate() { return releaseDate; }
    }

    static class Library {
        public String name;
        public List<Book> books;

        public List<Book> getBooks (){
            return books;
        }
    }
}
