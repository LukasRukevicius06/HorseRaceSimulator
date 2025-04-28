import javax.swing.*;
import java.awt.*;

public class RaceGUI extends JFrame
{
    public static void main(String[] args)
    {

        JButton startButton = new JButton("Start");
        JButton resetButton = new JButton("Reset");

        // This ensures that the button will be sized to fit its label
        startButton.setSize(startButton.getPreferredSize());
        resetButton.setSize(resetButton.getPreferredSize());
        // Set the position of the button
        startButton.setLocation(300, 250);
        resetButton.setLocation(200, 250);

        startButton.addActionListener(e -> startRace());

        JFrame frame = new JFrame("Horse Race Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Use absolute positioning
        frame.add(startButton);
        frame.add(resetButton);
        frame.setSize(1000,500);
        frame.setVisible(true);
    }

    private static void startRace()
    {
        JFrame setupFrame = new JFrame("Race Setup");
        setupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setupFrame.setLayout(null);

        // declaring the label variables and the button variables for race setup
        JLabel lengthLabel = new JLabel("Enter race length:");
        JLabel horsesLabel = new JLabel("Enter number of horses:");
        JTextField lengthField = new JTextField(30);
        JTextField horsesField = new JTextField(30);
        JButton confirmButton = new JButton("Confirm");

        // setting positioning for the buttons and labels that will setup the race
        lengthLabel.setBounds(50, 30, 200, 30);
        lengthField.setBounds(250, 30, 100, 30);
        horsesLabel.setBounds(50, 80, 200, 30);
        horsesField.setBounds(250, 80, 100, 30);
        confirmButton.setBounds(150, 150, 100, 40);

        confirmButton.addActionListener(e ->
        {
            String lengthText = lengthField.getText();
            String horsesText = horsesField.getText();

            try
            {
                int raceLength = Integer.parseInt(lengthText);
                int numHorses = Integer.parseInt(horsesText);

                JOptionPane.showMessageDialog(setupFrame, "Race Length: " + raceLength + "\nNumber of Horses: " + numHorses, "Setup Complete", JOptionPane.INFORMATION_MESSAGE);
                setupFrame.dispose();
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(setupFrame, "Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setupFrame.add(lengthLabel);
        setupFrame.add(lengthField);
        setupFrame.add(horsesLabel);
        setupFrame.add(horsesField);
        setupFrame.add(confirmButton);

        setupFrame.setSize(450, 300);
        setupFrame.setVisible(true);
    }
}