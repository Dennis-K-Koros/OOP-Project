package Com.classwork;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SffSignIn {

    JFrame frame;
    JPanel panel,panel1;
    JLabel jlUsername,jlPassword;
    JTextField jtUsername;
    JPasswordField jpPassword;
    JButton btnSignIn,btnClear,btnExit;
    Font myFont1 = new Font("Arial",Font.PLAIN,18);
    Font myFont2 = new Font("Arial",Font.PLAIN,14);
    TitledBorder title;

    SffSignIn(){

        frame = new JFrame("SignIn");
        frame.setSize(420,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        title = BorderFactory.createTitledBorder("Staff SignIn");
        title.setTitleFont(myFont1);

        panel = new JPanel();
        panel.setBounds(20,20,360,250);
        panel.setLayout(null);
        panel.setBorder(title);

        jlUsername = new JLabel("UserName");
        jlUsername.setBounds(30,80,150,25);
        jlUsername.setFont(myFont1);

        jlPassword = new JLabel("Password");
        jlPassword.setBounds(30,130,150,25);
        jlPassword.setFont(myFont1);

        jtUsername = new JTextField();
        jtUsername.setBounds(180,80,150,25);
        jtUsername.setFont(myFont1);

        jpPassword = new JPasswordField();
        jpPassword.setBounds(180,130,150,25);
        jpPassword.setFont(myFont1);

        btnSignIn = new JButton("SignIn");
        btnSignIn.setFocusable(false);
        btnSignIn.setFont(myFont2);
        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = jtUsername.getText();
                String password = String.valueOf(jpPassword.getPassword());

                staff=getAuthenticatedStaff(name,password);

                if (staff !=null){
                    JOptionPane.showMessageDialog(null,
                            "Successful Login",
                            "Welcome",
                            JOptionPane.PLAIN_MESSAGE);
                    frame.dispose();
                    StaffWelcomePage swp = new StaffWelcomePage();
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Email Or Password Invalid",
                            "Try Again",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        btnClear = new JButton("Clear");
        btnClear.setFocusable(false);
        btnClear.setFont(myFont2);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtUsername.setText("");
                jpPassword.setText("");
            }
        });

        btnExit = new JButton("Back");
        btnExit.setFocusable(false);
        btnExit.setFont(myFont2);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StartUp startUp = new StartUp();
            }
        });

        panel1 = new JPanel();
        panel1.setBounds(50,180,250,30);
        panel1.setLayout(new GridLayout(1,3,5,5));
        panel1.add(btnSignIn);
        panel1.add(btnClear);
        panel1.add(btnExit);

        panel.add(jlUsername);
        panel.add(jlPassword);
        panel.add(jtUsername);
        panel.add(jpPassword);
        panel.add(panel1);
        frame.add(panel);
        frame.setVisible(true);

    }
    public Staff staff;
    private Staff getAuthenticatedStaff(String name, String password) {
        try{
            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM staff WHERE staffName=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                staff = new Staff( name, password);
                staff.Id = resultSet.getString("StaffId");
                staff.name = resultSet.getString("StaffName");
                staff.phoneNumber = resultSet.getString("PhoneNumber");
                staff.emailAddress = resultSet.getString("emailAddress");
            }

            stmt.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return staff;
    }


}
