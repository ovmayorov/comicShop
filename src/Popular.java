import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Popular {
    private SoldDatabase soldDatabase;

    Popular(SoldDatabase soldDatabase){
        this.soldDatabase = soldDatabase;
    }

    public void sort(){
        //Create a list of books sold today
        System.out.println("Comic Books sold today: ");
        List<SoldComicBook> sortedBooks = soldDatabase.getCBSoldDatabase().stream().filter( n -> n.getSellDate().equals(LocalDate.now())).toList() ;
        //проходимся по листу и загоняем все в MAP , ключ - название книги, параметр - количество продаж
        //выводим на печать первые 3 (или 1 )
        Map<String, Integer> soldByDay = new TreeMap<>();
        for(int i=0; i<sortedBooks.size(); i++){
            if(soldByDay.get(sortedBooks.get(i).getName()) == null){
                //Book is not in the Map
                soldByDay.put(sortedBooks.get(i).getName(),sortedBooks.get(i).getSoldQuantity() );
            }
            //SortedMap<Integer, String> firstFive = Util.putFirstEntries(5, sourceMap);
            else{
                int soldQuantityAlready = sortedBooks.get(i).getSoldQuantity();
                soldByDay.put(sortedBooks.get(i).getName(),soldQuantityAlready + sortedBooks.get(i).getSoldQuantity() );
            }
        }
        soldByDay.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        //System.out.println(soldByDay);



        //sortedBooks.stream().forEach(System.out::println);


//        List<String> longNameCities = cities
//                .stream()
//                .filter(city -> city.length() > 6)
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println("Города, название которых длиннее 6 символов:");
//        System.out.println(longNameCities);
    }
}
