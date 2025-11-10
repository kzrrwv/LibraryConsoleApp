import java.util.ArrayList;
import java.util.List;

public class Reader {
    int id;
    String name;
    List<Book> borrowedBooks = new ArrayList<>();

    public Reader(){

    }

    public Reader(int id, String name, List<Book> borrowedBooks){
        this.id = id;
        this.name = name;
        this.borrowedBooks = borrowedBooks;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public  List<Book> borrowedBooks() {
        return borrowedBooks;
    }
}
