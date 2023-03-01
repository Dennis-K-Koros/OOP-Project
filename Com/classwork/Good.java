package Com.classwork;

public  abstract class Good {
    protected String id;
    protected String name;
    protected int buyingPrice;
    protected int sellingPrice;
    protected int amountSupplied;
    protected int amountSold;

    public Good(String id, String name, int buyingPrice, int sellingPrice, int amountSupplied, int amountSold) {
        this.id = id;
        this.name = name;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.amountSupplied = amountSupplied;
        this.amountSold = amountSold;
    }

    public abstract int getAmountLeft();
    public abstract double RevenueEarned();
    public abstract double getTotalCost();
    public abstract double getTotalProfit();
}
