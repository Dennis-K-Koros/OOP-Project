package Com.classwork;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CStatements {
    JFrame frame;
    JPanel panel;
    JButton btnStatements,btnExit;
    JTable table;
    JScrollPane scroll;

    CStatements(){
        frame = new JFrame("Statements");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(840,450);
        frame.setLayout(null);

        panel = new JPanel();
        panel.setBounds(100,150,175,80);
        panel.setLayout(new GridLayout(2,1,5,5));

        btnStatements = new JButton("Statements");
        btnStatements.setFocusable(false);
        btnStatements.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStatements();
            }
        });

        btnExit = new JButton("Exit");
        btnExit.setFocusable(false);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                CtmWelcomePage cwp = new CtmWelcomePage();
            }
        });

        table = new JTable();
        table.setBounds(420,25,370,350);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);

        scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel.add(btnStatements);
        panel.add(btnExit);
        frame.add(panel);
        frame.add(table);
        frame.setVisible(true);
    }

    private void showStatements() {
        String id;
        id = JOptionPane.showInputDialog("Please enter your Customer Id");
        try {
            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM orders WHERE customerId=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++){
                colName[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(colName);

            String orderId,customerId,goodId,amountSupplied;
            while (resultSet.next()){
                orderId = resultSet.getString(1);
                customerId = resultSet.getString(2);
                goodId = resultSet.getString(3);
                amountSupplied = resultSet.getString(4);
                String[]row = {orderId,customerId,goodId,amountSupplied};
                model.addRow(row);
            }
            stmt.close();
            conn.close();


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
