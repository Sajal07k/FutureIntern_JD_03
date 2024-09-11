import java.util.Scanner;

public class Project2
{
    // Game2_TicTacToe
	private static char [][]board = new char[3][3];
	private static char currentPlayer = 'X';
	public static void printBoard()
	{
		System.out.println("  0  1  2");
		for(int i = 0; i < 3; i++){
			System.out.println(i+"  ");
			for(int j = 0; j < 3; j++){
				System.out.print(" "+board[i][j]);
				if(j < 2){
					System.out.print(" |");
				}
			}
			System.out.println();
			if(i < 2){
				System.out.println("  ---+---+---"); 
			}
		}
	}
	public static boolean checkWinner()
	{
		// all rows are same
		for(int i = 0; i < 3; i++){
			if(board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer){
				return true;
			}
		}
		// all cols are same
		for(int i = 0; i < 3; i++){
			if(board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer){
				return true;
			}
		}
		// check diagonals
		if(board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer){
			return true;
		}
		if(board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer){
			return true;
		}
		return false;
	}
	public static void intializeBoard()
	{
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = ' ';
			}
		}
	}
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("_______TIC TAC TOE_______");
		boolean playAgain = true;
        
        while (playAgain) {
            intializeBoard();
            currentPlayer = 'X';  // Reset the starting player
            int moves = 0;
            boolean winner = false;
            
            while (true)
            {
                printBoard(); // Print the board after every move
                System.out.println("Player " + currentPlayer + ", please enter your move (row & col):");
                int row = sc.nextInt();
                int col = sc.nextInt();
                System.out.println();
                
                if (row < 0 || col < 0 || row >= 3 || col >= 3 || board[row][col] != ' ') {
                    System.out.println("Invalid move, try again.");
                    continue;
                }
                
                board[row][col] = currentPlayer;
                moves++;
                if (checkWinner()) {
                    winner = true;
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (moves == 9) {
                    printBoard();
                    System.out.println("It's a draw.");
                    break;
                }
                
                // Switch players
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

            }
            
            // Ask if the players want to play again
            System.out.println("Do you want to play again? (yes/no)");
            String response = sc.next().trim().toLowerCase();
            if (response.equals("no")) {
                playAgain = false;
            }
        }
        
        sc.close();
        System.out.println("Thank you for playing!");
	}
}
