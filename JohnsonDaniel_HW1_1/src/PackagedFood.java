public class PackagedFood extends Food implements Cloneable
{
    //1-1-a
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




    //1-1-b
    /////////////////////////////////////////////////////////////////////////
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
    /////////////////////////////////////////////////////////////////////////



    //1-1-c
    //This method returns the cost of a unit
    public double getUnitCost()
    {
        return (this.itemCost/this.size);
    }




    //1-2-a
    //This method returns the name of the class
    public String getName()
    {
        return "PackagedFood";
    }

    //1-2-a
    //This method returns the PackagedFood object in string form
    public String toString()
    {
        //1-2-b
        //1-2-c
        return (super.toString() +  "[Size: " + getSize() + ", " + "Item Cost: "
                + getItemCost() + "]");
    }







    //This method returns true if the two PackagedFood objects are equal
    public boolean equals(PackagedFood pf)
    {
        //1-3-a (superclass checks for the same object)
        //1-3-b (Casting done in both superclass and child class)
        //1-3-c
        //Casting is most likely not needed but I included it anyways to be safe.
        if(super.equals((PackagedFood)pf)
                && getSize() == ((PackagedFood)pf).getSize()
                && getItemCost() == ((PackagedFood)pf).getItemCost())
        {
            return true;
        }
        else{return false;}
    }


    //This method returns a clone of the current object
    //1-4-a
    public PackagedFood clone() throws CloneNotSupportedException
    {
        //1-4-b
        return (PackagedFood)super.clone();
    }
}
