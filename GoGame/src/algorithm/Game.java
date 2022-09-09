package algorithm;


import java.awt.*;

public class Game extends Canvas {
    Board board;
    int turns;
    String move;
    int positionX;
    int positionY;
    int passed;
    int scoreplayerOne;
    int scoreplayerTwo;

    public Game() {
        board = new Board(9);
        move = "start";
        positionX = -1;
        positionY = -1;
        turns = 1;
        passed = 0;
        scoreplayerOne = 0;
        scoreplayerTwo = 0;
    }

    public int getGameBoardSize() {
        return board.getSize();
    }

    public int[][] getGameBoard() {
        return board.getBoard();
    }

    public boolean passGame() {//verify if the button pass was pressed 2 times;
                                // if yes, the game ends;
                                //otherwise it is the turn for the other player;
        if (passed != 0) {
            return false;
        } else {
            turns++;
            move = "pass";
            passed = 1;
        }
        return true;
    }

    public void moveGame() {//verify if the player clicked on the board and wanted to add a piece
        move = "move";
        passed = 0;
    }

    public int getTurns() {
        return turns;
    }

    public void setCoordinates(int x, int y) {//setting the positions by using the coordinates of the pressed button
        positionX = x / 80;
        positionY = y / 80;
    }

    public void movePiece(int colour) {//verify if a piece can be moved and moved it there
        if (!Rules.placeOccupied(positionX, positionY, this.board.getBoard())) {
            if (!Rules.neighboursOtherPlayer(positionX, positionY, this.board.getBoard(), this.board.getSize(), colour)) {
                this.board.addPiece(positionX, positionY, colour);
            } else {
                System.out.println("Piece could not be added [Neighbours enemies]");
                --turns;
            }
        } else {
            System.out.println("Piece could not be added [Another piece is there]");
            --turns;
        }
    }

    public void playRound() {//playing one round and after change the state of the board if it is necessary
        int colour;
        if (turns % 2 == 1) {
            colour = 1;
        } else {
            colour = 2;
        }
        if (move.equals("move")) {
            movePiece(colour);
        }
        Rules.piecesCaptured(board.getBoard(), board.getSize());
        turns++;
    }

    public String calculateScore() {//at the end the score is calculated by counting the number of captured pieces

        String message;
        int size = this.board.getSize();
        int[][] board = this.board.getBoard();

        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; ++j) {
                board[i][j] = board[i][j];
                if (board[i][j] == -1)
                    scoreplayerTwo++;
                else if (board[i][j] == -2)
                    scoreplayerOne++;
            }
        if (scoreplayerOne > scoreplayerTwo) {
            message = "Player 1 wins : " + scoreplayerOne + " points";
        } else if (scoreplayerOne < scoreplayerTwo) {
            message = "Player 2 wins : " + scoreplayerTwo + " points";
        } else {
            message = "Draw " + scoreplayerOne;
        }
        return message;
    }
}
