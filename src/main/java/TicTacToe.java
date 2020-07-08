import java.util.Arrays;

public class TicTacToe {
    public final static int NONE = -1;
    public static final int CIRCLE = 2;
    public static final int CROSS = 3;
    public int currentPlayer = CIRCLE;

    int[][] board = new int[3][3];


    public void startGame() {
        for (int row = 0; row < board.length; row++) {
            Arrays.fill(board[row], TicTacToe.NONE);
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int circle) {
        this.currentPlayer = circle;

    }

    public void play(int row, int col) {
        if (board[row][col] == NONE) {
            board[row][col] = getCurrentPlayer();
        } else {
            throw new BlockInvalidException();
        }
        this.currentPlayer = this.currentPlayer == CIRCLE ? CROSS : CIRCLE;


    }

    public int getWinner() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if(board[row][1] == board[row][2] && board[row][3] == CIRCLE){
                    return CIRCLE;
                }
            }
        }
        return NONE;
    }
}
