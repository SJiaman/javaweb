package edu.gzu.lms.entity;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String publish;
    private String isbn;
    private String language;
    private double price;
    private String type;
    private int number;

    public Book() {
    }

    public Book(int bookId, String bookName, String author, String publish, String isbn, String language, double price, String type, int number) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publish = publish;
        this.isbn = isbn;
        this.language = language;
        this.price = price;
        this.type = type;
        this.number = number;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", isbn='" + isbn + '\'' +
                ", language='" + language + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", number=" + number +
                '}';
    }
}
