import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Button Pressed");
    }
}
public class Buttons implements ActionListener
{
    private JButton red, blue;
    private Container c;
    private JFrame app;

    public Buttons()
    {
        app = new JFrame();

        red = new JButton("Red");
        blue = new JButton("Blue");
//implementing the action listener


        red.addActionListener(this);
        blue.addActionListener(this);

        c = app.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(red);
        c.add(blue);

        app.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        app.setSize(300, 150);
        app.setVisible(true);
    }

    public static void main(String[] args)
    {
        Buttons b = new Buttons();
    }

//registering this as the listener for both buttons


    public void actionPerformed(ActionEvent e)
    {
//this is called when an action event occurs


        String cmd = e.getActionCommand();
        if (cmd.equals("Red"))
            c.setBackground(Color.red);
        if (cmd.equals("Blue"))
            c.setBackground(Color.blue);
    }
}
