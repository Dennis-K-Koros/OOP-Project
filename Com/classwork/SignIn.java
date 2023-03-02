package Com.classwork;

import javax.swing.*;
import java.awt.*;

public class SignIn {

    JFrame frame;
    JPanel panel;
    JLabel jlUsername,jlPassword;
    JTextField jtUsername;
    JPasswordField jpPassword;
    JButton btnSignIn,btnClear,btnExit;
    Font myFont1 = new Font("Arial",Font.PLAIN,2);
    Font myFont2 = new Font("Arial",Font.PLAIN,10);

    SignIn(){

        frame = new JFrame("SignIn");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        jlUsername = new JLabel("UserName");
        jlUsername.setBounds(50,100,150,25);
        jlUsername.setFont(myFont1);

        jlPassword = new JLabel("Password");
        jlPassword.setBounds(50,150,150,25);
        jlPassword.setFont(myFont1);

        jtUsername = new JTextField();
        jtUsername.setBounds(200,100,150,25);
        jtUsername.setFont(myFont1);

        jpPassword = new JPasswordField();
        jpPassword.setBounds(200,150,150,25);
        panel = new JPanel();





        frame.add(jlUsername);
        frame.add(jlPassword);
        frame.add(jtUsername);
        frame.add(jpPassword);
        frame.setVisible(true);

    }


}
