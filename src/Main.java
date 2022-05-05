import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Main {

  private JFrame frame;
  private JPanel panel;
  private JButton button;


  public void convert(JTextField field1, JTextField field2) {
    try {
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
    } catch (NumberFormatException e) {
      error(e);
    }
  }

  public void reset(JTextField field1, JTextField field2) {
    field1.setText("");
    field2.setText("");
  }

  public void error(NumberFormatException e) {
    JFrame frame2 = new JFrame("Oopps you messed up!");
    frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    frame2.setSize(320, 100);
    frame2.setLocationRelativeTo(null);
    JLabel label3 = new JLabel("ERROR 404! Do something else");
    JPanel panel3 = new JPanel();
    frame2.add(panel3);
    panel3.add(label3);
    JButton button2 = new JButton("OK");
    panel3.add(button2);
    frame2.setVisible(true);
    frame2.setAlwaysOnTop(true);
    button2.addActionListener(f -> frame2.setVisible(false));
  }


  public void HelloActionListener() {
    frame = new JFrame("CurrencyConverter");
    JLabel label = new JLabel("DKK");
    JLabel label2 = new JLabel("USD");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(450, 100);
    frame.setLocationRelativeTo(null);
    frame.add(panel = new JPanel());


    panel.add(label);
    JTextField text = new JTextField(5);
    panel.add(text);
    panel.add(label2);

    JTextField text2 = new JTextField(5);
    panel.add(text2);

    panel.add(button = new JButton("Convert"));
    JButton button2 = (JButton) panel.add(new JButton("Reset"));
    frame.setVisible(true);

    button.addActionListener(e -> convert(text, text2));

    button2.addActionListener(e -> reset(text, text2));

  }

  public static void main(String[] args) {
    new Main().HelloActionListener();
  }
}
