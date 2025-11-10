
import java.time.LocalDateTime;

public class BorrowHistory {
    int bookId;
    int readerId;
    LocalDateTime borrowDate = LocalDateTime.now();
    int returnBook;
    LocalDateTime returnDate;
    boolean isReturned;

    public BorrowHistory(){

    }

    public BorrowHistory(int bookId, int readerId, int returnBook, boolean isReturned) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.returnBook = returnBook;
        this.isReturned = isReturned;
        returnDate = LocalDateTime.now().plusDays(returnBook);
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public int getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(int returnBook) {
        this.returnBook = returnBook;
        returnDate = LocalDateTime.now().plusDays(returnBook);
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}



