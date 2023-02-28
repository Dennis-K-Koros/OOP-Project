package Com.classwork;

public class Staff  extends Person{
    private String staffId;
    public int salary;
    public Staff(String staffId,String Id,String name, String phoneNumber,String emailAddress,int salary){
        super(Id, name, phoneNumber, emailAddress);
        this.staffId=staffId;
        this.salary=salary;
    }
    @Override
    public float getCashFlow() {
        return salary;
    }

    @Override
    public void showDetails() {

    }
}
