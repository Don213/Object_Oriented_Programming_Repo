public class RailroadSquare extends TaxSquare {

    private BuyableSquare buyable;
    private int price;

    //default contructor
    RailroadSquare(){

    }
    //constructor
    RailroadSquare(String name, int squareType, int rent, int price)
    {
        super(name, squareType, rent);
        this.price = price;
        this.buyable = new BuyableSquare(true);
    }






    //get and set for buyable
    public boolean isBuyable(){
        return buyable.getBuyable();
    }
    public void setBuyable(boolean buyable){
        this.buyable.setBuyable(buyable);
    }

    //get and set for price
    void setPrice()
    {
        this.price = price;
    }
    int getPrice()
    {
        return price;
    }

/*used for testing
    public String toString()
    {
        return super.toString() + "[price: " + price + "]";
    }
    */
}
