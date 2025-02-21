package gfx;

import javax.swing.*;
import java.awt.*;

// Gradient Button with Rounded Corners
public class RoundGradientButton extends JButton {

    private final Color color1;
    private final Color color2;
    private final int cornerRadius; // New: Add corner radius

    public RoundGradientButton(String text, Color color1, Color color2, int cornerRadius) {
        super(text);
        this.color1 = color1;
        this.color2 = color2;
        this.cornerRadius = cornerRadius; // Store radius

        setContentAreaFilled(false); // Disable default fill
        setFocusPainted(false); // Optional: Disable focus painting
        setBorderPainted(false); // Optional: Disable border painting
        setOpaque(false); // Make the button transparent for gradient
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Apply gradient paint
        GradientPaint gp = new GradientPaint(0, 0, color1, w, 0, color2);
        g2d.setPaint(gp);

        // Draw rounded rectangle
        g2d.fillRoundRect(0, 0, w, h, cornerRadius, cornerRadius);

        g2d.dispose();
        super.paintComponent(g); // Paint the text
    }

//    @Override
//    protected void paintBorder(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g.create();
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//        g2d.setColor(getForeground()); // Border color
//        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
//
//        g2d.dispose();
//    }
}