import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class ComicBook implements Serializable {
    //Scanner scannerComicBook = new Scanner(System.in);
    private String name;
    private String author;
    private String publisher;
    private int numberOfPages;
    private String genre;
    private int yearOfPublishing;
    private double purchasePrice;
    private double salePrice;
    private int discount;
    private boolean sequel;
    private String saveFor;
    private int quantity;

    LocalDate dateOfEntering;


    public ComicBook(){

    }
    public ComicBook(String name, String author, String publisher, int numberOfPages, String genre, int yearOfPublishing, double purchasePrice, double salePrice, int discount, boolean sequel,String saveFor, int quantity) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.yearOfPublishing = yearOfPublishing;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.discount = discount;
        this.sequel = sequel;
        this.saveFor = saveFor;
        this.quantity = quantity;

        this.dateOfEntering = LocalDate.now();


    }

    public LocalDate getDateOfEntering(){ return dateOfEntering;}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }
    public int getDiscount() {
        return discount;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isSequel() {
        return sequel;
    }

    public void setSequel(boolean sequel) {
        this.sequel = sequel;
    }

    public void setQuantity(int quantity){this.quantity = quantity; }
    public void setSaveFor(String saveFor){this.saveFor = saveFor; }

    public int getQuantity(){ return this.quantity; }
    public String getSaveFor(){ return this.saveFor; }



    @Override
    public String toString() {
        return "ComicBook{" +
                "Name =' " + name + '\'' +
                ", Author =' " + author + '\'' +
                ", Publisher =' " + publisher + '\'' +
                ", number Of Pages = " + numberOfPages +
                ", genre =' " + genre + '\'' +
                ", year Of Publishing = " + yearOfPublishing +
                ", purchase Price = " + purchasePrice +
                ", sale Price = " + salePrice +
                ", discount = " + discount +
                ", sequel = " + sequel +
                ", saved for customer = " + saveFor +
                ", quantity = " + quantity +
                ", Date of entering = " + dateOfEntering +
                '}';
    }
}
