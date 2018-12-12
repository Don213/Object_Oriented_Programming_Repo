public class UtilitySquare extends TaxSquare {

    private BuyableSquare buyable;
    private int multiplierValue;

    //default constructor
    UtilitySquare(){

    }

    //constructor
    UtilitySquare(String name, int squareType, int rent, int multiplierValue)
    {
        super(name, squareType, rent);
        this.multiplierValue = multiplierValue;
        this.buyable = new BuyableSquare(true);
    }


    //get set price
    void setPrice(int price)
    {
        setRent(price);
    }
    int getPrice()
    {
        return getRent();
    }


    //get set multiplier for rent
    void setMultiplierValue(int multiplierValue)
    {
        this.multiplierValue = multiplierValue;
    }
    int getMultiplierValue()
    {
        return multiplierValue;
    }


    //buyable get and set
    public boolean isBuyable(){
        return buyable.getBuyable();
    }
    public void setBuyable(boolean buyable){
        this.buyable.setBuyable(buyable);
    }


/*  used for testing purposes
    public String toString()
    {
        return (super.toString() + "[multiplierValue: " + multiplierValue + "]");
    }
*/

}
