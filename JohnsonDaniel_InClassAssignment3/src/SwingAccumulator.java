import java.awt.*;       // Using layouts
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing components and containers

// A Swing GUI application inherits the top-level container javax.swing.JFrame
public class SwingAccumulator extends JFrame{
    private JTextField tfInput, tfOutput;
    private int sum = 0;    // accumulated sum, init to 0

    // Constructor to setup the GUI components and event handlers
    public SwingAccumulator() {




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

        String[] choices = {"CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};

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
















        // Retrieve the content-pane of the top-level container JFrame
        // All operations done on the content-pane
        //Container cp = getContentPane();
        //Panel panel2 = new Panel();
        //frame.add(panel2);

        Panel panel2 = new Panel();
        panel.add(panel2);
        panel2.setLayout(new GridLayout(2, 2, 5, 5));  // The content-pane sets its layout

        panel2.add(new JLabel("Enter an Integer: "));
        tfInput = new JTextField(10);
        panel2.add(tfInput);
        panel2.add(new JLabel("The Accumulated Sum is: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);  // read-only
        panel2.add(tfOutput);

        // Allocate an anonymous instance of an anonymous inner class that
        //  implements ActionListener as ActionEvent listener
        tfInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Get the String entered into the input TextField, convert to int
                int numberIn = Integer.parseInt(tfInput.getText());
                sum += numberIn;      // accumulate numbers entered into sum
                tfInput.setText("");  // clear input TextField
                tfOutput.setText(sum + ""); // display sum on the output TextField
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
        setTitle("Swing Accumulator"); // "super" Frame sets title
        setSize(350, 120);  // "super" Frame sets initial size
        setVisible(true);   // "super" Frame shows
    }















    // The entry main() method
    public static void main(String[] args) {
        // Run the GUI construction in the Event-Dispatching thread for thread-safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingAccumulator(); // Let the constructor do the job
            }
        });


        new KeyEventDemo();  // Let the constructor do the job


    }

}


