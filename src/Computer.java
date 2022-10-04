import java.util.Random;

public class Computer {
    public static void Computer(char[][] gameBoard) {        // player 2 aka computer with random number generator for positioning and move

        Random random = new Random();
        int move = random.nextInt(9) + 1;

        boolean result = GameBoard.isValidMove(move, gameBoard);

        while (!result) {
            move = random.nextInt(9) + 1;
            result = GameBoard.isValidMove(move, gameBoard);
        }
        System.out.println("Player 2 moved at position " + move);
        GameBoard.updateBoard(move, 2, gameBoard);

    }

}
