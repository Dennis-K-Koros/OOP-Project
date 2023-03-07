package Com.classwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deliveries {
    JFrame frame;
    JLabel deliveryId, supplierId,goodId,phoneNumber;
    JTextField jtCtm,txtId,txtName,txtPhoneNumber;
    JButton btnOk,btnClear,btnCancel;
    JPanel panel1,panel2,panel3;

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

}
