package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearChecker extends JFrame{
    private JTextField yearTextField;
    private JPanel pMain;
    private JButton checkYearButton;
    LeapYearChecker(){
        checkYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = yearTextField.getText();
                int year = 0;
                try {
                    year = Integer.parseInt(input);
                    boolean isLeapYear = (year % 4 == 0);
                    isLeapYear = isLeapYear && (year % 100 != 0 || year % 400 == 0);
                    if(isLeapYear){
                        JOptionPane.showMessageDialog(null, "Leap year");
                    }else{
                        JOptionPane.showMessageDialog(null, "Not a leap year");
                    }
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Input a valid year!");
                }
            }
        });
    }
    public static void main(String[] args) {
        LeapYearChecker lyc = new LeapYearChecker();
        lyc.setTitle("Leap Year Checker");
        lyc.setContentPane(lyc.pMain);
        lyc.setSize(400, 300);
        lyc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        lyc.setVisible(true);
    }
}
