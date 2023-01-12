import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerMain = new Scanner(System.in);
        int menuCode;

        System.out.println("Welcome to Comic Shop!");
        LocalDate date = LocalDate.now();
        System.out.println(date);

        UsersDatabase localUsers = new UsersDatabase("userDatabase.bin");  //обьект класса UserDatabase для рабрты с пользователями.
        ComicBookDatabase workCBDatabase = new ComicBookDatabase("comicBookDatabase.bin");
        SoldDatabase soldCBDatabase = new SoldDatabase("soldComicBookDatabase.bin");


        if(localUsers.getUsers().isEmpty()){
            System.out.println("First entry to the program. Add a User:");
            System.out.println("Add User's USERNAME:");
            String username = scannerMain.next();
            System.out.println("Add User's PASSWORD:");
            String password = scannerMain.next();
            if(localUsers.addUser(username, password)){
                System.out.printf("User %s added to the system.", username);
            }
            else {
                System.out.println("Something went wrong. ");
            }
        }

// User Login
        User currentUser = localUsers.userLogin();
        if(currentUser == null){
            System.out.println("Enter 1 to try again or enter 0 to exit.");
            int tryAgain = scannerMain.nextInt();
            if(tryAgain == 1){
                currentUser = localUsers.userLogin();
            }

        }

// Start menu for User

        int whileChoice = 1;
        while(whileChoice == 1){
            System.out.println("User's Menu (" + currentUser.getUsername()+"):");
            currentUser.run(workCBDatabase, localUsers, soldCBDatabase);  // Run user's menu
            System.out.println("\nTo Exit  - enter 0");
            System.out.println("To continue - enter 1");
            whileChoice = scannerMain.nextInt();
            if(whileChoice !=1 && whileChoice !=0){
                System.out.println("Wrong number. Enter 1 to Continue, or 0 to Exit: ");
                whileChoice = scannerMain.nextInt();
            }
            if(whileChoice !=1 && whileChoice !=0){
                System.out.println("Wrong number. Exiting from the program. ");
                whileChoice = 0;
            }

        }
        System.out.println("Saving data");
        localUsers.saveLocalUsers();
        workCBDatabase.saveComicBookDatabase();
        soldCBDatabase.saveSoldComicBookDatabase();
        System.out.println("Data is saved.");
    }

    public static UsersDatabase firstLogin(){
        UsersDatabase firstUsers = new UsersDatabase();
        return firstUsers;
    }


}