package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;

public class Gui {
    private JTextField textField1;
        private JTextField textField2;
        private JTextField textField3;
        private JTextField textField4;
        private String amount;
        private String inputU;
        private String outputU;
        private JButton startButton;
    private JPanel Panel;
    private JTextArea supportsTheseBGNCADTextArea;
    Data d = new Data();

    public Gui() { textField3.addFocusListener(new FocusAdapter() { } );
        textField4.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                amount = textField4.getText();
            }
        });
        textField3.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                inputU = textField3.getText();
            }
        });
        textField2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                outputU = textField2.getText();
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double result = d.convert(amount,inputU,outputU);
                DecimalFormat df = new DecimalFormat(".##");
                String twoDecimal = df.format(result);
                textField1.setText("It would be about "+ twoDecimal+ outputU);
            }
        });
    }public static void main(String[] args) {
        JFrame frame = new JFrame("Gui");
        frame.setContentPane(new Gui().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
