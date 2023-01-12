import java.io.*;
import java.time.LocalDate;
import java.util.*;

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

    public void popular(){

        List<SoldComicBook> dayBooks = getCBSoldDatabase().stream().filter( n -> n.getSellDate().equals(LocalDate.now())).toList() ;
        //проходимся по листу и загоняем все в MAP , ключ - название книги, параметр - количество продаж

        Map<String, Integer> soldByDay = new HashMap<>();
        for(int i=0; i<dayBooks.size(); i++){
            if(soldByDay.get(dayBooks.get(i).getName()) == null){
                //Book is not in the Map
                soldByDay.put(dayBooks.get(i).getName(),dayBooks.get(i).getSoldQuantity() );
            }

            else{
                int soldQuantityAlready = dayBooks.get(i).getSoldQuantity();
                soldByDay.put(dayBooks.get(i).getName(),soldQuantityAlready + dayBooks.get(i).getSoldQuantity() );
            }
        }

        int biggestSale = 0;
        String popularBook = null;
        for(Map.Entry<String, Integer> entry : soldByDay.entrySet()){
            if(entry.getValue() > biggestSale){
                biggestSale = entry.getValue();
                popularBook = entry.getKey();
            }
        }
        System.out.println("Most popular Comic Book of the Day: "+popularBook);
        System.out.println();

        biggestSale = 0;
        popularBook = null;
        LocalDate today = LocalDate.now();
        LocalDate week = today.minusWeeks(1);
                List<SoldComicBook> weekBooks = getCBSoldDatabase().stream()
                .filter( n -> n.getSellDate().isAfter(week)).toList();
        Map<String, Integer> soldByWeek = new HashMap<>();
        for(int i=0; i<weekBooks.size(); i++){
            if(soldByWeek.get(weekBooks.get(i).getName()) == null){
                //Book is not in the Map
                soldByWeek.put(weekBooks.get(i).getName(),weekBooks.get(i).getSoldQuantity() );
            }
            else{
                int soldQuantityAlready = weekBooks.get(i).getSoldQuantity();
                soldByWeek.put(weekBooks.get(i).getName(),soldQuantityAlready + weekBooks.get(i).getSoldQuantity() );
            }
        }
        for(Map.Entry<String, Integer> entry : soldByWeek.entrySet()){
            if(entry.getValue() > biggestSale){
                biggestSale = entry.getValue();
                popularBook = entry.getKey();
            }
        }
        System.out.println("Most popular Comic Book of the Week: "+popularBook);
        System.out.println();

        //Comic Book popular of the Month:
        biggestSale = 0;
        popularBook = null;
        LocalDate month = today.minusMonths(1);
        List<SoldComicBook> monthBooks = getCBSoldDatabase().stream()
                .filter( n -> n.getSellDate().isAfter(month)).toList();
        Map<String, Integer> soldByMonth = new HashMap<>();
        for(int i=0; i<monthBooks.size(); i++){
            if(soldByMonth.get(monthBooks.get(i).getName()) == null){
                //Book is not in the Map
                soldByMonth.put(monthBooks.get(i).getName(),monthBooks.get(i).getSoldQuantity() );
            }
            else{
                int soldQuantityAlready = monthBooks.get(i).getSoldQuantity();
                soldByMonth.put(monthBooks.get(i).getName(),soldQuantityAlready + monthBooks.get(i).getSoldQuantity() );
            }
        }
        for(Map.Entry<String, Integer> entry : soldByMonth.entrySet()){
            if(entry.getValue() > biggestSale){
                biggestSale = entry.getValue();
                popularBook = entry.getKey();
            }
        }
        System.out.println("Most popular Comic Book of the Month: "+popularBook);
        System.out.println();

        //Most popular Author of the Day:
        biggestSale = 0;
        popularBook = null;
        Map<String, Integer> soldByDayAuthors = new HashMap<>();
        for(int i=0; i<dayBooks.size(); i++){
            if(soldByDayAuthors.get(dayBooks.get(i).getAuthor()) == null){
                //Book is not in the Map
                soldByDayAuthors.put(dayBooks.get(i).getAuthor(),dayBooks.get(i).getSoldQuantity() );
            }
            else{
                int soldQuantityAlready = dayBooks.get(i).getSoldQuantity();
                soldByDayAuthors.put(dayBooks.get(i).getAuthor(),soldQuantityAlready + dayBooks.get(i).getSoldQuantity() );
            }
        }
        for(Map.Entry<String, Integer> entry : soldByDayAuthors.entrySet()){
            if(entry.getValue() > biggestSale){
                biggestSale = entry.getValue();
                popularBook = entry.getKey();
            }
        }
        System.out.println("Most popular Author of the Day: "+popularBook);
        System.out.println();

        //Most popular Author of the Week:
        biggestSale = 0;
        popularBook = null;
        Map<String, Integer> soldByWeekAuthors = new HashMap<>();
        for(int i=0; i<weekBooks.size(); i++){
            if(soldByWeekAuthors.get(weekBooks.get(i).getAuthor()) == null){
                //Book is not in the Map
                soldByWeekAuthors.put(weekBooks.get(i).getAuthor(),weekBooks.get(i).getSoldQuantity() );
            }
            else{
                int soldQuantityAlready = weekBooks.get(i).getSoldQuantity();
                soldByWeekAuthors.put(weekBooks.get(i).getAuthor(),soldQuantityAlready + weekBooks.get(i).getSoldQuantity() );
            }
        }
        for(Map.Entry<String, Integer> entry : soldByWeekAuthors.entrySet()){
            if(entry.getValue() > biggestSale){
                biggestSale = entry.getValue();
                popularBook = entry.getKey();
            }
        }
        System.out.println("Most popular Author of the Week: "+popularBook);
        System.out.println();

        //Most popular Author of the Month:
        biggestSale = 0;
        popularBook = null;
        Map<String, Integer> soldByMonthAuthors = new HashMap<>();
        for(int i=0; i<monthBooks.size(); i++){
            if(soldByMonthAuthors.get(monthBooks.get(i).getAuthor()) == null){
                //Book is not in the Map
                soldByMonthAuthors.put(monthBooks.get(i).getAuthor(),monthBooks.get(i).getSoldQuantity() );
            }
            else{
                int soldQuantityAlready = monthBooks.get(i).getSoldQuantity();
                soldByMonthAuthors.put(monthBooks.get(i).getAuthor(),soldQuantityAlready + monthBooks.get(i).getSoldQuantity() );
            }
        }
        for(Map.Entry<String, Integer> entry : soldByMonthAuthors.entrySet()){
            if(entry.getValue() > biggestSale){
                biggestSale = entry.getValue();
                popularBook = entry.getKey();
            }
        }
        System.out.println("Most popular Author of the Month: "+popularBook);
        System.out.println();

        //Most popular Genre of the Day:
        biggestSale = 0;
        popularBook = null;
        Map<String, Integer> soldByDayGenre = new HashMap<>();
        for(int i=0; i<dayBooks.size(); i++){
            if(soldByDayGenre.get(dayBooks.get(i).getGenre()) == null){
                //Book is not in the Map
                soldByDayGenre.put(dayBooks.get(i).getGenre(),dayBooks.get(i).getSoldQuantity() );
            }
            else{
                int soldQuantityAlready = dayBooks.get(i).getSoldQuantity();
                soldByDayGenre.put(dayBooks.get(i).getGenre(),soldQuantityAlready + dayBooks.get(i).getSoldQuantity() );
            }
        }
        for(Map.Entry<String, Integer> entry : soldByDayGenre.entrySet()){
            if(entry.getValue() > biggestSale){
                biggestSale = entry.getValue();
                popularBook = entry.getKey();
            }
        }
        System.out.println("Most popular Genre of the Day: "+popularBook);
        System.out.println();

        //Most popular Genre of the Week:
        biggestSale = 0;
        popularBook = null;
        Map<String, Integer> soldByWeekGenre = new HashMap<>();
        for(int i=0; i<weekBooks.size(); i++){
            if(soldByWeekGenre.get(weekBooks.get(i).getGenre()) == null){
                //Book is not in the Map
                soldByWeekGenre.put(weekBooks.get(i).getGenre(),weekBooks.get(i).getSoldQuantity() );
            }
            else{
                int soldQuantityAlready = weekBooks.get(i).getSoldQuantity();
                soldByWeekGenre.put(weekBooks.get(i).getGenre(),soldQuantityAlready + weekBooks.get(i).getSoldQuantity() );
            }
        }
        for(Map.Entry<String, Integer> entry : soldByWeekGenre.entrySet()){
            if(entry.getValue() > biggestSale){
                biggestSale = entry.getValue();
                popularBook = entry.getKey();
            }
        }
        System.out.println("Most popular Genre of the Week: "+popularBook);
        System.out.println();

        //Most popular Genre of the Month:
        biggestSale = 0;
        popularBook = null;
        Map<String, Integer> soldByMonthGenre = new HashMap<>();
        for(int i=0; i<monthBooks.size(); i++){
            if(soldByMonthGenre.get(monthBooks.get(i).getGenre()) == null){
                //Book is not in the Map
                soldByMonthGenre.put(monthBooks.get(i).getGenre(),monthBooks.get(i).getSoldQuantity() );
            }
            else{
                int soldQuantityAlready = monthBooks.get(i).getSoldQuantity();
                soldByMonthGenre.put(monthBooks.get(i).getGenre(),soldQuantityAlready + monthBooks.get(i).getSoldQuantity() );
            }
        }
        for(Map.Entry<String, Integer> entry : soldByMonthGenre.entrySet()){
            if(entry.getValue() > biggestSale){
                biggestSale = entry.getValue();
                popularBook = entry.getKey();
            }
        }
        System.out.println("Most popular Genre of the Month: "+popularBook);
        System.out.println();


    }
}
