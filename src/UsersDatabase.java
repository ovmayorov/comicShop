import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersDatabase {

    private String fileName;
    private List<User> users = new ArrayList<>();

    public UsersDatabase(){

    }
    public UsersDatabase(String fileName){
        this.fileName = fileName;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            List<User> savedUsers = (List<User>)objectInputStream.readObject();
            setUsers(savedUsers);
        }
        catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }



    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

//    public boolean addManager(String name, String password){
//        for(int i=0; i<users.size(); i++){
//            String tempName = users.get(i).getUsername();
//            String tempPassword = users.get(i).getPassword();
//            if(tempName.equals(name)){
//                System.out.println("Username is used, create a new Username.");
//                return false;
//            }
//
//        }
//        //users.add(new User(name, password, true));
//        users.add(new User(name, password));
//        return true;
//    }

    public boolean addUser(String name, String password){
        for(int i=0; i<users.size(); i++){
            String tempName = users.get(i).getUsername();
            //String tempPassword = users.get(i).getPassword();
            if(tempName.equals(name)){
                System.out.println("Username is used, create a new Username.");
                return false;
            }

        }
        //users.add(new User(name, password, false));
        users.add(new User(name, password));

        return true;
    }

//    public User userLogin(String username, String password){
//        for(int i=0; i<users.size(); i++){
//            if(users.get(i).getUsername().equals(username)){
//                if(users.get(i).getPassword().equals(password)){
//                    User currentUser = users.get(i);
//                    return currentUser;
//                }
//            }
//        }
//        return null;
//    }
    public User userLogin(){
        Scanner scannerLogin = new Scanner(System.in);
        System.out.println("Login to the system:");
        System.out.println("Enter username: ");
        String currentUsername = scannerLogin.next();
        System.out.println("Enter password: ");
        String currentPassword = scannerLogin.next();
        User temp = new User(currentUsername, currentPassword);
        for(int i=0; i<users.size(); i++){
            if(users.get(i).equals(temp)){
                return users.get(i);
            }
        }
        System.out.println("Username or password is incorrect.");

        return null;
    }


    public void saveLocalUsers(){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.fileName))){
            objectOutputStream.writeObject(this.users);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }


}
