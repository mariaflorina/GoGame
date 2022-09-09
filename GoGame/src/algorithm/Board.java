package algorithm;

public class Board {

    protected int[][] board;
    protected int size;

    public Board(int size) {
        this.size = size;
        this.board = new int[size][size];
        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; ++j)
                this.board[i][j] = 0;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[i].length; ++i)
                this.board[i][j] = board[i][j];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addPiece(int x, int y, int colour) {
        board[x][y] = colour;
    }
}
