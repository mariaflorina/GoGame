package gui;

import algorithm.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowStart extends Canvas {

    public WindowStart(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);
        JButton button = new JButton("START");
        JLabel textField = new JLabel("GO GAME");

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setLayout(null);
        textField.setBounds(430, 200, 200, 100);
        textField.setFont(new Font("Serif", Font.PLAIN, 30));
        button.setBounds(400, 400, 200, 50);
        frame.getContentPane().setBackground(Color.decode("#71A9F7"));
        frame.add(button);
        frame.add(textField);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        button.addActionListener(e -> new WindowGame(width, height, title, game));
    }
}
