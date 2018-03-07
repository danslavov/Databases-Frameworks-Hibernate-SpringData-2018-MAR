package T03_OOPOverview.P08_BookLibrary;

import java.time.LocalDate;

public class Book {

    private String title;
    private String author;
    private String publisher;
    private String releaseDate;
    private String ISBN;
    private double price;

    public Book(String title, String author, String publisher,
                String releaseDate, String ISBN, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublisher(publisher);
        this.setReleaseDate(releaseDate);
        this.setISBN(ISBN);
        this.setPrice(price);
    }

    public double getPrice() {
        return this.price;
    }

    public String getAuthor() {
        return this.author;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    private void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    private void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    private void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    private void setPrice(double price) {
        this.price = price;
    }
}
