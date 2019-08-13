import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class BookLibraryModification {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        BookLibrary.Library library = new BookLibrary.Library();
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

            BookLibrary.Book book = new BookLibrary.Book(title, author, publisher, releaseDate, isbn, price);

            library.books.add(book);
        }

        LocalDate dateToCompare = LocalDate.parse(reader.readLine(),DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        Comparator<BookLibrary.Book> compareByReleaseDate = Comparator.comparing(BookLibrary.Book::getReleaseDate);

        Comparator<BookLibrary.Book> compareByTitle = Comparator.comparing(BookLibrary.Book::getTitle);

        library.books.stream()
                .filter(book -> book.getReleaseDate().isAfter(dateToCompare))
                .sorted(compareByReleaseDate.thenComparing(compareByTitle))
                .forEach(book -> System.out.printf("%s -> %s\n",book.getTitle(), book.getReleaseDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
    }
}
