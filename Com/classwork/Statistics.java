package Com.classwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Statistics {

    JFrame frame;
    JPanel panel;
    JButton btnCtm,btnSpp,btnGoods,btnOrders,btnClear,btnExit;
    JTable table;
    JScrollPane scroll;

    Statistics(){
        frame = new JFrame("Statistics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(840,450);
        frame.setLayout(null);

        panel = new JPanel();
        panel.setBounds(120,75,175,240);
        panel.setLayout(new GridLayout(6,1,5,5));

        btnCtm = new JButton("Number of Customers");
        btnCtm.setFocusable(false);

        btnSpp = new JButton("Number of Suppliers");
        btnSpp.setFocusable(false);

        btnGoods = new JButton("Goods Supplied");
        btnGoods.setFocusable(false);

        btnOrders = new JButton("Number Of Orders");
        btnOrders.setFocusable(false);

        btnClear = new JButton("Clear");
        btnClear.setFocusable(false);

        btnExit = new JButton("Exit");
        btnExit.setFocusable(false);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StaffWelcomePage swp = new StaffWelcomePage();
            }
        });

        table = new JTable();
        table.setBounds(420,25,370,350);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);

        scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel.add(btnCtm);
        panel.add(btnSpp);
        panel.add(btnGoods);
        panel.add(btnOrders);
        panel.add(btnClear);
        panel.add(btnExit);
        frame.add(panel);
        frame.add(table);
        frame.setVisible(true);
    }

}
