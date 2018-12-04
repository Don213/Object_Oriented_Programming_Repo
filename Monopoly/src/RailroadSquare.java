public class RailroadSquare extends TaxSquare {

    private BuyableSquare buyable;
    private int price;

    RailroadSquare(String name, int squareType, int rent, int price)
    {
        super(name, squareType, rent);
        this.price = price;
        this.buyable = new BuyableSquare(true);
    }









    void setPrice()
    {
        this.price = price;
    }
    int getPrice()
    {
        return price;
    }


    public String toString()
    {
        return super.toString() + "[price: " + price + "]";
    }
}
