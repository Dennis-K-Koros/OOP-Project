package Com.classwork;

import javax.swing.*;
import java.awt.*;

public class SStatements {
    JFrame frame;
    JPanel panel;
    JButton btnCtm,btnExit;
    JTable table;
    JScrollPane scroll;

    SStatements(){
        frame = new JFrame("Statements");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(840,450);
        frame.setLayout(null);

        panel = new JPanel();
        panel.setBounds(100,150,175,80);
        panel.setLayout(new GridLayout(2,1,5,5));

        btnCtm = new JButton("Statements");
        btnCtm.setFocusable(false);

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
        panel.add(btnExit);
        frame.add(panel);
        frame.add(table);
        frame.setVisible(true);
    }

}