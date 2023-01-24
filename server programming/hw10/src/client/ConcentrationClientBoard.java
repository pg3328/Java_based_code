package client;

import game.ConcentrationCard;

/**
 * Concentration board for client side. Keeps status of previously matched card.
 *
 * @author Arya Girisha Rao, Pradeep Kumar Gontla.
 */

public class ConcentrationClientBoard {

    /**
     * Dimension of the Concentration board.
     */
    private final int dimension;

    /**
     * String Representation of the Concentration board.
     */
    private final char[][] board;

    /**
     * Number of matches achieved by the player.
     */
    private int matches;


    /**
     * Create a new client version of Concentration game board
     *
     * @param dimensions dimension of the board.
     */
    public ConcentrationClientBoard(int dimensions) {
        this.dimension = dimensions;
        this.matches = 0;
        this.board = new char[dimension][dimension];
        this.createGrid();
    }

    /**
     * Validate if the reveal move entered by the user is valid or not.
     *
     * @param row row in the Concentration board.
     * @param col column in the Concentration board.
     * @return boolean indicating if the move is valid or not.
     */
    public boolean validateEnteredValues(int row, int col) {
        return row < dimension && col < dimension && board[row][col] == ConcentrationCard.HIDDEN;
    }

    /**
     * Create grid of the Concentration card used to represent each cell in the Concentration Board.
     */
    public void createGrid() {
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                this.board[row][col] = ConcentrationCard.HIDDEN;
            }
        }
    }


    /**
     * Modify the  cell of the Concentration board and update with the revealed card.
     *
     * @param row    row value of the revealed card.
     * @param col    column value of the revealed card.
     * @param letter revealed card letter.
     */
    public void modifyGrid(int row, int col, char letter) {
        this.board[row][col] = letter;
    }

    /**
     * Hides the opened cards in the board. Used whenever the two cards opened are mismatch.
     *
     * @param openedCards two cards previously opened.
     */
    public void hideOpenedCards(String[] openedCards) {
        modifyGrid(Integer.parseInt(openedCards[0]), Integer.parseInt(openedCards[1]), ConcentrationCard.HIDDEN);
        modifyGrid(Integer.parseInt(openedCards[2]), Integer.parseInt(openedCards[3]), ConcentrationCard.HIDDEN);
    }

    /**
     * update the total match count in the game.
     */
    public void updateMatchCount() {
        matches += 2;
    }

    /**
     * Indicates whether the Game is over.
     *
     * @return boolean indicating if the game is over.
     */
    public boolean isGameOver() {
        return this.matches == this.dimension * this.dimension;
    }

    /**
     * String Representation of the Concentration board.
     *
     * @return String Representation of the Concentration board.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("  ");
        for (int col = 0; col < this.dimension; ++col) {
            str.append(col);
        }
        str.append("\n");
        for (int row = 0; row < this.dimension; ++row) {
            str.append(row).append("|");
            for (int col = 0; col < this.dimension; ++col) {
                str.append(this.board[row][col]);
            }
            str.append("\n");
        }
        return str.toString();
    }
}
