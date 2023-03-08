package Com.classwork;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Suppliers extends Person {
    public String supplierID;
    public String password;
    public String goodsSupplied;
    public double salary;
     static JTable table;


    public Suppliers(String supplierID,double salary,String Id,String name,String phoneNumber,String emailAddress){
        super(Id,name,phoneNumber,emailAddress);
        this.supplierID=supplierID;
        this.salary=salary;
    }

    public Suppliers(String Id, String name, String phoneNumber, String emailAddress, String supplierID, String password,String goodsSupplied) {
        super(Id, name, phoneNumber, emailAddress);
        this.supplierID = supplierID;
        this.password = password;
        this.goodsSupplied = goodsSupplied;
    }
    public Suppliers(String name,String password){
        super(name);
        this.password=password;
    }


    public static void showDetails() {
    }
}
