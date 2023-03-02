package Com.classwork;

import javax.swing.*;
import java.awt.*;

public class StartUp {

    JFrame frame;
    JPanel panel,panel1;
    JLabel jlIntro,jlIntro1;
    JButton btnCtm,btnSpp,btnSff,btnExit;
    Font myFont1 = new Font("Arial",Font.BOLD,30);
    Font myFont2 = new Font("Arial",Font.PLAIN,16);
    Font myFont3 = new Font("Arial",Font.PLAIN,8);

   StartUp(){

       frame = new JFrame();
       frame.setSize(420,420);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLayout(null);

       jlIntro = new JLabel("Welcome!!!");
       jlIntro.setFont(myFont1);

       jlIntro1 = new JLabel("Please Pick And Click the right Button");
       jlIntro1.setFont(myFont2);

       btnCtm = new JButton("Customer");
       btnCtm.setFont(myFont3);
       btnCtm.setFocusable(false);

       btnSpp = new JButton("Supplier");
       btnSpp.setFont(myFont3);
       btnSpp.setFocusable(false);

       btnSff = new JButton("Staff");
       btnSff.setFont(myFont3);
       btnSff.setFocusable(false);

       btnExit = new JButton("Exit");
       btnExit.setFont(myFont3);
       btnExit.setFocusable(false);

       panel= new JPanel();
       panel.setBounds(60,110,300,100);
       panel.setLayout(new FlowLayout());
       panel.add(jlIntro);
       panel.add(jlIntro1);


       panel1 = new JPanel();
       panel1.setBounds(60,210,300,30);
       panel1.setLayout(new GridLayout(1,4,5,5));
       panel1.add(btnCtm);
       panel1.add(btnSff);
       panel1.add(btnSpp);
       panel1.add(btnExit);

       frame.add(panel);
       frame.add(panel1);
       frame.setVisible(true);

   }

    public static void main(String[] args) {
        StartUp startUp = new StartUp();
    }
}
