public class PackagedFood extends Food implements Cloneable
{
    private double size;
    private double itemCost;

    //This is a constructor made to enable creation of the object
    //**I added a way to add size and itemCost using the constructor**
    public PackagedFood(String brandIn, String productNameIn, String unitsIn, Double size, Double itemCost)
    {
        super(brandIn, productNameIn, unitsIn);
        this.size = size;
        this.itemCost = itemCost;
    }

    ////////////////////////////////////////////////////////
    //This method returns the name of the class
    public String getName()
    {
        return "PackagedFood";
    }

    ////////////////////////////////////////////////////////
    //This method sets the value of size using double input
    public void setSize(double size)
    {
        this.size = size;
    }
    //This method returns the current size value
    public double getSize()
    {
        return this.size;
    }

    ////////////////////////////////////////////////////////
    //This method sets the value of itemCost using double input
    public void setItemCost(double itemCost)
    {
        this.itemCost = itemCost;
    }
    //This method returns the current itemCost value
    public double getItemCost()
    {
        return this.itemCost;
    }

    ////////////////////////////////////////////////////////
    //This method returns the cost of a unit
    public double getUnitCost()
    {
        return (this.itemCost/this.size);
    }

    ////////////////////////////////////////////////////////
    //This method returns the PackagedFood object in string form
    public String toString()
    {
        return (super.toString() +  "[Size: " + getSize() + ", " + "Item Cost: "
                + getItemCost() + "]");
    }

    ////////////////////////////////////////////////////////
    //This method returns true if the two PackagedFood objects are equal
    public boolean equals(PackagedFood pf)
    {
        if(super.equals(pf)
                && getSize() == pf.getSize()
                && getItemCost() == pf.getItemCost())
        {
            return true;
        }
        else{return false;}
    }

    ////////////////////////////////////////////////////////
    //This method returns a clone of the current object
    public PackagedFood clone() throws CloneNotSupportedException
    {
        return (PackagedFood)super.clone();
    }
}
