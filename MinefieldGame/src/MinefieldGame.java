import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MinefieldGame {

    int rowNumber, colNumber, size, notMineCounter = 0;
    int[][] map;
    int[][] board;
    boolean game  = true;

    Random  rand = new Random();
    Scanner scan = new Scanner(System.in);

    MinefieldGame(int rowNumber, int colNumber){
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.size = rowNumber*colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
    }
    public void checkMine(int r, int c){
      if (board[r][c] == 0){
          if ((c < colNumber-1) && map[r][c+1] == -1){
              board[r][c]++;
          }
          if ((c > 0) && map[r][c-1] == -1){
              board[r][c]++;
          }
          if ((r < rowNumber-1) && map[r+1][c] == -1){
              board[r][c]++;
          }
          if ((r > 0) && map[r-1][c] == -1){
              board[r][c]++;
          }
          if ((r < rowNumber-1) && (c < colNumber-1) && map[r+1][c+1] == -1){
              board[r][c]++;
          }
          if ((r > 0) && (c < colNumber-1) && map[r-1][c+1] == -1){
              board[r][c]++;
          }
          if ((r < rowNumber-1) && (c > 0) && map[r+1][c-1] == -1){
              board[r][c]++;
          }
          if ((r > 0) && (c > 0) && map[r-1][c-1] == -1){
              board[r][c]++;
          }
          if(board[r][c] == 0){
              board[r][c] = -2;
          }
      }

    }

    public void run(){

        int row, col;
        prepareGame();
        print(map);
        System.out.println("Game has started!");

        while (game){
            print(board);
            System.out.print("Row: ");
            row = scan.nextInt();

            System.out.print("Column: ");
            col = scan.nextInt();

            if (map[row][col] != -1){
                checkMine(row,col);
                notMineCounter++;
                if (notMineCounter == (size - (size/4)) ){
                    System.out.println("You win!");
                    break;

                }
            }
            else{
                game = false;
                System.out.println("Game Over!");
            }
        }
    }

    public void prepareGame(){
        int randRow, randCol, count = 0 ;

        while (count != (size/4)){
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(colNumber);

            if (map[randRow][randCol] != -1){
                map[randRow][randCol] = -1;
                count++;
            }
        }
    }

    public void print(int[][] arr){
        for (int i = 0; i < arr.length ; i++){
            for (int j = 0; j< arr[0].length; j++){
                if (arr[i][j] >= 0)
                        System.out.print(" ");
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }




}
