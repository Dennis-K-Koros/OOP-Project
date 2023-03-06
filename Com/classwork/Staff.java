package Com.classwork;

public class Staff  extends Person{
    private String staffId;
    public String password;
    public int salary;

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

    @Override
    public float getCashFlow() {
        return salary;
    }

    @Override
    public void showDetails() {

    }
}
