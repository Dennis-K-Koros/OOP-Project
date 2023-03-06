package Com.classwork;

public class Suppliers extends Person {
    public String supplierID;
    public String password;
    public double salary;


    public Suppliers(String supplierID,double salary,String Id,String name,String phoneNumber,String emailAddress){
        super(Id,name,phoneNumber,emailAddress);
        this.supplierID=supplierID;
        this.salary=salary;
    }

    public Suppliers(String Id, String name, String phoneNumber, String emailAddress, String supplierID, String password) {
        super(Id, name, phoneNumber, emailAddress);
        this.supplierID = supplierID;
        this.password = password;
    }

    public float getMoneyDueToPay(){
        return 0;
    }

    @Override
    public float getCashFlow() {
        return 0;
    }

    @Override
    public void showDetails() {

    }
}
