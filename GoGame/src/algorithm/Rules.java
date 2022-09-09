package algorithm;

public class Rules {

    public static boolean placeOccupied(int x, int y, int[][] board) {
        return board[x][y] != 0;
    }//verify if the place is already occupied

    public static boolean neighboursOtherPlayer(int x, int y, int[][] board, int size, int colour) {
        //verify if all the liberties(empty places which surround a piece) are occupied by the other player's pieces

        boolean ok1 = false;
        boolean ok2 = false;
        boolean ok3 = false;
        boolean ok4 = false;
        if (x - 1 >= 0) {
            if (board[x - 1][y] == 3 - colour) {
                ok1 = true;
            }
        } else {
            ok1 = true;
        }
        if (y - 1 >= 0) {
            if (board[x][y - 1] == 3 - colour) {
                ok2 = true;
            }
        } else {
            ok2 = true;
        }
        if (x + 1 < size) {
            if (board[x + 1][y] == 3 - colour) {
                ok3 = true;
            }
        } else {
            ok3 = true;
        }
        if (y + 1 < size) {
            if (board[x][y + 1] == 3 - colour) {
                ok4 = true;
            }
        } else {
            ok4 = true;
        }
        return (ok1 && ok2 && ok3 && ok4);
    }

    public static boolean verifyLiberties(int x, int y, int[][] board, int size) {//verify if a piece is surrounded by a free intersection
        if (x - 1 >= 0) {
            if (board[x - 1][y] <= 0 && board[x - 1][y] >= -2)
                return true;
        }
        if (y - 1 >= 0) {
            if (board[x][y - 1] <= 0 && board[x][y - 1] >= -2)
                return true;
        }
        if (x + 1 < size) {
            if (board[x + 1][y] <= 0 && board[x + 1][y] >= -2)
                return true;
        }
        if (y + 1 < size) {
            if (board[x][y + 1] <= 0 && board[x][y + 1] >= -2)
                return true;
        }
        return false;
    }

    public static boolean verifyCapture(int x, int y, int[][] board, int size) {//verify if pieces by the same colour are captured by the enemy
        int value = board[x][y];
        if (verifyLiberties(x, y, board, size)) {
            return false;
        } else if (board[x][y] > 0) {
            board[x][y] = -3;
            if (x - 1 >= 0) {
                if (board[x - 1][y] == value) {
                    return verifyCapture(x - 1, y, board, size);
                }
                if (y - 1 >= 0) {
                    if (board[x][y - 1] == value)
                        return verifyCapture(x, y - 1, board, size);
                }
                if (x + 1 < size) {
                    if (board[x + 1][y] == value)
                        return verifyCapture(x + 1, y, board, size);
                }
                if (y + 1 < size) {
                    if (board[x][y + 1] == value)
                        return verifyCapture(x, y + 1, board, size);
                }
            }
        }
        return true;
    }

    public static void eliminatePieces(int x, int y, int[][] board, int size) {//eliminate the captured pieces for a given position
        int value = board[x][y];
        board[x][y] = -value;
        if (x - 1 >= 0) {
            if (board[x - 1][y] == value) {
                eliminatePieces(x - 1, y, board, size);
            }
        }
        if (y - 1 >= 0) {
            if (board[x][y - 1] == value) {
                eliminatePieces(x, y - 1, board, size);
            }
        }
        if (x + 1 < size) {
            if (board[x + 1][y] == value) {
                eliminatePieces(x + 1, y, board, size);
            }
        }
        if (y + 1 < size) {
            if (board[x][y + 1] == value) {
                eliminatePieces(x, y + 1, board, size);
            }
        }
    }

    public static void piecesCaptured(int[][] board, int size) {//eliminate the captured pieces from the board
        int[][] boardCopy = new int[size][size];

        for (int ii = 0; ii < size; ++ii)
            System.arraycopy(board[ii], 0, boardCopy[ii], 0, size);

        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; ++j) {
                if (board[i][j] > 0) {

                    for (int ii = 0; ii < size; ++ii)
                        System.arraycopy(board[ii], 0, boardCopy[ii], 0, size);

                    if (Rules.verifyCapture(i, j, boardCopy, size)) {
                        eliminatePieces(i, j, board, size);
                        i = size;
                        j = size;
                    }
                }
            }
    }
}