package Com.classwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtmLogin extends JFrame  {
    JFrame frame;
    JLabel ctmId, id,name,phoneNumber,emailAddress,password;
    JTextField jtCtm,txtId,txtName,txtPhoneNumber,txtEmailAddress;
    JPasswordField pfPassword;
    JButton btnSignUp,btnSignIn,btnCancel;
    JPanel panel1,panel2,panel3;

    CtmLogin(){
        frame= new JFrame("LOGIN");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);

        panel1=new JPanel();
        panel1.setLayout(new GridLayout(6,1,5,5));
        panel1.setBounds(50,50,150,200);

        ctmId = new JLabel("CUSTOMER ID");
        panel1.add(ctmId);

        id=new JLabel("NATIONAL ID");
        panel1.add(id);

        name=new JLabel("NAME");
        panel1.add(name);

        phoneNumber=new JLabel("PHONE NUMBER");
        panel1.add(phoneNumber);

        emailAddress=new JLabel("EMAIL ADDRESS");
        panel1.add(emailAddress);

        password=new JLabel("PASSWORD");
        panel1.add(password);

        frame.add(panel1);

        panel2=new JPanel();
        panel2.setLayout(new GridLayout(6,1,5,5));
        panel2.setBounds(200,50,150,200);

        jtCtm = new JTextField();
        panel2.add(jtCtm);

        txtId=new JTextField();
        panel2.add(txtId);

        txtName=new JTextField();
        panel2.add(txtName);

        txtPhoneNumber=new JTextField();
        panel2.add(txtPhoneNumber);

        txtEmailAddress=new JTextField();
        panel2.add(txtEmailAddress);

        pfPassword = new JPasswordField();
        panel2.add(pfPassword);

        frame.add(panel2);

        panel3=new JPanel();
        panel3.setLayout(new GridLayout(1,3,5,5));
        panel3.setBounds(50,300,300,40);

        btnSignUp=new JButton("SIGN UP");
        panel3.add(btnSignUp);

        btnSignIn=new JButton("SIGN IN");
        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtmSignIn ctmSignIn = new CtmSignIn();
            }
        });
        panel3.add(btnSignIn);

        btnCancel=new JButton("CANCEL");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartUp startUp = new StartUp();
            }
        });
        panel3.add(btnCancel);

        frame.add(panel3);
        frame.setVisible(true);
    }

}
