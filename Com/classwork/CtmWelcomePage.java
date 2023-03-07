package Com.classwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtmWelcomePage {
    JFrame frame;
    JPanel panel;
    JButton btnOrders,btnPending,btnStatements;

    CtmWelcomePage(){

        frame = new JFrame("Welcome Staff");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        panel = new JPanel();
        panel.setBounds(110,105,175,150);
        panel.setLayout(new GridLayout(3,1,5,5));

        btnOrders = new JButton("Order");
        btnOrders.setFocusable(false);
        btnOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Orders orders = new Orders();
            }
        });

        btnPending = new JButton("Pending Payments");
        btnPending.setFocusable(false);
        btnPending.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                CPendingPayments cpp = new CPendingPayments();
            }
        });

        btnStatements = new JButton("Check Statements");
        btnStatements.setFocusable(false);
        btnStatements.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                CStatements cs = new CStatements();
            }
        });


        panel.add(btnOrders);
        panel.add(btnPending);
        panel.add(btnStatements);
        frame.add(panel);
        frame.setVisible(true);
    }

}
