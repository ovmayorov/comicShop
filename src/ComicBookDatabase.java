import java.io.*;
import java.util.*;
import java.util.Scanner;


public class ComicBookDatabase {

    Scanner bookScanner = new Scanner(System.in);
    private String CBDataFileName;
    private List<ComicBook> CBDatabase = new ArrayList<>();

    public ComicBookDatabase(String CBDataFileName){
        this.CBDataFileName = CBDataFileName;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(CBDataFileName))){
            List<ComicBook> newComicBookList = (List<ComicBook>)objectInputStream.readObject();
            setCBDatabase(newComicBookList);
        }
        catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void saveComicBookDatabase(){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.CBDataFileName))){
            objectOutputStream.writeObject(this.CBDatabase);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void addComicBook(){

        System.out.println("Enter the Name of the Comic Book: ");
        String name = bookScanner.nextLine();
        System.out.println("Enter the Name of the Author/Artist: ");
        String author = bookScanner.nextLine();
        System.out.println("Enter the Name of the Publisher: ");
        String publisher = bookScanner.nextLine();
        System.out.println("Enter the Number of Pages in the Comic Book: ");
        int numberOfPages = bookScanner.nextInt();
        bookScanner.nextLine();
        System.out.println("Enter the Genre of the Comic Book: ");
        String genre = bookScanner.nextLine();
        System.out.println("Enter the Year of Publishing: ");
        int yearOfPublishing = bookScanner.nextInt();
        bookScanner.nextLine();
        System.out.println("Enter the Purchase Price: ");
        double purchasePrice = bookScanner.nextDouble();
        bookScanner.nextLine();
        System.out.println("Enter the Sale Price: ");
        double salePrice = bookScanner.nextDouble();
        bookScanner.nextLine();
        //System.out.println("Enter the Discount % : ");
        //int discount = bookScanner.nextInt();
        int discount = 0;

        System.out.println("Is this Comic Book a Sequel ( 1 for YES / 0 for NO ): ");
        boolean sequel;
        int isSequel = bookScanner.nextInt();
        bookScanner.nextLine();
        if(isSequel == 1) sequel = true;
        else sequel = false;
        String saveFor = "";
        System.out.println("Enter quantity: ");
        int quantity = bookScanner.nextInt();
        bookScanner.nextLine();

        this.CBDatabase.add(new ComicBook(name,
                author,
                publisher,
                numberOfPages,
                genre,
                yearOfPublishing,
                purchasePrice,
                salePrice,
                discount,
                sequel,
                saveFor,
                quantity) );

    }

    public String getCBDataFileName() {
        return CBDataFileName;
    }

    public void setCBDataFileName(String CBDataFileName) {
        this.CBDataFileName = CBDataFileName;
    }

    public List<ComicBook> getCBDatabase() {
        return CBDatabase;
    }

    public void setCBDatabase(List<ComicBook> CBDatabase) {
        this.CBDatabase = CBDatabase;
    }

    public void editComicBook(ComicBook editBook){
        System.out.println("To enter new Name               - enter 1");
        System.out.println("To enter new Author             - enter 2");
        System.out.println("To enter new Publisher          - enter 3");
        System.out.println("To enter new Number of Pages    - enter 4");
        System.out.println("To enter new Genre              - enter 5");
        System.out.println("To enter new Year Of Publishing - enter 6");
        System.out.println("To enter new Purchase Price     - enter 7");
        System.out.println("To enter new Sale Price         - enter 8");
        System.out.println("To enter Sequel or not          - enter 9");
        System.out.println("To enter Save fo Customer info  - enter 10");
        System.out.println("To enter new Quantity           - enter 11");


        int choiceEditComicBook = bookScanner.nextInt();
        bookScanner.nextLine();
        int choiceFlag = 0;
        switch (choiceEditComicBook) {


            case 1:
                System.out.println("Enter new name:");
                String newName = bookScanner.nextLine();
                editBook.setName(newName);
                System.out.println("Continue? enter - 1 ");
                choiceFlag = bookScanner.nextInt();
                bookScanner.nextLine();
                if(choiceFlag != 1) break;
            case 2:
                System.out.println("Enter new Author: ");
                String newAuthor = bookScanner.nextLine();
                editBook.setAuthor(newAuthor);
                System.out.println("Continue? enter - 1 ");
                choiceFlag = bookScanner.nextInt();
                bookScanner.nextLine();
                if(choiceFlag != 1) break;
            case 3:
                System.out.println("Enter new Publisher: ");
                String newPublisher = bookScanner.nextLine();
                editBook.setPublisher(newPublisher);
                System.out.println("Continue? enter - 1 ");
                choiceFlag = bookScanner.nextInt();
                bookScanner.nextLine();
                if(choiceFlag != 1) break;
            case 4:
                System.out.println("Enter new Number of Pages: ");
                int newNumberOfPages = bookScanner.nextInt();
                editBook.setNumberOfPages(newNumberOfPages);
                bookScanner.nextLine();
                System.out.println("Continue? enter - 1 ");
                choiceFlag = bookScanner.nextInt();
                bookScanner.nextLine();
                if(choiceFlag != 1) break;
            case 5:
                System.out.println("Enter new Genre: ");
                String newGenre = bookScanner.nextLine();
                editBook.setGenre(newGenre);
                System.out.println("Continue? enter - 1 ");
                choiceFlag = bookScanner.nextInt();
                bookScanner.nextLine();
                if(choiceFlag != 1) break;
            case 6:
                System.out.println("Enter new Year Of Publishing: ");
                int newYearOfPublishing = bookScanner.nextInt();
                editBook.setYearOfPublishing(newYearOfPublishing);
                bookScanner.nextLine();
                System.out.println("Continue? enter - 1 ");
                choiceFlag = bookScanner.nextInt();
                bookScanner.nextLine();
                if(choiceFlag != 1) break;
            case 7:
                System.out.println("Enter new Purchase Price: ");
                double newPurchasePrice = bookScanner.nextDouble();
                editBook.setPurchasePrice(newPurchasePrice);
                bookScanner.nextLine();
                System.out.println("Continue? enter - 1 ");
                choiceFlag = bookScanner.nextInt();
                bookScanner.nextLine();
                if(choiceFlag != 1) break;
            case 8:
                System.out.println("Enter new Sale Price: ");
                double newSalePrice = bookScanner.nextDouble();
                editBook.setSalePrice(newSalePrice);
                bookScanner.nextLine();
                System.out.println("Continue? enter - 1 ");
                choiceFlag = bookScanner.nextInt();
                bookScanner.nextLine();
                if(choiceFlag != 1) break;
            case 9:
                System.out.println("Is this Comic Book a Sequel ( 1 for YES / 0 for NO ): ");
                int newSequelChoice = bookScanner.nextInt();
                boolean newSequel = false;
                if(newSequelChoice == 1) newSequel = true;
                else newSequel = false;
                editBook.setSequel(newSequel);
                bookScanner.nextLine();
                System.out.println("Continue? enter - 1 ");
                choiceFlag = bookScanner.nextInt();
                bookScanner.nextLine();
                if(choiceFlag != 1) break;

            case 10:
                saveForCustomer(editBook);
                if(choiceFlag != 1) break;
            case 11:
                System.out.println("Enter new Quantity: ");
                int newQuantity = bookScanner.nextInt();
                editBook.setQuantity(newQuantity);
                bookScanner.nextLine();
                break;
            default:
                System.out.println("Incorrect code.");
                break;
        }
    }

    public void addToDiscountComicBook(ComicBook editBook){
        System.out.println("Enter Discount % : ");
        int discount = bookScanner.nextInt();
        bookScanner.nextLine();
        editBook.setDiscount(discount);

        double newSalePrice = editBook.getSalePrice() - editBook.getSalePrice()/100*discount;
        editBook.setSalePrice(newSalePrice);

    }

    public void saveForCustomer(ComicBook editBook){

        System.out.println("How many books to save? :");
        int saveBookNumber = bookScanner.nextInt();
        bookScanner.nextLine();
        editBook.setQuantity(editBook.getQuantity() - saveBookNumber);
        System.out.println("Enter the customer name: ");
        String forCustomer = bookScanner.nextLine();
        editBook.setSaveFor(saveBookNumber + " for "+ forCustomer);
    }

}
