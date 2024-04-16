package lab3gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooser extends JFrame {

    private JComboBox<String> colorDropdown;
    private JTextField colorTextField;
    private CirclePanel circlePanel;

    public ColorChooser() {
        // Dropdown for color choices
        String[] colors = {"Red", "Blue", "Green"};
        colorDropdown = new JComboBox<>(colors);
        colorDropdown.addActionListener(new ColorActionListener());

        // Text field for displaying the selected color
        colorTextField = new JTextField();
        colorTextField.setEditable(false);

        // Panel for drawing the circle
        circlePanel = new CirclePanel();

        // Layout setup
        this.setLayout(new BorderLayout());
        this.add(colorDropdown, BorderLayout.NORTH);
        this.add(colorTextField, BorderLayout.SOUTH);
        this.add(circlePanel, BorderLayout.CENTER);

        // Frame setup
        this.setTitle("Color Chooser");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // Main method to run the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColorChooser());
    }

    // Listener for color dropdown
    private class ColorActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selectedColor = (String) colorDropdown.getSelectedItem();
            colorTextField.setText(selectedColor);
            circlePanel.setColor(selectedColor);
        }
    }

    // Panel for drawing the circle
    private class CirclePanel extends JPanel {
        private Color color;

        public CirclePanel() {
            this.color = Color.WHITE; // Initial clear color
        }

        public void setColor(String colorStr) {
            switch (colorStr) {
                case "Red":
                    this.color = Color.RED;
                    break;
                case "Blue":
                    this.color = Color.BLUE;
                    break;
                case "Green":
                    this.color = Color.GREEN;
                    break;
                default:
                    this.color = Color.WHITE;
            }
            repaint(); // Repaint the panel with the new color
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(this.color);
            g.fillOval(50, 50, getWidth() - 100, getHeight() - 100); // Draw the circle
        }
    }
}


