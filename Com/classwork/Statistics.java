package Com.classwork;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
        btnCtm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getNumberOfCustomers();
            }
        });

        btnSpp = new JButton("Number of Suppliers");
        btnSpp.setFocusable(false);
        btnSpp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getNumberOfSuppliers();
            }
        });

        btnGoods = new JButton("Goods Supplied");
        btnGoods.setFocusable(false);
        btnGoods.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getNumberOfGoods();
            }
        });

        btnOrders = new JButton("Number Of Orders");
        btnOrders.setFocusable(false);
        btnOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getNumberOfOrders();
            }
        });

        btnClear = new JButton("Clear");
        btnClear.setFocusable(false);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.setModel(new DefaultTableModel());
            }
        });

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

    private void getNumberOfOrders() {
        try {

            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT COUNT(*)AS numberOfOrders FROM orders ";
            ResultSet resultSet = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++){
                colName[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(colName);

            String numberOfOrders;
            while (resultSet.next()){
                numberOfOrders = resultSet.getString(1);
                String[]row = {numberOfOrders};
                model.addRow(row);
            }
            stmt.close();
            conn.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void getNumberOfGoods() {
        try {

            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT COUNT(*)AS numberOfGoods FROM Goods ";
            ResultSet resultSet = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++){
                colName[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(colName);

            String numberOfGoods;
            while (resultSet.next()){
                numberOfGoods = resultSet.getString(1);
                String[]row = {numberOfGoods};
                model.addRow(row);
            }
            stmt.close();
            conn.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void getNumberOfSuppliers() {
        try {

            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT COUNT(*)AS numberOfSuppliers FROM Supplier ";
            ResultSet resultSet = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++){
                colName[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(colName);

            String numberOfSuppliers;
            while (resultSet.next()){
                numberOfSuppliers = resultSet.getString(1);
                String[]row = {numberOfSuppliers};
                model.addRow(row);
            }
            stmt.close();
            conn.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void getNumberOfCustomers() {
        try {

            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT COUNT(*)AS numberOfCustomers FROM Customer ";
            ResultSet resultSet = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++){
                colName[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(colName);

            String numberOfCustomers;
            while (resultSet.next()){
                numberOfCustomers = resultSet.getString(1);
                String[]row = {numberOfCustomers};
                model.addRow(row);
            }
            stmt.close();
            conn.close();



        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
