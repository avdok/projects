import java.util.Scanner;

public class Life {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        Desk desk = new Desk();
        Desk desk1;

        System.out.println("New life with " + desk.getInfo());
        desk.setRandomField();
        desk.printField();

        while (true) {    
            System.out.println("Введите действие (n-следующее поколение, e-выход):");
            char operation;
            if(scanner.hasNext()){
                operation = scanner.next().charAt(0);
            } else {
                System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
                continue;
            }
            if (operation == 'e') {
                break;
            } else if (operation == 'n') {
                desk = desk.getNewGeneration();
                System.out.println("Gen " + desk.getGen() + "====================================");
                desk.printField();            
            }
            
            
        }


        //desk1 = desk.getNewGeneration();
        //System.out.println("Gen " + desk1.getGen());
        //desk1.printField();

    }
}
