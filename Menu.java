
import java.util.Scanner;
public class Menu {
    public static void MenuSelection(){
        BorrowHistory borrowHistory = new BorrowHistory();
        Library library = new Library();
        while (true){
            System.out.println("""
                1. Добавить книгу
                2. Добавить читателя
                3. Взять книгу
                4. Вернуть книгу
                5. Показать все книги
                6. Показать всех читателей
                7. Найти книгу
                8. Найти читателя
                9. Показать просроченые книги
                10. Выйти
                """);
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            switch (answer){
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.addReader();
                    break;
                case 3:
                    library.borrowBook();
                    break;
                case 4:
                    library.returnBook();
                    break;
                case 5:
                    library.displayBooks();
                    break;
                case 6:
                    library.displayReaders();
                    break;
                case 7:
                    library.findBooks();
                    break;
                case 8:
                    library.findReaders();
                    break;
                case 9:
                    library.displayOverdueBooks();
                    break;
                case 10:
                    System.exit(0);
                    break;

            }
        }
    }
}
