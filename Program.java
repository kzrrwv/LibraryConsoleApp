import java.util.Scanner;

public class Program {
    public static void main(String[]args){
        while(true){
            System.out.println("Открыть библиотеку? \n1. Да \n2. Нет");
            Scanner scan = new Scanner(System.in);
            int answer = scan.nextInt();

            switch(answer){
                case 1:
                    Menu.MenuSelection();
                    break;
                case 2:
                    System.exit(0);
                default:
                    System.out.println("Неккоректный ввод, попробуйте снова!");
            }
        }
    }
}
