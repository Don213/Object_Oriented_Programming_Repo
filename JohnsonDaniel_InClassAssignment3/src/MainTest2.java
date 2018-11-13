import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainTest2 extends Frame implements KeyListener{

    private TextField tfInput;  // Single-line TextField to receive tfInput key
    private TextArea taDisplay; // Multi-line TextArea to taDisplay result

    private JTextField tfInput2, tfOutput;
    private int sum = 0;    // accumulated sum, init to 0


    public MainTest2() {
        setLayout(new FlowLayout()); // "super" frame sets to FlowLayout

        add(new Label("Enter Text: "));
        tfInput = new TextField(10);
        add(tfInput);
        taDisplay = new TextArea(5, 40); // 5 rows, 40 columns
        add(taDisplay);

        tfInput.addKeyListener(this);
        // tfInput TextField (source) fires KeyEvent.
        // tfInput adds "this" object as a KeyEvent listener.

        setTitle("KeyEvent Demo"); // "super" Frame sets title
        setSize(400, 200);         // "super" Frame sets initial size
        setVisible(true);          // "super" Frame shows
    }


    MainTest2(int one) {


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

        String[] choices = {"CHOICE 1", "CHOICE 2", "CHOICE 3", "CHOICE 4", "CHOICE 5", "CHOICE 6"};

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
        tfInput2 = new JTextField(10);
        panel2.add(tfInput);
        panel2.add(new JLabel("The Accumulated Sum is: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);  // read-only
        panel2.add(tfOutput);

        // Allocate an anonymous instance of an anonymous inner class that
        //  implements ActionListener as ActionEvent listener
        tfInput2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Get the String entered into the input TextField, convert to int
                int numberIn = Integer.parseInt(tfInput.getText());
                sum += numberIn;      // accumulate numbers entered into sum
                tfInput.setText("");  // clear input TextField
                tfOutput.setText(sum + ""); // display sum on the output TextField
            }
        });

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
        setTitle("Swing Accumulator"); // "super" Frame sets title
        setSize(350, 120);  // "super" Frame sets initial size
        setVisible(true);   // "super" Frame shows
    }


    public static void main(String[] args)
    {
        MainTest2();
        MainTest2(1);
        //new KeyEventDemo();
    }


    /** KeyEvent handlers */
    // Called back when a key has been typed (pressed and released)
    @Override
    public void keyTyped(KeyEvent evt) {
        taDisplay.append("You have typed " + evt.getKeyChar() + "\n");
    }
    // Not Used, but need to provide an empty body for compilation
    @Override public void keyPressed(KeyEvent evt) { }
    @Override public void keyReleased(KeyEvent evt) { }
}
