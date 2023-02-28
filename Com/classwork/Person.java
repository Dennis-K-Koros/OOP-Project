package Com.classwork;

public abstract class Person {

    protected String Id;
    protected String name;
    protected String phoneNumber;
    protected String emailAddress;

  public Person(String Id,String name, String phoneNumber,String emailAddress){
      this.Id=Id;
      this.name=name;
      this.phoneNumber=phoneNumber;
      this.emailAddress=emailAddress;
  }

  public abstract float getCashFlow();
  public abstract void showDetails();

}
