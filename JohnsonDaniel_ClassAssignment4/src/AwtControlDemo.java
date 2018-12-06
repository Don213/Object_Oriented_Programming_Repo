//package com.tutorialspoint.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AwtControlDemo {

    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Label statusLabel2;
    private Panel controlPanel;

    public AwtControlDemo(){
        prepareGUI();
    }

    public static void main(String[] args){
        AwtControlDemo awtControlDemo = new AwtControlDemo();
        awtControlDemo.showEventDemo();
    }

    private void prepareGUI(){
        mainFrame = new Frame("Java AWT Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(4, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel2 = new Label();
        statusLabel2.setAlignment(Label.CENTER);
        //statusLabel.setPreferredSize(new Dimension(100,100));


        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());


        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel2);
        mainFrame.add(statusLabel);


        mainFrame.setVisible(true);
    }

    private void showEventDemo(){
        headerLabel.setText("Control in action: Button");

        Button okButton = new Button("Apply");
        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");
        Button tryAgainButton = new Button("Try Again");


        okButton.setActionCommand("Apply");
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Cancel");
        tryAgainButton.setActionCommand("Try Again");

        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());
        tryAgainButton.addActionListener(new ButtonClickListener());

        controlPanel.add(okButton);
        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);
        controlPanel.add(tryAgainButton);

        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if( command.equals( "Apply" ))  {
                statusLabel.setText("Apply Button clicked.");
                statusLabel2.setText("");
            }
            else if( command.equals( "Submit" ) )  {
                statusLabel.setText("Submit Button clicked.");
                statusLabel2.setText("");
            }
            else if (command.equals( "Try Again" ) )  {
                statusLabel2.setText("Try Again Button clicked.");
                statusLabel.setText("");
            }
            else  {
                statusLabel.setText("Cancel Button clicked.");
                statusLabel2.setText("");
            }
        }
    }
}
