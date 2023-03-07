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

        btnPending = new JButton("Pending Payments");
        btnPending.setFocusable(false);

        btnStatements = new JButton("Check Statements");
        btnStatements.setFocusable(false);


        panel.add(btnDelivery);
        panel.add(btnPending);
        panel.add(btnStatements);
        frame.add(panel);
        frame.setVisible(true);
    }

}
