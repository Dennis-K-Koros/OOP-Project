package Com.classwork;

public class Suppliers extends Person {
    public String supplierID;
    public double salary;


    public Suppliers(String supplierID,double salary,String Id,String name,String phoneNumber,String emailAddress){
        super(Id,name,phoneNumber,emailAddress);
        this.supplierID=supplierID;
        this.salary=salary;
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
