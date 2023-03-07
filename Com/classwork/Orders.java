package Com.classwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Orders {
    public Orders order;
    public String oId,cId,gId,amount;
    JFrame frame;
    JLabel orderId, ctmId,goodId,amountSupplied;
    JTextField jtCtm,txtId,txtName,txtPhoneNumber;
    JButton btnOk,btnClear,btnCancel;
    JPanel panel1,panel2,panel3;

    Orders(){
        frame= new JFrame("Deliveries");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        panel1=new JPanel();
        panel1.setLayout(new GridLayout(4,1,5,5));
        panel1.setBounds(50,50,150,160);

        orderId = new JLabel("ORDER ID");
        panel1.add(orderId);

        ctmId=new JLabel("CUSTOMER ID");
        panel1.add(ctmId);

        goodId=new JLabel("GOOD ID");
        panel1.add(goodId);

        amountSupplied=new JLabel("AMOUNT SUPPLIED");
        panel1.add(amountSupplied);

        frame.add(panel1);

        panel2=new JPanel();
        panel2.setLayout(new GridLayout(4,1,5,5));
        panel2.setBounds(200,50,150,160);

        jtCtm = new JTextField();
        panel2.add(jtCtm);

        txtId=new JTextField();
        panel2.add(txtId);

        txtName=new JTextField();
        panel2.add(txtName);

        txtPhoneNumber=new JTextField();
        panel2.add(txtPhoneNumber);

        frame.add(panel2);

        panel3=new JPanel();
        panel3.setLayout(new GridLayout(1,3,5,5));
        panel3.setBounds(50,300,300,40);

        btnOk=new JButton("OK");
        panel3.add(btnOk);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oId1 = jtCtm.getText();
                String cId1 = txtId.getText();
                String gId1 = txtName.getText();
                String amount1=  txtPhoneNumber.getText();
                order  = addOrderToDatabase(oId1,cId1,gId1,amount1);
                good = priceCalculator(gId1,amount1);


            }
        });

        btnClear=new JButton("CLEAR");
        panel3.add(btnClear);

        btnCancel=new JButton("CANCEL");
        panel3.add(btnCancel);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                CtmWelcomePage cwp = new CtmWelcomePage();
            }
        });

        frame.add(panel3);
        frame.setVisible(true);
    }
    public Good good;
    private Good priceCalculator(String gId1,String amount1) {
        try {

            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM goods WHERE goodId=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,gId1);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                good = new Good(gId1);
                good.id = resultSet.getString("GoodId");
                good.name = resultSet.getString("GoodName");
                good.buyingPrice = resultSet.getInt("buyingPrice");
            }
            int amount = Integer.parseInt(amount1);
            int totalCost = good.buyingPrice*amount;
            JOptionPane.showMessageDialog(null,
                    "The Total cost is "+ totalCost,
                    "Delivery",
                    JOptionPane.PLAIN_MESSAGE);


        }catch (Exception e) {
            e.printStackTrace();
        }
        return  good;
    }

    private Orders addOrderToDatabase(String oId1,String cId1,String gId1,String amount1) {
        try {
            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO orders(orderId,customerId,goodId,quantity)" +
                    "VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, oId1);
            preparedStatement.setString(2,cId1);
            preparedStatement.setString(3,gId1);
            preparedStatement.setString(4,amount1);


            int addedRows = preparedStatement.executeUpdate();
            if (addedRows>0){
                order = new Orders();
                order.oId=oId;
                order.cId=cId;
                order.gId=gId;
                order.amount=amount;

            }
            JOptionPane.showMessageDialog(null,
                    "Order Successful",
                    "Order",
                    JOptionPane.PLAIN_MESSAGE);
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }



}
