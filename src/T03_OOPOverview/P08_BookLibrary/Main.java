package T03_OOPOverview.P08_BookLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        Library library = createLibrary();
//        Map<String, Double> authorsByPrice = groupByAuthor(library);
//        firstPrintResult(authorsByPrice);     // needs groupByAuthor()
//        secondPrintResult(authorsByPrice);    // needs groupByAuthor()
        thirdPrintResult(library);
    }

    private static Library createLibrary() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library("libra");
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            String title = line[0];
            String author = line[1];
            String publisher = line[2];
            String releaseDate = line[3];
            String ISBN = line[4];
            double price = Double.parseDouble(line[5]);
            Book book = new Book(title, author, publisher, releaseDate, ISBN, price);
            library.addBook(book);
        }
        return library;
    }

    private static Map<String, Double> groupByAuthor(Library library) {
        Map<String, Double> authorsByPrice = new HashMap<>();
        for (Book b : library.getBooks()) {
            String author = b.getAuthor();
            double price = b.getPrice();
            if (!authorsByPrice.keySet().contains(author)) {
                authorsByPrice.put(author, 0.0);
            }
            authorsByPrice.put(author, authorsByPrice.get(author) + price);
        }
        return authorsByPrice;
    }

    private static void firstPrintResult(Map<String, Double> authorsByPrice) {
        authorsByPrice.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String, Double>::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));
    }

    private static void secondPrintResult(Map<String, Double> authorsByPrice) {
        authorsByPrice.entrySet().stream()
                .sorted((e1, e2) -> {
                    if (e1.getValue().equals(e2.getValue())) {
                        return e1.getKey().compareTo(e2.getKey());
                    } else {
                        return Double.compare(e2.getValue(), e1.getValue());
                    }
                })
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));
    }

    private static void thirdPrintResult(Library library) {
        library.getBooks().stream()
                .collect(Collectors.groupingBy(
                        Book::getAuthor, Collectors.summingDouble(Book::getPrice)
                )).entrySet().stream()
                .sorted((e1, e2) -> {
                    if (e1.getValue().equals(e2.getValue())) {
                        return e1.getKey().compareTo(e2.getKey());
                    } else {
                        return Double.compare(e2.getValue(), e1.getValue());
                    }
                })
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));
    }
}