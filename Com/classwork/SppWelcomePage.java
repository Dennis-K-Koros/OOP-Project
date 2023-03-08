package Com.classwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SppWelcomePage {
    JFrame frame;
    JPanel panel;
    JButton btnDelivery,btnStatements,btnExit;

    SppWelcomePage(){

        frame = new JFrame("Welcome Staff");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        panel = new JPanel();
        panel.setBounds(110,105,175,150);
        panel.setLayout(new GridLayout(3,1,5,5));

        btnDelivery = new JButton("Deliveries");
        btnDelivery.setFocusable(false);
        btnDelivery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Deliveries deliveries = new Deliveries();
            }
        });


        btnStatements = new JButton("Check Statements");
        btnStatements.setFocusable(false);
        btnStatements.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SStatements ss = new SStatements();
            }
        });
        btnExit = new JButton("Exit");
        btnExit.setFocusable(false);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StartUp startUp = new StartUp();
            }
        });


        panel.add(btnDelivery);
        panel.add(btnStatements);
        panel.add(btnExit);
        frame.add(panel);
        frame.setVisible(true);
    }

}
