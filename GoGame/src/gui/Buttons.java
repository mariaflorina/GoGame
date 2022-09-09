package gui;

import algorithm.Game;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.util.ArrayList;

public class Buttons extends JButton {

    ArrayList<JButton> buttons = new ArrayList<>();
    int[] visited = new int[100];

    JButton createButton(int x, int y, JFrame frame, Game game) {
        JButton button = new JButton();
        button.setBounds(x, y, 80, 80);
        frame.add(button);
        button.setVisible(true);

        button.setOpaque(false);//hide the button
        button.setContentAreaFilled(false);//hide the button
        button.setBorderPainted(false);//hide the button

        button.setUI(new BasicButtonUI() {//make the buttons appear round when clicked
            @Override
            public void update(Graphics g, JComponent c) {
                if (c.isOpaque()) {
                    Color fillColor;
                    if (game.getTurns() % 2 == 0) {
                        fillColor = Color.BLACK;
                    } else {
                        fillColor = Color.WHITE;
                    }

                    AbstractButton button = (AbstractButton) c;
                    ButtonModel model = button.getModel();

                    if (model.isPressed()) {
                        fillColor = fillColor.darker();
                    }

                    g.setColor(fillColor);
                    g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 100, 100);
                }
                paint(g, c);
            }
        });

        button.addActionListener(e -> {
            button.setOpaque(true);//button appears;
            button.setEnabled(false);//it can't be clicked anymore;
            game.moveGame();//it's a move;
            game.setCoordinates(y, x);//sending the coordinates for this round;
            game.playRound();//play the round
            verifyButtons(game);//make buttons disappear if the piece on that spot was captured;
        });

        return button;

    }

    public Buttons(JFrame frame, Game game) {//create all the buttons for the game
        int size = game.getGameBoardSize();
        int x;
        int y = 40;
        for (int i = 0; i < size; ++i) {
            x = 40;
            for (int j = 0; j < size; ++j) {
                buttons.add(createButton(x, y, frame, game));
                x = x + 80;
            }
            y = y + 80;
        }
    }

    public void verifyButtons( Game game) {//verify if the piece exists and if it doesn't, the correspondent button disappears
        int size = game.getGameBoardSize();
        int[][] board = game.getGameBoard();
        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; ++j)
                if (board[i][j] < 0) {
                    int position = i * size + j;
                    if (visited[position] == 0) {
                        visited[position] = 1;
                        buttons.get(position).setVisible(false);
                    }
                }
    }
}
