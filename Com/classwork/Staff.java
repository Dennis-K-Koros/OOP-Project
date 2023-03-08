package Com.classwork;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Staff  extends Person{
    private String staffId;
    public String password;
    public int salary;
    static JTable table;

    public Staff(String Id, String name, String phoneNumber, String emailAddress, String staffId, int salary,String password) {
        super(Id, name, phoneNumber, emailAddress);
        this.staffId = staffId;
        this.salary = salary;
        this.password = password;
    }

    public Staff(String Id, String name, String phoneNumber, String emailAddress, String staffId,String password) {
        super(Id, name, phoneNumber, emailAddress);
        this.staffId = staffId;
        this.password = password;
    }
    public Staff(String name,String password){
        super(name);
        this.password = password;
    }
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public static void showDetails(){
        String id;
        id = JOptionPane.showInputDialog("Please enter your Supplier Id");
        try {
            Connection conn = DBConnection.createDBConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM deliveries WHERE supplierId=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++){
                colName[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(colName);

            String deliveryId,supplierId,goodId,amountSupplied;
            while (resultSet.next()){
                deliveryId = resultSet.getString(1);
                supplierId = resultSet.getString(2);
                goodId = resultSet.getString(3);
                amountSupplied = resultSet.getString(4);
                String[]row = {deliveryId,supplierId,goodId,amountSupplied};
                model.addRow(row);
            }
            stmt.close();
            conn.close();


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
