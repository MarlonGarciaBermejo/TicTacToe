import java.util.Scanner;

public class GameBoard {
    /*    _ | _ | _
          _ | _ | _
            |   |
          positions in the grid
          [0][0]=1  [0][1]=2 [0][2]=3
          [1][0]=4  [1][2]=5 [1][4]=6
          [2][0]=7  [2][2]=8 [2][4]=9
        */

    static Scanner input = new Scanner(System.in); // Created a static scanner to be shared across all instances of the class
   
    public void startGame () {        // Start game method
        System.out.println("Welcome to a game of TicTacToe!");
        System.out.println("May the best player win!");


        char[][] gameBoard = {{'_', '|', '_', '|', '_'},     //Char array grid layout for the game
                {'_', '|', '_', '|', '_'},
                {' ', '|', ' ', '|', ' '}};
        printBoard(gameBoard);          // Print out the gridlayout

        boolean gameOver = false; // A boolean to make a true or false statement if game is over or if you want to do a rematch
        boolean playAgain = true;

        while (playAgain) {     //while loop for play again or game over
            while (!gameOver) {
                Player.playerMove(gameBoard);
                gameOver = isGameOver(gameBoard);
                if (gameOver) {
                    break;
                }
                Computer.computerMove(gameBoard);
                gameOver = isGameOver(gameBoard);
                if (gameOver) {
                    break;
                }

            }
            System.out.println("Would you like to play again? Y/N");
            input.nextLine();
            String result = input.nextLine();                   // play again printout with switch cases

            switch (result) {
                case "Y":
                case "y":

                    playAgain = true;
                    System.out.println("Nice! Let's play again");
                    resetBoard(gameBoard);
                    gameOver = false;
                    printBoard(gameBoard);
                    break;

                case "N":
                case "n":
                    System.out.println("Thank you for playing. Goodbye!");
                    break;
                default:
                    break;
            }

        }
    }

    public static void printBoard(char[][] gameBoard) {         // Printboard method to print out rows

        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();


        }
    }

    public static void updateBoard(int position, int player, char[][] gameBoard) { // Method for player positioning
        char character;

        if (player == 1) {
            character = 'X';
        } else {
            character = 'O';
        }
        switch (position) {
            case 1:
                gameBoard[0][0] = character;
                printBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][2] = character;
                printBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][4] = character;
                printBoard(gameBoard);
                break;
            case 4:
                gameBoard[1][0] = character;
                printBoard(gameBoard);
                break;
            case 5:
                gameBoard[1][2] = character;
                printBoard(gameBoard);
                break;
            case 6:
                gameBoard[1][4] = character;
                printBoard(gameBoard);
                break;
            case 7:
                gameBoard[2][0] = character;
                printBoard(gameBoard);
                break;
            case 8:
                gameBoard[2][2] = character;
                printBoard(gameBoard);
                break;
            case 9:
                gameBoard[2][4] = character;
                printBoard(gameBoard);
                break;
            default:
                break;
        }

    }
    public static boolean isValidMove(int move, char[][] gameBoard) {       // switch case with if statements to see if a move to a position is valid
        switch (move) {
            case 1:
                if (gameBoard[0][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (gameBoard[0][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (gameBoard[0][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (gameBoard[1][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (gameBoard[1][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if (gameBoard[1][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if (gameBoard[2][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (gameBoard[2][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (gameBoard[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;

        }
    }

    public static boolean isGameOver(char[][] gameBoard) {          // method with if statements which prints out who won and if it's a tie
        if (gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X') {
            System.out.println("Player 1 wins!");
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O') {
            System.out.println("Player 2 wins!");
            return true;
        }
        if (gameBoard[1][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[1][4] == 'X') {
            System.out.println("Player 1 wins!");
            return true;
        }
        if (gameBoard[1][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[1][4] == 'O') {
            System.out.println("Player 2 wins!");
            return true;
        }
        if (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player 1 wins!");
            return true;
        }
        if (gameBoard[2][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Player 2 wins!");
            return true;
        }
        if (gameBoard[2][1] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player 1 wins!");
            return true;
        }
        if (gameBoard[2][1] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Player 2 wins!");
            return true;
        }
        if (gameBoard[0][0] == 'X' && gameBoard[1][0] == 'X' && gameBoard[2][0] == 'X') {
            System.out.println("Player 1 wins!");
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[1][0] == 'O' && gameBoard[2][0] == 'O') {
            System.out.println("Player 2 wins!");
            return true;
        }
        if (gameBoard[0][2] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][2] == 'X') {
            System.out.println("Player 1 wins!");
            return true;
        }
        if (gameBoard[0][4] == 'O' && gameBoard[1][4] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Player 2 wins!");
            return true;
        }
        if (gameBoard[0][4] == 'X' && gameBoard[1][4] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player 1 wins!");
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Player 2 wins!");
            return true;
        }
        if (gameBoard[0][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player 1 wins!");
            return true;
        }
        if (gameBoard[2][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[0][4] == 'O') {
            System.out.println("Player 2 wins!");
            return true;
        }
        if (gameBoard[2][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[0][4] == 'X') {
            System.out.println("Player 1 wins!");
            return true;
        }
        if (gameBoard[0][0] != '_' && gameBoard[0][2] != '_' && gameBoard[0][4] != '_' && gameBoard[1][0] != '_' &&
                gameBoard[1][2] != '_' && gameBoard[1][4] != '_' && gameBoard[2][0] != ' ' && gameBoard[2][2] != ' ' &&
                gameBoard[2][4] != ' ') {
            System.out.println("It's a tie!");
            return true;
        }
        return false;
    }


    public static void resetBoard(char[][] gameBoard){      // A reset method that clears out the game grid layout in case player would like to start a new game of TicTacToe
        gameBoard[0][0] = '_';
        gameBoard[0][2] = '_';
        gameBoard[0][4] = '_';
        gameBoard[1][0] = '_';
        gameBoard[1][2] = '_';
        gameBoard[1][4] = '_';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';

    }
}
























