public class BuyableSquare {
    private boolean buyable;

    //constructor
    BuyableSquare(boolean buyable)
    {
        this.buyable = buyable;
    }

    //get and set for only boolean variable
    void setBuyable(boolean tf)
    {
        buyable = tf;
    }
    boolean getBuyable()
    {
        return buyable;
    }
}
