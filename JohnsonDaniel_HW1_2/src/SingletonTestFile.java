public class SingletonTestFile {//TEST FILE

    public static void main(String[] args)
    {
        //2-c
        //Makes two supposedly separate instances
        Food food1 = Food.getInstance();
        Food food2 = Food.getInstance();

        //2-d
        //Proves that the instances are the same
        food1.setBrand("Lays");
        food1.setProductName("Spicy Lays");
        food2.setUnits("Ounces");
        System.out.println();

        System.out.println("I set the following for food1: Brand: Lays, ProductName: Spicy Lays.");
        System.out.println("I set the following for food2: Units: Ounces.");
        System.out.println();

        System.out.println("These are the two instances of the singleton class Food. After setting variables for each one separately");
        System.out.println(food1.toString());
        System.out.println();
        System.out.println(food2.toString());

        if(food1.equals(food2))
        {
            System.out.println("These two instances are equal");
        }
        else{System.out.println("These two instances are not equal");}




    }

}
