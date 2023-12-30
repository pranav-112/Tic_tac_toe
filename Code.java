import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    char[][] board = new char[3][3];
    for(int row = 0; row < board.length; row++){
        for(int col = 0; col < board[row].length; col++){
            board[row][col]=' ';
        }
    }
    //first player
    char player = 'X';
    //to know if someone won
    boolean gameover = false;
    Scanner sc = new Scanner(System.in);

    while(!gameover){
        printBoard(board);
        if(!gameover&&ifDrawn(board)){
            System.out.println("The match is drawn");
            break;
        }
        System.out.print("Player "+player+" move: ");
        int row = sc.nextInt();
        int col = sc.nextInt();
        if(board[row][col]==' '){
            board[row][col]=player;
            gameover = havewon(board, player);
            if(gameover){
                System.out.println("Hurray!! Player "+ player+ " has won.");
            }
            else{
                player=(player=='X') ? 'O' : 'X';
            }
        }
        
        else{
            System.err.println("Invalid move! Try again :(");
        }
    }
    printBoard(board);
  }

  //to check if someone has won
  public static boolean havewon(char[][] board, char player){
    //check the rows
    for(int row = 0; row < board.length; row++){
        if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
            return true;
        }
    }

    //check the columns
    for(int col = 0; col < board.length; col++){
        if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
            return true;
        }
    }

    //check the diagonals
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
    return false;
  }

  //to check if draw
  public static boolean ifDrawn(char[][] board){
    for(int row = 0; row < board.length; row++){
        for(int col = 0; col < board[row].length; col++){
            if(board[row][col]==' '){
                return false;
            }
        }
    }
    return true;
  }

  //to print the board
  public static void printBoard(char[][] board){
    System.out.println("0   1   2");
    for(int row = 0; row < board.length; row++){
        for(int col = 0; col < board[row].length; col++){
            System.out.print(board[row][col]+ " | ");
        }
        System.out.println(row);
    }
  }

}
