import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SoldDatabase {

    private String CBSoldDataFileName;
    private List<SoldComicBook> CBSoldDatabase = new ArrayList<>();

    public SoldDatabase(String CBSoldDataFileName){
        this.CBSoldDataFileName = CBSoldDataFileName;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(CBSoldDataFileName))){
            List<SoldComicBook> newSoldComicBookList = (List<SoldComicBook>)objectInputStream.readObject();
            setCBSoldDatabase(newSoldComicBookList);
        }
        catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void saveSoldComicBookDatabase(){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.CBSoldDataFileName))){
            objectOutputStream.writeObject(this.CBSoldDatabase);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public String getCBSoldDataFileName() {
        return CBSoldDataFileName;
    }

    public void setCBSoldDataFileName(String CBSoldDataFileName) {
        this.CBSoldDataFileName = CBSoldDataFileName;
    }

    public List<SoldComicBook> getCBSoldDatabase() {
        return CBSoldDatabase;
    }

    public void setCBSoldDatabase(List<SoldComicBook> CBSoldDatabase) {
        this.CBSoldDatabase = CBSoldDatabase;
    }

    public void addSoldComicBook(SoldComicBook newSold){
        this.CBSoldDatabase.add(newSold);
    }
}
