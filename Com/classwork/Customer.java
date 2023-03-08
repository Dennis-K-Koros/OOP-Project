package Com.classwork;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Customer extends Person {
    public String customerID;
    public double moneyInvoiced;
    public double moneyReceipt;
    public String password;
    static JTable table;

    public Customer(String name, String password) {
        super(name);
        this.password = password;
    }

    public Customer(String Id, String name, String phoneNumber, String emailAddress, String customerID, String password) {
        super(Id, name, phoneNumber, emailAddress);
        this.customerID = customerID;
        this.password = password;
    }

    public Customer(String customerID, double moneyInvoiced, double moneyReceipt, String Id, String name, String phoneNumber, String emailAddress) {
        super(Id, name, phoneNumber, emailAddress);
        this.customerID = customerID;
        this.moneyInvoiced = moneyInvoiced;
        this.moneyReceipt = moneyReceipt;
    }
}



