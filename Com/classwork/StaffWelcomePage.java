package Com.classwork;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StaffWelcomePage {
    JFrame frame;
    JPanel panel;
    JButton btnStatistics,btnAdmin,btnPending,btnProfit;

    StaffWelcomePage(){

        frame = new JFrame("Welcome Staff");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        panel = new JPanel();
        panel.setBounds(120,75,175,200);
        panel.setLayout(new GridLayout(4,1,5,5));

        btnStatistics = new JButton("Statistics");
        btnStatistics.setFocusable(false);
        btnStatistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Statistics statistics = new Statistics();
            }
        });

        btnAdmin = new JButton("Admin");
        btnAdmin.setFocusable(false);
        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Admin admin = new Admin();
            }
        });

        btnPending = new JButton("Pending Payments");
        btnPending.setFocusable(false);
        btnPending.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                PendingPayments pp = new PendingPayments();
            }
        });

        btnProfit = new JButton("Grocery's Expenditures");
        btnProfit.setFocusable(false);
        btnProfit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GroceryProfit gp = new GroceryProfit();
            }
        });

        panel.add(btnStatistics);
        panel.add(btnAdmin);
        panel.add(btnPending);
        panel.add(btnProfit);
        frame.add(panel);
        frame.setVisible(true);
    }

}
