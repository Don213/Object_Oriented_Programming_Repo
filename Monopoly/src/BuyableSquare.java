public class BuyableSquare {
    private boolean buyable;


    BuyableSquare(boolean buyable)
    {
        this.buyable = buyable;
    }

    void setBuyable(boolean tf)
    {
        buyable = tf;
    }
    boolean getBuyable()
    {
        return buyable;
    }
}
