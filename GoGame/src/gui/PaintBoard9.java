package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class PaintBoard9 extends JComponent {//draw the lines for the board
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2f));
        g2.setColor(Color.BLACK);

        g2.draw(new Line2D.Double(80, 80, 80, 720));
        g2.draw(new Line2D.Double(160, 80, 160, 720));
        g2.draw(new Line2D.Double(240, 80, 240, 720));
        g2.draw(new Line2D.Double(320, 80, 320, 720));
        g2.draw(new Line2D.Double(400, 80, 400, 720));
        g2.draw(new Line2D.Double(480, 80, 480, 720));
        g2.draw(new Line2D.Double(560, 80, 560, 720));
        g2.draw(new Line2D.Double(640, 80, 640, 720));
        g2.draw(new Line2D.Double(720, 80, 720, 720));


        g2.draw(new Line2D.Double(80, 80, 720, 80));
        g2.draw(new Line2D.Double(80, 160, 720, 160));
        g2.draw(new Line2D.Double(80, 240, 720, 240));
        g2.draw(new Line2D.Double(80, 320, 720, 320));
        g2.draw(new Line2D.Double(80, 400, 720, 400));
        g2.draw(new Line2D.Double(80, 480, 720, 480));
        g2.draw(new Line2D.Double(80, 560, 720, 560));
        g2.draw(new Line2D.Double(80, 640, 720, 640));
        g2.draw(new Line2D.Double(80, 720, 720, 720));
    }
}
