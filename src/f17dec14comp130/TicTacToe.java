package f17dec14comp130;

import java.util.Scanner;

/**
 *
 * @author jwright
 */
public class TicTacToe {
    private static String[][] gameBoard;
    private static String currentPlayer;
    
    public static void main(String[] args)
    {
        gameBoard=new String[3][3];
        currentPlayer="X";
      
        initializeGameBoard();
        
    //    do{
            displayGameBoard();
    //        makeMove();
    //    } while (gameIsNotDone());
    } //end of the main method
    
    /**
     * This method will prompt to the user for a row and column
     * It will validate the row and column position to ensure
     * it is on the game board and currently free.  If not, it
     * will prompt the user again
     */
    public static void makeMove()
    {
        int row, col;
        do
        {
            //prompt the user for row and columns
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter a row (1-3): ");
            row = keyboard.nextInt();
            
            System.out.print("Enter a col (1-3): ");
            col = keyboard.nextInt();
        } while (!validMove(row, col));
    }
    
    /**
     * This method will test the row and col input to ensure
     * -row and col are in the range 0-2
     * -the position in the gameBoard contains a " " character
     * @return true if the position is available, false otherwise
     */
    public static boolean validMove(int row, int col)
    {
        //check to see if position is outside gameBoard
        if (row<0 || row>2 || col<0 || col>2)
        {
            System.out.println("Row and column must be in the range 1-3");
            return false;
        }
     
        if (gameBoard[row][col].equals(" "))
            return true;
        else
        {
            System.out.println("Sorry that position is taken");
            return false;
        }
    }
    
    
    /**
     * This method will put spaces into each position in the gameboard
     */
    public static void initializeGameBoard()
    {
        for (int row=0; row< gameBoard.length; row++)
        {
            for (int col=0; col<gameBoard[row].length; col++)
            {
                gameBoard[row][col]=" ";
            }                
        }
    }
    
    /**
     * This method will display the gameBoard to the console as
     * characters
     */
    public static void displayGameBoard()
    {
        for (int row=0; row<gameBoard.length; row++)
        {
            for (int col=0; col<gameBoard[row].length; col++)
            {
                if (col < 2)
                    System.out.printf(" %s |", gameBoard[row][col]);
                else 
                    System.out.printf(" %s %n", gameBoard[row][col]);
            }
            if (row < 2)
                System.out.println("-----------");
        }
    }
    
    
}
