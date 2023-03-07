package Com.classwork;

public  class Good {
    public String id;
    public  String name;
    public   int buyingPrice;
    public   int sellingPrice;
    public int  amountSupplied;
    public  int amountSold;

    public Good(String id) {
        this.id = id;

    }

    public Good(String id, String name, int buyingPrice, int sellingPrice, int amountSupplied, int amountSold) {
        this.id = id;
        this.name = name;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.amountSupplied = amountSupplied;
        this.amountSold = amountSold;
    }


}
