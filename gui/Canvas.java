package gui;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Canvas extends JPanel {
    private final String txt = "Coding because it will never be uncool\u2122"; 
    private BufferedImage img = null;

    public Canvas() {
        try {
            img = ImageIO.read(new File("gui/resources/icons/about-logo-200x60.png"));
        } catch (IOException e) {
            throw new RuntimeException("Unable to load image: " + e.getMessage());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(380, 200);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D)graphics.create();

        // Rectangle[] rectangles = {
            //     new Rectangle(10, 10, cSize.width / 3, cSize.height / 4),
            //     new Rectangle(20, 20, cSize.width / 3, cSize.height / 4),
            //     new Rectangle(30, 30, cSize.width / 3, cSize.height / 4),
            //     new Rectangle(40, 40, cSize.width / 3, cSize.height / 4),
            //     new Rectangle(50, 50, cSize.width / 3, cSize.height / 4),
            //     new Rectangle(60, 60, cSize.width / 3, cSize.height / 4),
            //     new Rectangle(70, 70, cSize.width / 3, cSize.height / 4),
            //     new Rectangle(80, 80, cSize.width / 3, cSize.height / 4),
        //     new Rectangle(90, 90, cSize.width / 3, cSize.height / 4),
        //     new Rectangle(100, 100, cSize.width / 3, cSize.height / 4),
        //     new Rectangle(110, 110, cSize.width / 3, cSize.height / 4)
        // };

        Rectangle cSize = getBounds();
        Color[] colors = {
            new Color(0, 0, 0),
            new Color(67, 67, 67),
            new Color(102, 102, 102),
            new Color(153, 153, 153),
            new Color(183, 183, 183),
            new Color(204, 204, 204),
            new Color(217, 217, 217),
            new Color(159, 197, 232),
            new Color(111, 168, 220),
            new Color(61, 133, 198),
            new Color(11, 83, 148),
            new Color(7, 55, 110) //color for string
        };

        int rCnt = colors.length - 1;
        int rectW = cSize.width / 2;
        int rectH = cSize.height / 4;
        int initOffsetX = 7;
        int initOffsetY = 3;
        for (int i = 1; i < rCnt ; i++) {
            int rectX = (i + initOffsetX) * 8; 
            int rectY = (i + initOffsetY) * 6; 
            g.drawRect(rectX, rectY, rectW, rectH);
            g.setColor(colors[i - 1]);
            g.fillRect(rectX, rectY, rectW, rectH);
        }

        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        g.setColor(colors[colors.length - 1]);
        g.drawString(txt, 20, 170);

        //Draw image
        int x = getBounds().width / 3;
        int y = getBounds().height / 3;
        g.drawImage(img, x, y, this);
    }
}
