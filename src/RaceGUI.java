import javax.swing.*;
import java.awt.*;

public class RaceGUI extends JFrame
{

    private JButton startButton;
    private JButton resetButton;

    public RaceGUI()
    {
        setTitle("Horse Race Simulator");
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        startButton = new JButton("Start");
        resetButton = new JButton("Reset");

        add(startButton);
        add(resetButton);
    }

    public static void main(String[] args)
    {
            new RaceGUI().setVisible(true);
    }
}