package Com.classwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SppWelcomePage {
    JFrame frame;
    JPanel panel;
    JButton btnDelivery,btnPending,btnStatements;

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

        btnPending = new JButton("Pending Payments");
        btnPending.setFocusable(false);
        btnPending.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SPendingPayments spp = new SPendingPayments();
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


        panel.add(btnDelivery);
        panel.add(btnPending);
        panel.add(btnStatements);
        frame.add(panel);
        frame.setVisible(true);
    }

}
