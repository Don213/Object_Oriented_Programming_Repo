import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.Scanner;




public class Calculator extends Frame{








    public static void main(String[] args)
    {
        Frame frame = new Frame();
        JPanel panel  = new JPanel(new GridLayout());
        //GridBagConstraints constraints = new GridBagConstraints();
        //constraints.anchor = GridBagConstraints.NORTH;
        //constraints.insets = new Insets(50,50,50,50);
        frame.setSize(new Dimension(100,100));



        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");

        button1.setSize(50,50);
        button2.setSize(50,50);
        button3.setSize(50,50);
        button4.setSize(50,50);
        button5.setSize(50,50);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);



        frame.add(panel);
        frame.setVisible(true);
        panel.setVisible(true);










    Scanner sc = new Scanner(System.in);
    sc.next();


    }
}
