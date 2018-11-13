import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prova extends JFrame{

    private static JTextField tfInput, tfOutput;
    private static int sum = 0;    // accumulated sum, init to 0







    public static void main(String[] args) {
/*
        Container frame = new JFrame("A Simple GUI");
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(430, 100);

        JPanel panel = new JPanel();

        frame.add(panel);

        JLabel lbl = new JLabel("Select one of the possible choices and click OK");
        lbl.setVisible(true);

        panel.add(lbl);

        String[] choices = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};

        Choice choice = new Choice();
        choice.setName("Choices");
        choice.add(choices[0]);
        choice.add(choices[1]);
        choice.add(choices[2]);
        choice.add(choices[3]);
        choice.add(choices[4]);
        choice.add(choices[5]);
        panel.add(choice);

        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setVisible(true);
        panel.add(cb);

        JButton btn = new JButton("OK");
        panel.add(btn);
*/
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingAccumulator(); // Let the constructor do the job
            }
        });

    }
}
