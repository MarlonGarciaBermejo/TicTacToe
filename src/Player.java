public class Player {
    public static void playerMove(char[][] gameboard) {     //Method for player1 (you) to move and positioning and if a move is invalid(If position is occupied)

        System.out.println("Please make a move. (1-9)");


        int move = GameBoard.input.nextInt();

        boolean result = GameBoard.isValidMove(move, gameboard);
        while (!result) {
            System.out.println("Sorry! Invalid move. Try again");
            move = GameBoard.input.nextInt();
            result = GameBoard.isValidMove(move, gameboard);

        }
        System.out.println("Player 1 moved at position " + move);
        GameBoard.updateBoard(move, 1, gameboard);


    }
}
