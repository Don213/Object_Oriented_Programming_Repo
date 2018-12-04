public class UtilitySquare extends TaxSquare {

    private BuyableSquare buyable;
    private int multiplierValue;

    UtilitySquare(String name, int squareType, int rent, int multiplierValue)
    {
        super(name, squareType, rent);
        this.multiplierValue = multiplierValue;
        this.buyable = new BuyableSquare(true);
    }




    void setMultiplierValue(int multiplierValue)
    {
        this.multiplierValue = multiplierValue;
    }
    int getMultiplierValue()
    {
        return multiplierValue;
    }

    public String toString()
    {
        return (super.toString() + "[multiplierValue: " + multiplierValue + "]");
    }


}
