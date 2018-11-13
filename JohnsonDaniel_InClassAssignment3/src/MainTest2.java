import java.awt.*;       // Using layouts
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing components and containers
import javax.swing.border.EmptyBorder;

public class MainTest2 extends Frame implements KeyListener {

    private TextField tfInput;  // Single-line TextField to receive tfInput key
    private TextArea taDisplay; // Multi-line TextArea to taDisplay result


    //private Panel panel = new Panel();
    //private JFrame frame = new JFrame();

    private JTextField tfInput2, tfOutput2;
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
        ////////////////////////////////////////////////////////////////////////////

        JLabel lbl = new JLabel("Select one of the possible choices and click OK");
        lbl.setVisible(true);



        String[] choices = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};

        Choice choice = new Choice();
        choice.add(choices[0]);
        choice.add(choices[2]);
        choice.add(choices[3]);
        choice.add(choices[4]);
        choice.add(choices[5]);




        final JComboBox<String> cb = new JComboBox<String>(choices);

        cb.setVisible(true);

        ////////////////////////////////////////////////////////////////////////////

        Panel cp = new Panel();
        cp.setLayout(new GridLayout(2, 2, 5, 5));  // The content-pane sets its layout

        cp.add(new JLabel("Enter an Integer: "));
        tfInput2 = new JTextField(10);
        cp.add(tfInput2);
        cp.add(new JLabel("The Accumulated Sum is: "));
        tfOutput2 = new JTextField(10);
        tfOutput2.setEditable(false);  // read-only
        cp.add(tfOutput2);

        // Allocate an anonymous instance of an anonymous inner class that
        //  implements ActionListener as ActionEvent listener
        tfInput2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Get the String entered into the input TextField, convert to int
                int numberIn = Integer.parseInt(tfInput2.getText());
                sum += numberIn;      // accumulate numbers entered into sum
                tfInput2.setText("");  // clear input TextField
                tfOutput2.setText(sum + ""); // display sum on the output TextField
            }
        });













    ////////////////////////////////////////////////////////////////////////////


        JPanel container1 = new JPanel();
        JPanel container2 = new JPanel();
        JPanel container3 = new JPanel();

        container1.add(cp);
        container2.add(choice);
        container2.add(lbl);


        add(container1,BorderLayout.NORTH);
        add(container3,BorderLayout.CENTER);
        add(container2,BorderLayout.PAGE_END);
        setTitle("Consolidated item frame"); // "super" Frame sets title
        setSize(600, 400);         // "super" Frame sets initial size
        setVisible(true);          // "super" Frame shows



    }


    public static void main(String[] args) {
        new MainTest2();
    }


    /**
     * KeyEvent handlers
     */
// Called back when a key has been typed (pressed and released)
    @Override
    public void keyTyped(KeyEvent evt) {
        taDisplay.append("You have typed " + evt.getKeyChar() + "\n");
    }

    // Not Used, but need to provide an empty body for compilation
    @Override
    public void keyPressed(KeyEvent evt) {
    }

    @Override
    public void keyReleased(KeyEvent evt) {
    }

}