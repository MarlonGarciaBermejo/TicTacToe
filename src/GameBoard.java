import java.util.Random;
import java.util.Scanner;

public class GameBoard {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        char[][] gameBoard = {{'_', '|', '_', '|', '_'},
                {'_', '|', '_', '|', '_'},
                {' ', '|', ' ', '|', ' '}};
        printBoard(gameBoard);
        boolean gameOver = false;
        boolean playAgain = true;

        while (playAgain) {
            while (!gameOver) {
                playerMove(gameBoard);
                gameOver = isGameOver(gameBoard);
                if (gameOver) {
                    break;
                }
                player2Move(gameBoard);
                gameOver = isGameOver(gameBoard);
                if (gameOver) {
                    break;
                }

            }
            System.out.println("Would you like to play again? Y/N");
            input.nextLine();
            String result = input.nextLine();

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

    public static void printBoard(char[][] gameBoard) {

        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();


        }
    }

    public static void updateBoard(int position, int player, char[][] gameBoard) {
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

    public static void playerMove(char[][] gameboard) {

        System.out.println("Please make a move. (1-9)");


        int move = input.nextInt();

        boolean result = isValidMove(move, gameboard);
        while (!result) {
            System.out.println("Sorry! Invalid move. Try again");
            move = input.nextInt();
            result = isValidMove(move, gameboard);

        }
        System.out.println("Player 1 moved at position " + move);
        updateBoard(move, 1, gameboard);


    }

    public static boolean isValidMove(int move, char[][] gameBoard) {
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

    public static void player2Move(char[][] gameBoard) {

        Random random = new Random();
        int move = random.nextInt(9) + 1;

        boolean result = isValidMove(move, gameBoard);

        while (!result) {
            move = random.nextInt(9) + 1;
            result = isValidMove(move, gameBoard);
        }
        System.out.println("Player 2 moved at position " + move);
        updateBoard(move, 2, gameBoard);

    }

    public static boolean isGameOver(char[][] gameBoard) {
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


    public static void resetBoard(char[][] gameBoard){
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



















