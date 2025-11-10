import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    List<Book> books = new ArrayList<>();
    List<Reader> readers = new ArrayList<>();
    List<BorrowHistory> borrowHistory = new ArrayList<>();
    List<BorrowHistory> overdueBooks = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    public void addBook(){

        System.out.println("Введите Id книги: ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.println("Введите название книги: ");
        String title = scan.nextLine();

        System.out.println("Введите автора книги: ");
        String author = scan.nextLine();

        Book newBook = new Book(id, title, author, true);
        books.add(newBook);
        System.out.println("Книга " + title + " успешно добавлена!");
    }

    public void addReader(){
        System.out.println("Введите id читателя: ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.println("Введите имя читателя: ");
        String name = scan.nextLine();

        Reader newReader = new Reader(id, name, new ArrayList<>());
        readers.add(newReader);
        System.out.println("Пользователь " + name + " успешно добавлен!");
    }

    public void borrowBook(){
        System.out.println("Введите id книги: ");
        int idBook = scan.nextInt();

        System.out.println("Введите id читателя: ");
        int idReader = scan.nextInt();

        System.out.println("Введите кол-во дней, на которое хотите взять книгу: ");
        int countDay = scan.nextInt();

        BorrowHistory borrow = new BorrowHistory(idBook, idReader, countDay, false);
        borrowHistory.add(borrow);
        System.out.println("Читатель с id: " + borrow.readerId + " взял книгу с id: " + borrow.bookId + " дата: " + borrow.borrowDate);
        System.out.println("Нужно вернуть: " + borrow.returnDate);
    }

    public void returnBook(){
        System.out.println("Введите id читателя: ");
        int idReader = scan.nextInt();

        boolean flag = false;
        List<BorrowHistory> borrowsUser = new ArrayList<>();

        for(BorrowHistory borrow: borrowHistory){
            if(borrow.getReaderId() == idReader && !borrow.isReturned()){
                System.out.println("id книги: " + borrow.getBookId());
                borrowsUser.add(borrow);
                flag = true;
            }
        }
        if(flag){
            System.out.println("Введите id книги, которую вы взяли: ");
            int idBook = scan.nextInt();
            for (int  i = 0; i < borrowsUser.size() ; i++) {
                if(borrowsUser.get(i).getBookId() == idBook){
                    if (LocalDateTime.now().isAfter(borrowsUser.get(i).getReturnDate())){
                        System.out.println("ВЫ ДОЛЖНЫ ВЫПЛАТИТЬ ШТРАФ!!!!");
                        overdueBooks.add(borrowsUser.get(i));
                    }
                    borrowHistory.remove(borrowsUser.get(i));
                    break;
                }
            }
            System.out.println("Вы вернули книгу!");

        }
        else{
            System.out.println("Вы не брали книги!");
        }
    }

    public void displayBooks(){
        if(books == null){
            System.out.println("Список книг пуст.");
        }
        System.out.println("Список книг: ");
        for(Book book: books){
            System.out.println("Id: " + book.getId() + " Название книги: " + book.getTitle() + " Автор книги: " + book.getAuthor());
        }
    }

    public void displayReaders(){
        if(readers == null){
            System.out.println("Список читателей пуст.");
        }

        for(Reader reader: readers){
            System.out.println("Id: " + reader.id + " Имя пользователя: " + reader.name);
        }
    }

    public void findBooks(){
        System.out.println("Введите название книги для поиска: ");
        String nameBook = scan.nextLine();
        boolean found = false;

        for (Book book : books) {
            if (nameBook.equalsIgnoreCase(book.getTitle())) {
                System.out.println("Книга " + book.title + " найдена!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Книга с названием '" + nameBook + "' не найдена!");
        }
    }

    public void findReaders(){
        System.out.println("Введите имя читателя для поиска: ");
        String nameReader = scan.nextLine();
        boolean found = false;

        for(Reader reader: readers){
            if(nameReader.equalsIgnoreCase(reader.getName())){
                System.out.println("Читатель " + reader.name + " найден!");
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("Читатель " + nameReader + " не найден!");
        }
    }

    public void displayOverdueBooks(){
        System.out.println("Список просроченных книг: ");
        for(BorrowHistory borrow: overdueBooks){
            System.out.println("Просрочена книга с id: " + borrow.bookId + " читателя с id: " + borrow.readerId);
        }
    }
}
