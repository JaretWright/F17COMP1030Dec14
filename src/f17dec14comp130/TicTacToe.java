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
        
        do{
            displayGameBoard();
            makeMove();
        } while (!gameOver());
    } //end of the main method
    
    
    /**
     * This method will check to see if there is a winner by
     * -checking each row to have 3 X's or 3 O's
     * -checking each col to have 3 X's or 3 O's
     * -checking the diagonals for 3 X's or 3 O's
     * @return true if the game should end
     */
    public static boolean gameOver()
    {
        //this checks each row for a winner
        for (int rowNum=0; rowNum<gameBoard.length; rowNum++)
        {
            String row = gameBoard[rowNum][0]+gameBoard[rowNum][1]+gameBoard[rowNum][2];
            if (row.equals("XXX") || row.equals("OOO"))
                return true;
        }
        
        //this checks each column for a winner
        for (int colNum=0; colNum<gameBoard.length; colNum++)
        {
            String col = gameBoard[0][colNum]+gameBoard[1][colNum]+gameBoard[colNum][2];
            if (col.equals("XXX") || col.equals("OOO"))
                return true;
        }
        
        //this checks the diagonal
        String diagonal = gameBoard[0][0]+gameBoard[1][1]+gameBoard[2][2];
        if (diagonal.equals("XXX") || diagonal.equals("OOO"))
                return true;
        
        diagonal = gameBoard[2][0]+gameBoard[1][1]+gameBoard[0][2];
        if (diagonal.equals("XXX") || diagonal.equals("OOO"))
                return true;
        
        //check for a tie game
        if (gameBoardFull())
            return true;
        
        return false;
    }
    
    /**
     * This method will validate if there are any free positions in the
     * gameBoard
     * @return true if gameBoard is full
     */
    public static boolean gameBoardFull()
    {
        for (int row=0; row<gameBoard.length; row++)
            for (int col=0; col<gameBoard[row].length; col++)
                if (gameBoard[row][col].equals(" "))
                {
                    return false;
                }
        return true;
    }
    
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
        } while (!validMove(--row, --col));
        
        gameBoard[row][col]=currentPlayer;
        
        //change active player
        if (currentPlayer.equals("X"))
            currentPlayer="O";
        else
            currentPlayer="X";
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
