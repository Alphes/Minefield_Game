import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row, column;

       System.out.println("Welcome to Minefield! \n Please enter to row and column number!");
        System.out.print("Row Number : ");
        row = scan.nextInt();
        System.out.print("Column Number : ");
        column = scan.nextInt();


        MinefieldGame mine = new MinefieldGame(row,column);

        mine.run();


    }
}

