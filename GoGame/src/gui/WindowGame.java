package gui;

import algorithm.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

import static javax.swing.JOptionPane.showMessageDialog;

public class WindowGame extends Canvas {


    public WindowGame(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);
        Buttons buttons = new Buttons(frame, game);
        JButton pass = new JButton("PASS");
        JButton quit = new JButton("QUIT");

        pass.setBounds(800, 100, 100, 40);
        pass.setForeground(Color.white);
        pass.setBackground(Color.decode("#72195A"));
        frame.add(pass);

        quit.setBounds(800, 200, 100, 40);
        quit.setForeground(Color.white);
        quit.setBackground(Color.decode("#72195A"));
        frame.add(quit);


        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.getContentPane().add(new PaintBoard9());
        frame.pack();


        frame.getContentPane().setBackground(Color.decode("#71A9F7"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        //frame.add(game);

        frame.setVisible(true);

        pass.addActionListener(e -> {
            boolean passGame = game.passGame();
            if (!passGame) {
                showMessageDialog(null, game.calculateScore());
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }

        });

        quit.addActionListener(e -> frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)));


    }
}
