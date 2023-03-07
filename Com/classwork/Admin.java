package Com.classwork;


import javax.swing.*;
import java.awt.*;

public class Admin {

    JFrame frame;
    JPanel panel;
    JButton btnCtm,btnSpp,btnGoods,btnClear,btnExit;
    JTable table;
    JScrollPane scroll;

    Admin(){
        frame = new JFrame("Administrator Privileges");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(840,450);
        frame.setLayout(null);

        panel = new JPanel();
        panel.setBounds(120,75,175,200);
        panel.setLayout(new GridLayout(5,1,5,5));

        btnCtm = new JButton("Customers");
        btnCtm.setFocusable(false);

        btnSpp = new JButton("Suppliers");
        btnSpp.setFocusable(false);

        btnGoods = new JButton("Goods");
        btnGoods.setFocusable(false);

        btnClear = new JButton("Clear");
        btnClear.setFocusable(false);

        btnExit = new JButton("Exit");
        btnExit.setFocusable(false);

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
        panel.add(btnClear);
        panel.add(btnExit);
        frame.add(panel);
        frame.add(table);
        frame.setVisible(true);
    }

}

