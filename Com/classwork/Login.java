package Com.classwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
     JFrame frame;
     JLabel Id,name,phoneNumber,emailAddress,password;
     JTextField txtId,txtName,txtPhoneNumber,txtEmailAddress,txtPassword;
     JButton btnSignUp,btnSignIn,btnCancel;
     JPanel panel1,panel2,panel3;

    Login(){
        frame= new JFrame("LOGIN");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);

        panel1=new JPanel();
        panel1.setLayout(new GridLayout(5,1,5,5));
        panel1.setBounds(50,50,150,200);

        Id=new JLabel("ID");
        Id.setSize(60,30);
        panel1.add(Id);

        name=new JLabel("NAME");
        name.setSize(60,30);
        panel1.add(name);

        phoneNumber=new JLabel("PHONE NUMBER");
        phoneNumber.setSize(60,30);
        panel1.add(phoneNumber);

        emailAddress=new JLabel("EMAIL ADDRESS");
        emailAddress.setSize(60,30);
        panel1.add(emailAddress);

        password=new JLabel("PASSWORD");
        password.setSize(60,30);
        panel1.add(password);

        frame.add(panel1);

        panel2=new JPanel();
        panel2.setLayout(new GridLayout(5,1,5,5));
        panel2.setBounds(200,50,150,200);

        txtId=new JTextField();
        txtId.setSize(150,30);
        panel2.add(txtId);

        txtName=new JTextField();
        txtName.setSize(150,30);
        panel2.add(txtName);

        txtPhoneNumber=new JTextField();
        txtPhoneNumber.setSize(150,30);
        panel2.add(txtPhoneNumber);

        txtEmailAddress=new JTextField();
        txtEmailAddress.setSize(150,30);
        panel2.add(txtEmailAddress);

        txtPassword = new JTextField();
        txtPassword.setSize(150,30);
        panel2.add(txtPassword);

        frame.add(panel2);

        panel3=new JPanel();
        panel3.setLayout(new GridLayout(1,3,5,5));
        panel3.setBounds(50,300,300,40);

        btnSignUp=new JButton("SIGN UP");
        btnSignUp.setSize(100,100);
        panel3.add(btnSignUp);

        btnSignIn=new JButton("SIGN IN");
        btnSignIn.setSize(100,100);
        panel3.add(btnSignIn);

        btnCancel=new JButton("CANCEL");
        btnCancel.setSize(100,100);
        panel3.add(btnCancel);

        frame.add(panel3);
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
