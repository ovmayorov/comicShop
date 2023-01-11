import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class User implements Serializable {
    private String username;
    private String password;
    private boolean manager;

    public User(){

    }
//    public User(String username, String password, boolean manager) {
//        this.username = username;
//        this.password = password;
//        this.manager = manager;
//    }
public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (manager != user.manager) return false;
        if (!Objects.equals(username, user.username)) return false;
        return Objects.equals(password, user.password);
    }

    public void run(ComicBookDatabase CBDatabase, UsersDatabase localUsers, SoldDatabase CBSoldDatabase ){
        Scanner runScanner = new Scanner(System.in);
        System.out.println("To ADD comic book           - enter 1 ");
        System.out.println("To REMOVE comic book record - enter 2 ");
        System.out.println("To EDIT comic book          - enter 3 ");
        System.out.println("To SELL comic book          - enter 4 ");
        System.out.println("To ADD to DISCOUNT          - enter 5 ");
        System.out.println("To SAVE comic book          - enter 6 ");
        System.out.println("To WRITE-OFF comic book     - enter 7 ");
        System.out.println("To Print ALL comic books    - enter 8 ");
        System.out.println("To SEARCH comic books       - enter 9 ");
        System.out.println("To SHOW NEW arrivals        - enter 10");
        System.out.println("To SHOW Popular             - enter 11");
        System.out.println();
        System.out.println("To ADD a new USER           - enter 20");
        System.out.println("To LOG OFF                  - enter 00");
        int runMenuChoice = runScanner.nextInt();
        runScanner.nextLine();
        switch (runMenuChoice){
            case 1:
                CBDatabase.addComicBook();
                break;
            case 2:
                for (int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    System.out.println(CBDatabase.getCBDatabase().get(i));
                }
                System.out.println("Search comic book by name or part of the name: ");
                String searchComicBookName = runScanner.nextLine();
                for(int i=0; i< CBDatabase.getCBDatabase().size(); i++){
                    if(CBDatabase.getCBDatabase().get(i).getName().toLowerCase().contains(searchComicBookName.toLowerCase())){
                        System.out.println(CBDatabase.getCBDatabase().get(i));
                    }
                }

                System.out.println("To Remove comic book record, enter comic book Name or part of the name:");
                String nameToRemove = runScanner.nextLine();
                for(int i=0; i< CBDatabase.getCBDatabase().size(); i++){
                    if(CBDatabase.getCBDatabase().get(i).getName().equals(nameToRemove)){
                        CBDatabase.getCBDatabase().remove(i);
                    }
                }
                break;
            case 3:
                for (int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    System.out.println(CBDatabase.getCBDatabase().get(i));
                }
                System.out.println("Search comic book by name or part of the name: ");
                searchComicBookName = runScanner.nextLine();
                for(int i=0; i< CBDatabase.getCBDatabase().size(); i++){
                    if(CBDatabase.getCBDatabase().get(i).getName().toLowerCase().contains(searchComicBookName.toLowerCase())){
                        System.out.println(CBDatabase.getCBDatabase().get(i));
                    }
                }

                System.out.println("Enter the name of the Comic Book you want to edit:");
                String editComicBookName = runScanner.nextLine();
                //int indexOfComicBook;
                for(int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    if(CBDatabase.getCBDatabase().get(i).getName().equals(editComicBookName)){
                        CBDatabase.editComicBook(CBDatabase.getCBDatabase().get(i));
                        System.out.println(CBDatabase.getCBDatabase().get(i));
                    }
                }
                break;

            case 4:
                for (int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    System.out.println(CBDatabase.getCBDatabase().get(i));
                }
                System.out.println("Search comic book by name or part of the name: ");
                searchComicBookName = runScanner.nextLine();
                for(int i=0; i< CBDatabase.getCBDatabase().size(); i++){
                    if(CBDatabase.getCBDatabase().get(i).getName().toLowerCase().contains(searchComicBookName.toLowerCase())){
                        System.out.println(CBDatabase.getCBDatabase().get(i));
                    }
                }

                System.out.println("Enter the name of the Comic Book to sell: ");
                String sellComicBookName = runScanner.nextLine();
                for(int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    if(CBDatabase.getCBDatabase().get(i).getName().equals(sellComicBookName)){
                        if(CBDatabase.getCBDatabase().get(i).getQuantity() < 1){
                            System.out.println("Comic Book name: " + sellComicBookName + " is SOLD OUT." );
                        }
                        else if(CBDatabase.getCBDatabase().get(i).getQuantity() > 0){
                            System.out.println(CBDatabase.getCBDatabase().get(i).getQuantity() + " is available for " +
                                    "Comic Book name: "+sellComicBookName);
                            System.out.println("How many to sell? \nEnter number : ");
                            int sellQuantity = runScanner.nextInt();
                            runScanner.nextLine();
                            CBDatabase.getCBDatabase().get(i).setQuantity(CBDatabase.getCBDatabase().get(i).getQuantity()-sellQuantity);
                            SoldComicBook newSold = new SoldComicBook();
                            //newSold = CBDatabase.getCBDatabase().get(i);
                            newSold.setName(CBDatabase.getCBDatabase().get(i).getName());
                            newSold.setAuthor(CBDatabase.getCBDatabase().get(i).getAuthor());
                            newSold.setGenre(CBDatabase.getCBDatabase().get(i).getGenre());
                            newSold.setPurchasePrice(CBDatabase.getCBDatabase().get(i).getPurchasePrice());
                            newSold.setSalePrice(CBDatabase.getCBDatabase().get(i).getSalePrice());
                            newSold.setSoldQuantity(sellQuantity);

                            CBSoldDatabase.addSoldComicBook(newSold);
                            System.out.println(newSold);

                        }
                        //CBDatabase.editComicBook(CBDatabase.getCBDatabase().get(i));
                        System.out.println(CBDatabase.getCBDatabase().get(i));
                    }
                }
                break;
            case 5:
                for (int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    System.out.println(CBDatabase.getCBDatabase().get(i));
                }
                System.out.println("Search comic book by name or part of the name: ");
                searchComicBookName = runScanner.nextLine();
                for(int i=0; i< CBDatabase.getCBDatabase().size(); i++){
                    if(CBDatabase.getCBDatabase().get(i).getName().toLowerCase().contains(searchComicBookName.toLowerCase())){
                        System.out.println(CBDatabase.getCBDatabase().get(i));
                    }
                }

                System.out.println("Enter the name of the Comic Book you want to add to discount sale:");
                String discountComicBookName = runScanner.nextLine();
                //int indexOfComicBook;
                for(int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    if(CBDatabase.getCBDatabase().get(i).getName().equals(discountComicBookName)){
                        CBDatabase.addToDiscountComicBook(CBDatabase.getCBDatabase().get(i));
                        System.out.println(CBDatabase.getCBDatabase().get(i));
                    }
                }
                break;
            case 6:
                for (int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    System.out.println(CBDatabase.getCBDatabase().get(i));
                }
                System.out.println("Search comic book by name or part of the name: ");
                searchComicBookName = runScanner.nextLine();
                for(int i=0; i< CBDatabase.getCBDatabase().size(); i++){
                    if(CBDatabase.getCBDatabase().get(i).getName().toLowerCase().contains(searchComicBookName.toLowerCase())){
                        System.out.println(CBDatabase.getCBDatabase().get(i));
                    }
                }

                System.out.println("Saving comic book for customer: ");
                String saveComicBookName = runScanner.nextLine();
                //int indexOfComicBook;
                for(int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    if(CBDatabase.getCBDatabase().get(i).getName().equals(saveComicBookName)){
                        CBDatabase.saveForCustomer(CBDatabase.getCBDatabase().get(i));
                        System.out.println(CBDatabase.getCBDatabase().get(i));
                    }
                }
                break;
            case 7:
                for (int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    System.out.println(CBDatabase.getCBDatabase().get(i));
                }
                System.out.println("Search comic book by name or part of the name: ");
                searchComicBookName = runScanner.nextLine();
                for(int i=0; i< CBDatabase.getCBDatabase().size(); i++){
                    if(CBDatabase.getCBDatabase().get(i).getName().toLowerCase().contains(searchComicBookName.toLowerCase())){
                        System.out.println(CBDatabase.getCBDatabase().get(i));
                    }
                }

                System.out.println("Writing-Off the Comic Book - inventory becomes obsolete, spoils, becomes damaged, or is stolen or lost." +
                        "\n Remove from inventory with Sold Price = 0.");
                for (int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    System.out.println(CBDatabase.getCBDatabase().get(i));
                }
                System.out.println("Enter the name of the Comic Book to Write-Off: ");
                sellComicBookName = runScanner.nextLine();
                for(int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    if(CBDatabase.getCBDatabase().get(i).getName().equals(sellComicBookName)){
                        if(CBDatabase.getCBDatabase().get(i).getQuantity() < 1){
                            System.out.println("No Comic Book name: " + sellComicBookName + " in stock." );
                        }
                        else if(CBDatabase.getCBDatabase().get(i).getQuantity() > 0){
                            System.out.println(CBDatabase.getCBDatabase().get(i).getQuantity() + " is available for " +
                                    "Comic Book name: "+sellComicBookName);
                            System.out.println("How many to Write-Off? \nEnter number : ");
                            int sellQuantity = runScanner.nextInt();
                            runScanner.nextLine();
                            CBDatabase.getCBDatabase().get(i).setQuantity(CBDatabase.getCBDatabase().get(i).getQuantity()-sellQuantity);
                            SoldComicBook newSold = new SoldComicBook();
                            newSold.setName(CBDatabase.getCBDatabase().get(i).getName());
                            newSold.setAuthor(CBDatabase.getCBDatabase().get(i).getAuthor());
                            newSold.setGenre(CBDatabase.getCBDatabase().get(i).getGenre());
                            newSold.setPurchasePrice(CBDatabase.getCBDatabase().get(i).getPurchasePrice());
                            newSold.setSalePrice(0);
                            newSold.setSoldQuantity(sellQuantity);

                            CBSoldDatabase.addSoldComicBook(newSold);
                            System.out.println(newSold);

                        }

                        System.out.println(CBDatabase.getCBDatabase().get(i));
                    }
                }
                break;
            case 8:
                for (int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    System.out.println(CBDatabase.getCBDatabase().get(i));
                }
                break;
    ///////////////////////////
            case 9:
                for (int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    System.out.println(CBDatabase.getCBDatabase().get(i));
                }
                System.out.println("Te Search by Name    - enter 1");
                System.out.println("Te Search by Author  - enter 2");
                System.out.println("Te Search by Genre   - enter 3");
                int choice = runScanner.nextInt();
                runScanner.nextLine();
                if(choice == 1) {
                    System.out.println("Search comic book by name or part of the name: ");
                    searchComicBookName = runScanner.nextLine();
                    for (int i = 0; i < CBDatabase.getCBDatabase().size(); i++) {
                        if (CBDatabase.getCBDatabase().get(i).getName().toLowerCase().contains(searchComicBookName.toLowerCase())) {
                            System.out.println(CBDatabase.getCBDatabase().get(i));
                        }
                    }
                }
                else if(choice == 2){
                    System.out.println("Search comic book by Author : ");
                    searchComicBookName = runScanner.nextLine();
                    for (int i = 0; i < CBDatabase.getCBDatabase().size(); i++) {
                        if (CBDatabase.getCBDatabase().get(i).getAuthor().toLowerCase().contains(searchComicBookName.toLowerCase())) {
                            System.out.println(CBDatabase.getCBDatabase().get(i));
                        }
                    }
                }
                else {
                    System.out.println("Search comic book by Genre : ");
                    searchComicBookName = runScanner.nextLine();
                    for (int i = 0; i < CBDatabase.getCBDatabase().size(); i++) {
                        if (CBDatabase.getCBDatabase().get(i).getGenre().toLowerCase().contains(searchComicBookName.toLowerCase())) {
                            System.out.println(CBDatabase.getCBDatabase().get(i));
                        }
                    }
                }

                break;
            case 10:
                System.out.println("New arrivals, yesterday and today: "); //show new arrivals yesterday and today
                for (int i=0; i < CBDatabase.getCBDatabase().size(); i++){
                    LocalDate today = LocalDate.now();
                    LocalDate yesterday = today.minusDays(1);
                    if(CBDatabase.getCBDatabase().get(i).getDateOfEntering().equals(today) ||
                            CBDatabase.getCBDatabase().get(i).getDateOfEntering().equals(yesterday) ) {
                        System.out.println(CBDatabase.getCBDatabase().get(i));
                    }
                }
                break;
            case 11:
                //To SHOW Popular
                //popular by day, week, month, year
                //popular Author by day, week, month, year
                //popular Genre  by day, week, month, year
                CBSoldDatabase.popular();

//                Popular baza = new Popular(CBSoldDatabase);
//                baza.sort();
                break;

            case 20:
                System.out.println("Add a User.");
                System.out.println("Add User's USERNAME:");
                String username = runScanner.next();
                System.out.println("Add User's PASSWORD:");
                String password = runScanner.next();
                if(localUsers.addUser(username, password)){
                    System.out.printf("User %s added to the system.", username);
                }
                else {
                    System.out.println("Something went wrong. ");
                }
                break;

            case 00:
                break;
        }

    }

//    @Override
//    public int hashCode() {
//        int result = username != null ? username.hashCode() : 0;
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (manager ? 1 : 0);
//        return result;
//    }
}
