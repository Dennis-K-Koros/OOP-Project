package Com.classwork;

import javax.swing.*;
import java.awt.*;

public class Deliveries {
    JFrame frame;
    JLabel ctmId, id,name,phoneNumber,emailAddress,password;
    JTextField jtCtm,txtId,txtName,txtPhoneNumber,txtEmailAddress;
    JPasswordField pfPassword;
    JButton btnSignUp,btnSignIn,btnCancel;
    JPanel panel1,panel2,panel3;

    Deliveries(){
        frame= new JFrame("Deliveries");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        panel1=new JPanel();
        panel1.setLayout(new GridLayout(4,1,5,5));
        panel1.setBounds(50,50,150,160);

        ctmId = new JLabel("DELIVERY ID");
        panel1.add(ctmId);

        id=new JLabel("SUPPLIER ID");
        panel1.add(id);

        name=new JLabel("GOOD ID");
        panel1.add(name);

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

        btnSignUp=new JButton("OK");
        panel3.add(btnSignUp);

        btnSignIn=new JButton("CLEAR");
        panel3.add(btnSignIn);

        btnCancel=new JButton("CANCEL");
        panel3.add(btnCancel);

        frame.add(panel3);
        frame.setVisible(true);
    }

}
