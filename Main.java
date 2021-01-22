import java.util.*; 

class Main {
  /*
   * Additional features to add
   *   - "play again?"
   *   - input validation and retries
   *   - better win condition checking
   *   - positional input instead of x,y
   *   - detecting draws sooner
   // X -> 1
    // O -> -1
   */

  public static void main(String[] args) {
    // What you put in here will determine
    // the logic of the game. This will be   
    // using your methods that are below
    Scanner input = new Scanner(System.in);
    int board[][] = new int[3][3];

    for(int i=0; i<3; i++)
    {
      for(int j=0; j<3; j++)
      {
        board[i][j] = 0;
      }
    }
    int moveCount;
    for(moveCount=0; moveCount<9; moveCount++)
    {
      printBoard(board);
      int player = playersTurn(moveCount);
      makeMove(board, input, player);
      if(someoneWon(board))
      {
        String winner;
        if(player == 1)
        {
          winner = "X";
        }
        else{
            winner = "O";
        }
        System.out.println("Player playing with " + winner + " won the game. Hurray!");
        break;
      }

    }
  if(moveCount == 9)
  {
  System.out.println("It's a draw guys!");
  }

  }

  private static int playersTurn(int moveCount) {
    // How will you decide which 
    // player is supposed to play?
    // Hint: How can you use the 
    // move count to achieve this?
    // X -> 1
    // O -> -1

    if(moveCount%2 == 0)
    {
      return 1;
    }

    return -1;


  }

  private static void makeMove(int[][] board, Scanner input, int player) {
    // How will you make a move on
    // the board for each player?
    // Hint: How can you change up
    // your structure to achieve this?
    int position = input.nextInt() - 1;
    

    int row = position / 3;

    int col = position % 3; 
    




    if(board[row][col] == 0)
    {
    board[row][col] = player;
    }

  }

  private static boolean someoneWon(int[][] board) {
    // How will you check to see if
    // a player has won the game?
    // Hint: Think of all the win
    // conditions that there are.

    for(int i=0; i<3; i++)
    {
     if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0)
     {
       return true;
     }
    }

    for(int i=0; i<3; i++)
    {
     if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0)
     {
       return true;
     }
    }
    if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0)
     {
       return true;
     }
    if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0)
     {
       return true;
     }



    return false;
  }

  private static void printBoard(int[][] board) {
    // How will you see all the moves
    // for each player on the console? 
    for (int i = 0; i < 3; i++) {
      System.out.print(" ");
      printCell(board[i][0]); 
      System.out.print(" ║ ");
      printCell(board[i][1]); 
      System.out.print(" ║ ");
      printCell(board[i][2]); 
      System.out.println();
      if (i != 2) {
        System.out.println("═══╬═══╬═══");
      }
    }
  }

  private static void printCell(int cell) {
    // How will you decide what to print
    // on the board based on the spaces in 
    // which each player has made a move
    // Hint: How can you use a switch or an
    // if statement to achieve this result?
    if(cell == 1)
    {
      System.out.print("X");
    }
    else if(cell == -1)
    {
      System.out.print("O");
    }
    else{
      System.out.print(" ");
    }

  }
}