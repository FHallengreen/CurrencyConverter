import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private JFrame frame;
    private JPanel panel;
    private JButton button;

    public void convert(JTextField field1, JTextField field2) {
        if (field1.getText().equals("")) {
            double getValue = Double.parseDouble(field2.getText());
            getValue *= 7.06;
            double twoDecimal = Math.floor(getValue * 100) / 100;
            field1.setText(String.valueOf(twoDecimal));
        } else {
            double getValue = Double.parseDouble(field1.getText());
            getValue *= 0.14;
            double twoDecimal = Math.floor(getValue * 100) / 100;
            field2.setText(String.valueOf(twoDecimal));
        }
    }

    public void HelloActionListener() {
        frame = new JFrame("CurrencyConverter");
        JLabel label = new JLabel("DKK");
        JLabel label2 = new JLabel("USD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.add(panel = new JPanel());

        panel.add(label);
        JTextField text = new JTextField(5);
        panel.add(text);
        panel.add(label2);

        JTextField text2 = new JTextField(5);
        panel.add(text2);

        panel.add(button = new JButton("Convert"));
        frame.setVisible(true);
        button.addActionListener(e -> {
            convert(text, text2);
              /*  double getValue = Double.parseDouble(text.getText());
                getValue *= 0.16;
                text2.setText(String.valueOf(getValue));*/
        });

    }

    public static void main(String[] args) {
        new Main().HelloActionListener();
    }
}
