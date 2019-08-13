import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;

public class _02_BookShop {
    public static void main(String[] args) throws IOException {
         try {
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             String author = reader.readLine();
             String title = reader.readLine();
             double price = Double.parseDouble(reader.readLine());

             Book book = new Book(author, title,price);
             GoldenEditionBook goldenEditionBook = new GoldenEditionBook(author, title, price);

             Method[] goldenBookDeclaredMethods = GoldenEditionBook.class.getDeclaredMethods();
             if (goldenBookDeclaredMethods.length > 1) {
                 throw new IllegalClassFormatException( "Code duplication in GoldenEditionBook!");
             }

             System.out.println(book.toString());
             System.out.println(goldenEditionBook.toString());
        } catch (IllegalArgumentException | IllegalClassFormatException error) {
             System.out.println(error.getMessage());
         }
    }

    static public class Book {
        protected String title;
        protected String author;
        protected Double price;

        public Book(String author, String title, Double price) throws IllegalClassFormatException {
            this.setTitle(title);
            this.setAuthor(author);
            this.setPrice(price);
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) throws IllegalClassFormatException {
            if (title.length() < 3) {
                throw new IllegalClassFormatException("Title not valid!");
            }
            this.title = title;
        }

        public String getAuthor() {
            return this.author;
        }

        public void setAuthor(String author) throws IllegalClassFormatException {
            if (author.split(" ").length > 1 && Character.isDigit(author.split(" ")[1].charAt(0))) {
                throw new IllegalClassFormatException("Author not valid!");
            }
            this.author = author;
        }

        public double getPrice() {
            return this.price;
        }

        public void setPrice(Double price) throws IllegalClassFormatException {
            if (price <= 0) {
                throw new IllegalClassFormatException("Price not valid!");
            }
            this.price = price;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Type: ").append(this.getClass().getSimpleName())
                    .append(System.lineSeparator())
                    .append("Title: ").append(this.getTitle())
                    .append(System.lineSeparator())
                    .append("Author: ").append(this.getAuthor())
                    .append(System.lineSeparator())
                    .append("Price: ").append(this.getPrice())
                    .append(System.lineSeparator());
            return sb.toString();
        }
    }

    static public class GoldenEditionBook extends Book {

        public GoldenEditionBook(String author, String title, Double price) throws IllegalClassFormatException {
            super(author, title, price);
        }

        @Override
        public double getPrice() {
            return super.getPrice() + super.getPrice() * 0.3;
        }
    }
}
