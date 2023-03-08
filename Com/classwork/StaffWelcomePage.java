package Com.classwork;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StaffWelcomePage {
    JFrame frame;
    JPanel panel;
    JButton btnStatistics,btnAdmin,btnExit;

    StaffWelcomePage(){

        frame = new JFrame("Welcome Staff");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        panel = new JPanel();
        panel.setBounds(120,75,175,150);
        panel.setLayout(new GridLayout(3,1,5,5));

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
        btnExit = new JButton("Exit");
        btnExit.setFocusable(false);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StartUp startUp = new StartUp();
            }
        });


        panel.add(btnStatistics);
        panel.add(btnAdmin);
        panel.add(btnExit);
        frame.add(panel);
        frame.setVisible(true);
    }

}
