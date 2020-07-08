import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TicTacToeText {
    TicTacToe ticTacToe = new TicTacToe();

    @Test
    public void whenGameStarted_boardShouldBeEmpty() {
        ticTacToe.startGame();

        int[][] board = ticTacToe.getBoard();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertEquals(TicTacToe.NONE, board[row][col]);
            }
        }

    }

    @Test
    public void givenGameStarted_currentPlayerShouldBeCircle() {
        //given
        ticTacToe.startGame();
        //then
        assertEquals(TicTacToe.CIRCLE, ticTacToe.getCurrentPlayer());
    }

    @Test
    public void givenCurrentPlayerIsCircle_whenCircleFinishesHisTurn_thenCurrentShouldPlayerShouldBeCross() {
        //given
        ticTacToe.startGame();
        ticTacToe.setCurrentPlayer(TicTacToe.CIRCLE);
        //when
        ticTacToe.play(0, 0);
        //then
        assertEquals(TicTacToe.CROSS, ticTacToe.getCurrentPlayer());
    }

    @Test(expected = BlockInvalidException.class)
    public void givenBlockHasBeenPlaced_whenPlaceAtTheSameBlock_shouldThrowBlockInvalidException() {
        ticTacToe.startGame();
        ticTacToe.play(0, 0);

        ticTacToe.play(0, 0);
    }

    @Test
    public void givenFirstCircleRowConnected_thenWinnerShouldBeCircle() {
        // given
        ticTacToe.startGame();
        givenCircleRowConnected(0);

        // then
        assertEquals(TicTacToe.CIRCLE, ticTacToe.getWinner());
    }

    @Test
    public void givenThirdCircleRowConnected_thenWinnerShouldBeCircle() {
        // given
        ticTacToe.startGame();
        givenCircleRowConnected(2);

        // then
        assertEquals(TicTacToe.CIRCLE, ticTacToe.getWinner());
    }

    private void givenCircleRowConnected(int row) {
        ticTacToe.play(row, 0); // circle
        ticTacToe.play((row + 1) % 3, 0);
        ticTacToe.play(row, 1); // circle
        ticTacToe.play((row + 2) % 3, 1);
        ticTacToe.play(row, 2); // circle
        if (ticTacToe.getWinner() == TicTacToe.NONE) {
            ticTacToe.play((row + 1) % 3, 2);
        }

    }
}