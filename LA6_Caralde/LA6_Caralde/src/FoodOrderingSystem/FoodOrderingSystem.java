package FoodOrderingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame{
    private JPanel pMain;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JCheckBox cPizza;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;

    FoodOrderingSystem() {
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox[] FOODLIST = {cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae};
                JRadioButton[] Discounts = {rbNone, rb5, rb10, rb15};
                double price = 0;
                for(JCheckBox cb : FOODLIST){
                    if(cb.isSelected()){
                        if(cb == cPizza){
                            price += 100;
                        } else if (cb == cBurger) {
                            price += 80;
                        } else if (cb == cFries) {
                            price += 65;
                        } else if (cb == cSoftDrinks) {
                            price += 55;
                        } else if (cb == cTea) {
                            price += 50;
                        } else if (cb == cSundae) {
                            price += 40;
                        }
                    }
                }
                if(price==0){
                    JOptionPane.showMessageDialog(null, "Please order something!");
                }else{
                    for(JRadioButton rb : Discounts){
                        if(rb.isSelected()){
                            if(rb == rbNone) break;
                            if(rb == rb5){
                                price *= 0.95;
                                break;
                            }
                            if(rb == rb10){
                                price *= 0.9;
                                break;
                            }
                            if(rb == rb15){
                                price *= 0.85;
                                break;
                            }
                        }
                    }

                    JOptionPane.showMessageDialog(null, "The total price is Php " + String.format("%.2f", price));
                }


            }
        });
    }
    public static void main(String[] args) {
        FoodOrderingSystem fos = new FoodOrderingSystem();
        fos.setTitle("Leap Year Checker");
        fos.setContentPane(fos.pMain);
        fos.setSize(500, 400);
        fos.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fos.setVisible(true);
    }
}
