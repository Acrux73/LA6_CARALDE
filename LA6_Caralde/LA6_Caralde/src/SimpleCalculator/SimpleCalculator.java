package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame{
    private JPanel pMain;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField tfNumber2;
    private JTextField lblResult;
    private JButton btnCompute;

    SimpleCalculator() {
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number1 = tfNumber1.getText();
                String number2 = tfNumber2.getText();
                int num1;
                int num2;
                double result = 0;
                try {
                    num1 = Integer.parseInt(number1);
                    num2 = Integer.parseInt(number2);
                    switch(cbOperations.getSelectedIndex()){
                        case 0: // +
                            result = num1 + num2;
                            break;
                        case 1: // -
                            result = num1 - num2;
                            break;
                        case 2: // *
                            result = num1 * num2;
                            break;
                        case 3: // /
                            result = num1 / num2;
                            break;
                    }
                    lblResult.setText(String.format("%.0f", result));
                } catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(null, "Enter a valid number!");
                } catch (ArithmeticException e1){
                    JOptionPane.showMessageDialog(null, "Error dividing by zero!");
                }

            }
        });
    }
    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setTitle("Leap Year Checker");
        calculator.setContentPane(calculator.pMain);
        calculator.setSize(800, 400);
        calculator.setDefaultCloseOperation(EXIT_ON_CLOSE);
        calculator.setVisible(true);
    }
}
