package gfx;

import javax.swing.*;
import java.awt.*;

// Gradient Button
public class GradientButton extends JButton {

    private final Color color1;
    private final Color color2;

    public GradientButton(String text, Color color1, Color color2) {
        super(text);
        this.color1 = color1;
        this.color2 = color2;
        setContentAreaFilled(false); // Important: Disable default fill
        setFocusPainted(false); // Optional: Disable focus painting
        setBorderPainted(false); // Optional: Disable border painting
        setOpaque(false); // Important: Make the button transparent for gradient
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2); // Vertical gradient
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);

        super.paintComponent(g); // Paint the text

        g2d.dispose();
    }
}
