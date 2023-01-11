import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerMain = new Scanner(System.in);
        int menuCode;

        System.out.println("Welcome to Comic Shop!");
        LocalDate date = LocalDate.now();
        System.out.println(date);
//        System.out.println(date.getYear());
//        System.out.println(date.getMonth());
//        System.out.println(date.getMonthValue());
//        System.out.println(date.getDayOfMonth());


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
        //User currentUser = login(localUsers);   // Создаем текущего пользователя, чтобы знать кто работает сейчас в программе.
                                                //вызвыватеся метод login который осуществляет аутентификацию, вызывая методы класса UserDatabase
        User currentUser = localUsers.userLogin();
        if(currentUser == null){
            System.out.println("Enter 1 to try again or enter 0 to exit.");
            int tryAgain = scannerMain.nextInt();
            if(tryAgain == 1){
                currentUser = localUsers.userLogin();
            }

        }

//        User currentUser = new User();
//        systemLogin(currentUser, localUsers);
//        System.out.println("Current user: " + currentUser.getUsername());

        int whileChoice = 1;
        while(whileChoice == 1){
            System.out.println("User's Menu (" + currentUser.getUsername()+"):");
            currentUser.run(workCBDatabase, localUsers, soldCBDatabase);  // Run user's menu
            System.out.println("\nTo Exit  - enter 0");
            System.out.println("To continue - enter 1");
            whileChoice = scannerMain.nextInt();


        }
        System.out.println("Saving data");
        localUsers.saveLocalUsers();
        workCBDatabase.saveComicBookDatabase();
        soldCBDatabase.saveSoldComicBookDatabase();
        System.out.println("Data is saved.");

        //////////////////
        // Сохранить данные на данномы этапе
        // Предложить опять залогиниться или выйти из программы ??


//        if(currentUser.isManager()){
//            //managerUser();
//        }

 //       workCBDatabase.addComicBook();
        //System.out.println("To ADD comic Book - enter 1");
//        System.out.println("To Exit from application and save data - enter 0");
//
//        menuCode = scannerMain.nextInt();   //menuCode - код меню которое выбирает пользователь для дальнейших действий.
//        if(menuCode == 0){
//            System.out.println("Saving data");
//            localUsers.saveLocalUsers();
//            workCBDatabase.saveComicBookDatabase();
//            System.out.println("Data is saved.");
//        }
//        else{
//            System.out.println("Data is not saved.");
//        }



    }
//////////////////////
    public static UsersDatabase firstLogin(){
        UsersDatabase firstUsers = new UsersDatabase();

        return firstUsers;
    }

//    public static void systemLogin(User currentUser, UsersDatabase localUsers ){
//        currentUser = localUsers.userLogin();
//        if(currentUser == null){
//            int localCounter = 2;
//            while(localCounter > 0){
//                System.out.println("Try again");
//                currentUser = localUsers.userLogin();
//                if(currentUser != null) break;
//            }
//        }
//    }
///////////////////////////
//    public static User login(UsersDatabase users ){
//        Scanner scannerLogin = new Scanner(System.in);
//        User user = new User();
//
////        if(users.getUsers().isEmpty()){
////            System.out.println("First entry to the program. Add a Manager:");
////            System.out.println("Add MANAGER's USERNAME:");
////            String managerUsername = scannerLogin.next();
////            System.out.println("Add MANAGER's PASSWORD:");
////            String managerPassword = scannerLogin.next();
////            if(users.addManager(managerUsername, managerPassword)){
////                System.out.println("System has a manager now.");
////                user = users.getUsers().get(0);
////                return user;
////            }
////            else {
////                System.out.println("Something went wrong. Restart the program.");
////                return user;
////            }
////
////        }
//
//        System.out.println("Login to the system:");
//        System.out.println("Enter username: ");
//        String currentUsername = scannerLogin.next();
//        System.out.println("Enter password: ");
//        String currentPassword = scannerLogin.next();
//        User temp = new User(currentUsername, currentPassword);
//        if((users.userLogin(temp))!=null){
//            return temp;
//        }
//
//        return null;
//
//    }

//    public static void managerUser(){
//        Scanner scannerManager = new Scanner(System.in);
//        int menuManager;
//        System.out.println("To remove Comic Book - enter 1");
//        System.out.println("To add new User - enter 9");
//        System.out.println("To Log OFF - enter 10:");
//
//        menuManager = scannerManager.nextInt();
//        scannerManager.nextLine();
//        if(menuManager == 9){
//            System.out.println("Enter username: ");
//            String currentUsername = scannerManager.next();
//            System.out.println("Enter password: ");
//            String currentPassword = scannerManager.next();
//            if(users.addManager(managerUsername, managerPassword)){
//                System.out.println("System has a manager now.");
//        }
//        else if(menuManager == 10){
//            System.out.println("Exit.");
//            return;
//        }
//      }
//    }
}