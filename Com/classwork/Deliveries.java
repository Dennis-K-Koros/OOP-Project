package Com.classwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Deliveries {
    public String id;
    public String sppId;
    public String gdId;
    public String amSupplied;
    JFrame frame;
    JLabel deliveryId, supplierId,goodId,phoneNumber;
    JTextField jtCtm,txtId,txtName,txtPhoneNumber;
    JButton btnOk,btnClear,btnCancel;
    JPanel panel1,panel2,panel3;
    public Deliveries delivery;

    Deliveries(){
        frame= new JFrame("Deliveries");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        panel1=new JPanel();
        panel1.setLayout(new GridLayout(4,1,5,5));
        panel1.setBounds(50,50,150,160);

        deliveryId = new JLabel("DELIVERY ID");
        panel1.add(deliveryId);

        supplierId=new JLabel("SUPPLIER ID");
        panel1.add(supplierId);

        goodId=new JLabel("GOOD ID");
        panel1.add(goodId);

        phoneNumber=new JLabel("AMOUNT SUPPLIED");
        panel1.add(phoneNumber);

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
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deliveryId = jtCtm.getText();
                String supplierId = txtId.getText();
                String goodId = txtName.getText();
                String amountSupplied =  txtPhoneNumber.getText();
                delivery = addDeliveryToDatabase(deliveryId,supplierId,goodId,amountSupplied);
                good = priceCalculator(goodId,amountSupplied);
            }
        });
        panel3.add(btnOk);

        btnClear=new JButton("CLEAR");
        panel3.add(btnClear);

        btnCancel=new JButton("CANCEL");
        panel3.add(btnCancel);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SppWelcomePage swp = new SppWelcomePage();
            }
        });

        frame.add(panel3);
        frame.setVisible(true);
    }
public Good good;
    private Good priceCalculator(String goodId,String amountSupplied) {
        try {

            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM goods WHERE goodId=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,goodId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                good = new Good(id);
                good.id = resultSet.getString("GoodId");
                good.name = resultSet.getString("GoodName");
                good.buyingPrice = resultSet.getInt("buyingPrice");
            }
            int amount = Integer.parseInt(amountSupplied);
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

    private Deliveries addDeliveryToDatabase(String deliveryId,String supplierId,String goodId,String amountSupplied) {
        try {
            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO deliveries(deliveryId,supplierId,goodId,amountSupplied)" +
                    "VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, deliveryId);
            preparedStatement.setString(2,supplierId);
            preparedStatement.setString(3,goodId);
            preparedStatement.setString(4,amountSupplied);


            int addedRows = preparedStatement.executeUpdate();
            if (addedRows>0){
                delivery = new Deliveries();
                delivery.id=deliveryId;
                delivery.sppId=supplierId;
                delivery.gdId=goodId;
                delivery.amSupplied=amountSupplied;

            }
            JOptionPane.showMessageDialog(null,
                    "Delivery Successful",
                    "Delivery",
                    JOptionPane.PLAIN_MESSAGE);
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return delivery;
    }
}


