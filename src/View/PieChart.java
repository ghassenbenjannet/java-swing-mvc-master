package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class PieChart extends JPanel {

    private String title;
    private ArrayList<PieSegment> segments;

    public PieChart(String title) {
        this.title = title;
        segments = new ArrayList<PieSegment>();
    }

    public void addSegment(String name, double value, Color color) {
        segments.add(new PieSegment(name, value, color));
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int diameter = Math.min(width, height);
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;

        g2d.setColor(Color.WHITE);
        g2d.fillOval(x, y, diameter, diameter);

        double total = 0.0;
        for (PieSegment segment : segments) {
            total += segment.getValue();
        }

        double angle1 = 0.0;
        for (PieSegment segment : segments) {
            double angle2 = angle1 + (360.0 * segment.getValue() / total);
            g2d.setColor(segment.getColor());
            g2d.fill(new Arc2D.Double(x, y, diameter, diameter, angle1, angle2 - angle1, Arc2D.PIE));
            angle1 = angle2;
        }

        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, diameter, diameter);
    }

    private static class PieSegment {
        private String name;
        private double value;
        private Color color;

        public PieSegment(String name, double value, Color color) {
            this.name = name;
            this.value = value;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public double getValue() {
            return value;
        }

        public Color getColor() {
            return color;
        }
    }
}
