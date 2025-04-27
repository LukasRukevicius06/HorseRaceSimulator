import javax.swing.*;
import java.awt.*;

public class RaceGUI extends JFrame
{
    public static void main(String[] args) {
        JButton startButton = new JButton("Start");
        JButton resetButton = new JButton("Reset");

        // This ensures that the button will be sized to fit its label
        startButton.setSize(startButton.getPreferredSize());
        resetButton.setSize(resetButton.getPreferredSize());
        // Set the position of the button
        startButton.setLocation(300, 250);
        resetButton.setLocation(200, 250);

        startButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "The racing simulator has begun!"));

        JFrame frame = new JFrame("Horse Race Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Use absolute positioning
        frame.add(startButton);
        frame.add(resetButton);
        frame.setSize(1000,500);
        frame.setVisible(true);
    }
}