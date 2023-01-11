import java.time.LocalDate;


public class SoldComicBook extends ComicBook{

    private int soldQuantity;
    LocalDate sellDate;

    public SoldComicBook(){
        int soldQuantity;
        this.sellDate = LocalDate.now();
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public LocalDate getSellDate() {
        return sellDate;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }
//
@Override
public String toString() {
    return "SoldComicBook{" +
            "Name =' " + getName() + '\'' +
            ", Author =' " + getAuthor() + '\'' +
            ", genre =' " + getGenre() + '\'' +
            ", purchase Price = " + getPurchasePrice() +
            ", sale Price = " + getSalePrice() +
            ", SoldQuantity=" + soldQuantity +
            ", SellDate=" + sellDate +
            '}';
}
//    @Override
//    public String toString() {
//        return "SoldComicBook{" +
//                "soldQuantity=" + soldQuantity +
//                ", sellDate=" + sellDate +
//                '}';
//    }
}
