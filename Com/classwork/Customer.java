package Com.classwork;

public class Customer extends Person {
    public String customerID;
    public double moneyInvoiced;
    public double moneyReceipt;

    public Customer(String customerID,double moneyInvoiced,double moneyReceipt,String Id,String name,String phoneNumber,String emailAddress){
        super(Id, name, phoneNumber, emailAddress);
        this.customerID=customerID;
        this.moneyInvoiced=moneyInvoiced;
        this.moneyReceipt=moneyReceipt;
    }

    @Override
    public float getCashFlow() {
        return 0;
    }
    public void showDetails(){

    }
}
