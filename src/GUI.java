// import statements
import java.awt.*;
import javax.swing.*;

public class GUI
{
    JFrame frameObj;

    GUI()
    {
        frameObj = new JFrame();

        // creating 9 buttons
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");

        frameObj.add(btn1); frameObj.add(btn2); frameObj.add(btn3);
        frameObj.add(btn4); frameObj.add(btn5); frameObj.add(btn6);
        frameObj.add(btn7); frameObj.add(btn8); frameObj.add(btn9);


        frameObj.setLayout(new GridLayout());
        frameObj.setSize(300, 300);
        frameObj.setVisible(true); // Zawsze musi być true
    }

    public static void main(String argvs[])
    {
        new GUI();
    }
}