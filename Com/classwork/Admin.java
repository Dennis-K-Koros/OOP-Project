package Com.classwork;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


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

        table = new JTable();
        table.setBounds(420,25,370,350);


        scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        btnCtm = new JButton("Customers");
        btnCtm.setFocusable(false);
        btnCtm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCustomers();
            }
        });

        btnSpp = new JButton("Suppliers");
        btnSpp.setFocusable(false);
        btnSpp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getSuppliers();
            }
        });

        btnGoods = new JButton("Goods");
        btnGoods.setFocusable(false);
        btnGoods.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getGoods();
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

        panel.add(btnCtm);
        panel.add(btnSpp);
        panel.add(btnGoods);
        panel.add(btnClear);
        panel.add(btnExit);
        frame.add(panel);
        frame.add(table);
        frame.setVisible(true);
    }

    private void getGoods() {
        try {

            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM goods";
            ResultSet resultSet = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++){
                colName[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(colName);

            String GoodId,GoodName,buyingPrice;
            while (resultSet.next()){
                GoodId = resultSet.getString(1);
                GoodName = resultSet.getString(2);
                buyingPrice = resultSet.getString(3);
                String[]row = {GoodId,GoodName,buyingPrice};
                model.addRow(row);
            }
            stmt.close();
            conn.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private void getSuppliers() {
        try {

            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM supplier";
            ResultSet resultSet = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++){
                colName[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(colName);

            String SupplierId,natId,SupplierName,phoneNumber,emailAddress,goodsSupplied,Password;
            while (resultSet.next()){
                SupplierId = resultSet.getString(1);
                natId = resultSet.getString(2);
                SupplierName = resultSet.getString(3);
                phoneNumber = resultSet.getString(4);
                emailAddress = resultSet.getString(5);
                goodsSupplied = resultSet.getString(6);
                Password = resultSet.getString(7);
                String[]row = {SupplierId,natId,SupplierName,phoneNumber,emailAddress,goodsSupplied,Password};
                model.addRow(row);
            }
            stmt.close();
            conn.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private void getCustomers() {

        try {

            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Customer";
            ResultSet resultSet = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++){
                colName[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(colName);

            String ctmId,natId,CustomerName,phoneNumber,emailAddress,Password;
            while (resultSet.next()){
                ctmId = resultSet.getString(1);
                natId = resultSet.getString(2);
                CustomerName = resultSet.getString(3);
                phoneNumber = resultSet.getString(4);
                emailAddress = resultSet.getString(5);
                Password = resultSet.getString(6);
                String[]row = {ctmId,natId,CustomerName,phoneNumber,emailAddress,Password};
                model.addRow(row);
            }
            stmt.close();
            conn.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}

