// import statements
import java.awt.*;
import javax.swing.*;

public class GUI
{
    JFrame boardGUI;

    GUI()
    {
        boardGUI = new JFrame();

        for (int i = 0; i < 400; i++) {
            boardGUI.add(new JButton());
        }

        boardGUI.setLayout(new GridLayout(20, 20));
        boardGUI.setSize(500, 500);
        boardGUI.setVisible(true); // Zawsze musi być true
    }

    public static void main(String argvs[])
    {
        new GUI();
    }
}