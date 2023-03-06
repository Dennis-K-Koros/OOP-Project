package Com.classwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SppLogin extends JFrame  {
    JFrame frame;
    JLabel sppId, id,name,phoneNumber,emailAddress,password,goods;
    JTextField jtSpp,txtId,txtName,txtPhoneNumber,txtEmailAddress,tfGoods;
    JPasswordField pfPassword;
    JButton btnSignUp,btnSignIn,btnCancel;
    JPanel panel1,panel2,panel3;

    SppLogin(){
        frame= new JFrame("LOGIN");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);

        panel1=new JPanel();
        panel1.setLayout(new GridLayout(7,1,5,5));
        panel1.setBounds(50,50,150,200);

        sppId = new JLabel("SUPPLIER ID");
        panel1.add(sppId);

        id=new JLabel("NATIONAL ID");
        panel1.add(id);

        name=new JLabel("NAME");
        panel1.add(name);

        phoneNumber=new JLabel("PHONE NUMBER");
        panel1.add(phoneNumber);

        emailAddress=new JLabel("EMAIL ADDRESS");
        panel1.add(emailAddress);

        goods = new JLabel("GOODS SUPPLIED");
        panel1.add(goods);

        password=new JLabel("PASSWORD");
        panel1.add(password);

        frame.add(panel1);

        panel2=new JPanel();
        panel2.setLayout(new GridLayout(7,1,5,5));
        panel2.setBounds(200,50,150,200);

        jtSpp = new JTextField();
        panel2.add(jtSpp);

        txtId=new JTextField();
        panel2.add(txtId);

        txtName=new JTextField();
        panel2.add(txtName);

        txtPhoneNumber=new JTextField();
        panel2.add(txtPhoneNumber);

        txtEmailAddress=new JTextField();
        panel2.add(txtEmailAddress);

        tfGoods = new JTextField();
        panel2.add(tfGoods);

        pfPassword = new JPasswordField();
        panel2.add(pfPassword);

        frame.add(panel2);

        panel3=new JPanel();
        panel3.setLayout(new GridLayout(1,3,5,5));
        panel3.setBounds(50,300,300,40);

        btnSignUp=new JButton("SIGN UP");
        btnSignUp.setFocusable(false);
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerSupplier();
            }
        });
        panel3.add(btnSignUp);

        btnSignIn=new JButton("SIGN IN");
        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SppSignIn sppSignIn = new SppSignIn();
            }
        });
        panel3.add(btnSignIn);

        btnCancel=new JButton("CANCEL");
        panel3.add(btnCancel);

        frame.add(panel3);
        frame.setVisible(true);
    }

    private void registerSupplier() {
        String staffId = jtSpp.getText();
        String natId = txtId.getText();
        String name = txtName.getText();
        String phone = txtPhoneNumber.getText();
        String email = txtEmailAddress.getText();
        String goodsSupplied = tfGoods.getText();
        String password = String.valueOf(pfPassword.getPassword());

        if (name.isEmpty() || email.isEmpty() || natId.isEmpty() || phone.isEmpty() || password.isEmpty() || staffId.isEmpty() ||goodsSupplied.isEmpty() ){
            JOptionPane.showMessageDialog(this,
                    "Please Enter All Fields",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
        }

        suppliers=addSuppliersToDatabase(staffId,natId,name,phone,email,password,goodsSupplied);
    }
    public Suppliers suppliers;
    private Suppliers addSuppliersToDatabase(String staffId, String natId, String name, String phone, String email, String password,String goodsSupplied) {

        try{

            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO supplier(staffId,natId,staffName,PhoneNumber,emailAddress,goodsSupplied,Password)"+
                    "VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,staffId);
            preparedStatement.setString(2,natId);
            preparedStatement.setString(3,name);
            preparedStatement.setString(4,phone);
            preparedStatement.setString(5,email);
            preparedStatement.setString(6,goodsSupplied);
            preparedStatement.setString(7,password);


            int addedRows = preparedStatement.executeUpdate();
            if (addedRows>0){
                suppliers = new Suppliers( staffId, natId,name, phone, email,password,goodsSupplied);
                suppliers.Id=natId;
                suppliers.name=name;
                suppliers.phoneNumber=phone;
                suppliers.emailAddress=email;
                suppliers.password = password;
                suppliers.goodsSupplied = goodsSupplied;
            }

            stmt.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return suppliers;

    }


}
