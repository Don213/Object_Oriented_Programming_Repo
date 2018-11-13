import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.io.*;
import javax.swing.*;
import java.util.Scanner;




public class Calculator extends JPanel /*implements KeyListener*/ {
    private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12,
            button13, button14, button15, button16;

    private JTextField jtf = new JTextField();

    private GridBagConstraints gbc;

    private float tempValue = 0, currentValue = 0;
    private int signal = 0, signal2 = 0;


    private void changeValue(int num)
    {
        if (signal == 0) {
            if (currentValue == 0) {
                currentValue = num;
                jtf.setText(Integer.toString((int)currentValue));
            } else {
                if(signal2 == 0)
                {
                    currentValue = Integer.parseInt((Integer.toString((int)currentValue) + Integer.toString(num)));
                    jtf.setText(Integer.toString((int)currentValue));
                }
                else{
                    currentValue = num;
                    tempValue = 0;
                    jtf.setText(Integer.toString((int)currentValue));
                    signal2 = 0;
                }
            }
        } else {
            if (tempValue == 0) {
                tempValue = num;
                jtf.setText(Integer.toString((int)tempValue));
            } else {
                if(signal2 > 0) {
                    tempValue = Integer.parseInt((Integer.toString((int)tempValue) + Integer.toString(num)));
                    jtf.setText(Integer.toString((int)tempValue));
                }
                else{

                }
            }
        }

    }


    private void algorithmSelection()
    {
        if(!(signal == 0)) {
            signal2 = 1;
            if (!(currentValue == 0 && tempValue == 0)) {
                if (signal == 1) {
                    currentValue = currentValue + tempValue;
                    tempValue = 0;
                } else if (signal == 2) {
                    currentValue = currentValue - tempValue;
                    tempValue = 0;
                } else if (signal == 3) {
                    currentValue = currentValue * tempValue;
                    tempValue = 0;
                } else if (signal == 4) {
                    if (tempValue == 0) {
                        JFrame frame = new JFrame();
                        Panel panel = new Panel();
                        frame.add(panel);
                        JLabel label = new JLabel("You're Silly! You cannot divide by 0! :)");
                        label.setSize(300, 300);
                        label.setFont(new Font("SansSerif", Font.BOLD, 50));
                        panel.add(label);

                        frame.setTitle("Warning");
                        frame.setSize(1000, 200);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);
                        frame.setResizable(true);
                    } else {
                        currentValue = currentValue / tempValue;
                        tempValue = 0;
                    }
                }
            }
        }
    }



    class zero implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            changeValue(0);
        }
    }

    class one implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            changeValue(1);
        }
    }

    class two implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            changeValue(2);
        }
    }




    //These are listeners for each button on the calculator
    //and their names indicate their button assignment and function
    class three implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            changeValue(3);
        }
    }

    class four implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            changeValue(4);
        }
    }

    class five implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            changeValue(5);
        }
    }

    class six implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            changeValue(6);
        }
    }

    class seven implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            changeValue(7);
        }
    }

    class eight implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            changeValue(8);
        }
    }

    class nine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            changeValue(9);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////

    class plus implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            algorithmSelection();
            signal = 1;
            jtf.setText(Float.toString(tempValue));
        }
    }

    class minus implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            algorithmSelection();
            signal = 2;
            jtf.setText(Float.toString(tempValue));
        }
    }

    class multiply implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            algorithmSelection();
            signal = 3;
            jtf.setText(Float.toString(tempValue));
        }
    }

    class divide implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            algorithmSelection();
            signal = 4;
            jtf.setText(Float.toString(tempValue));
        }
    }

    class equals implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            algorithmSelection();
            signal = 0;
            jtf.setText(Float.toString(currentValue));
        }
    }

    class reset implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            tempValue = 0;
            currentValue = 0;
            signal = 0;
            jtf.setText(Float.toString(currentValue));
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////









    //This is a constructor that makes a window show up with a functioning calculator.
    public Calculator() {
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        setSize(new Dimension(200, 200));
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);



        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jtf.setEditable(false);
        add(jtf, gbc);
        gbc.gridwidth = 1;

        button1 = new JButton("0");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(button1, gbc);
        button1.addActionListener(new zero());

        button2 = new JButton("1");
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(button2, gbc);
        button2.addActionListener(new one());

        button3 = new JButton("2");
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(button3, gbc);
        button3.addActionListener(new two());

        button4 = new JButton("3");
        gbc.gridx = 3;
        gbc.gridy = 1;
        add(button4, gbc);
        button4.addActionListener(new three());

        button5 = new JButton("4");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(button5, gbc);
        button5.addActionListener(new four());

        button6 = new JButton("5");
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(button6, gbc);
        button6.addActionListener(new five());

        button7 = new JButton("6");
        gbc.gridx = 2;
        gbc.gridy = 2;
        add(button7, gbc);
        button7.addActionListener(new six());

        button8 = new JButton("7");
        gbc.gridx = 3;
        gbc.gridy = 2;
        add(button8, gbc);
        button8.addActionListener(new seven());

        button9 = new JButton("8");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(button9, gbc);
        button9.addActionListener(new eight());

        button10 = new JButton("9");
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(button10, gbc);
        button10.addActionListener(new nine());

        button11 = new JButton("+");
        gbc.gridx = 2;
        gbc.gridy = 3;
        add(button11, gbc);
        button11.addActionListener(new plus());

        button12 = new JButton("-");
        gbc.gridx = 3;
        gbc.gridy = 3;
        add(button12, gbc);
        button12.addActionListener(new minus());

        button13 = new JButton("*");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(button13, gbc);
        button13.addActionListener(new multiply());

        button14 = new JButton("/");
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(button14, gbc);
        button14.addActionListener(new divide());

        button15 = new JButton("=");
        gbc.gridx = 2;
        gbc.gridy = 4;
        add(button15, gbc);
        button15.addActionListener(new equals());

        button16 = new JButton("Reset");
        gbc.gridx = 3;
        gbc.gridy = 4;
        add(button16, gbc);
        button16.addActionListener(new reset());


        setVisible(true);
        //calcPress();

    }




    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        JFrame jf = new JFrame();


        jf.setTitle("Calculator");
        jf.setSize(300, 300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.add(calculator);
        jf.setResizable(false);
    }
}



