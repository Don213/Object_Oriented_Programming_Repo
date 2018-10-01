public class MainTest {
    public static void main(String[] args)
    {
        PackagedFood pf1 = new PackagedFood("Doritos", "Cool Ranch Doritos", "Ounces", 16.0, 1.0);
        PackagedFood pf2 = new PackagedFood("Doritos", "Cool Ranch Doritos", "Ounces", 24.0, 1.0);
        PackagedFood pf3 = new PackagedFood("Doritos", "Cool Ranch Doritos", "Ounces", 16.0, 1.0);
        PackagedFood pf4;

        System.out.println();
        System.out.println("These are all of the object instances created at the beginning of main");
        System.out.println(pf1.toString());
        System.out.println(pf2.toString());
        System.out.println(pf3.toString());
        System.out.println();


        //Outcome should be not equal
        if(pf1.equals(pf2))
        {
            System.out.println("pf1 and pf2 are equal.");
        }
        else{System.out.println("pf1 and pf2 are not equal.");}
        System.out.println(pf1.toString());
        System.out.println(pf2.toString());
        System.out.println();

        //Outcome should be equal
        if(pf1.equals(pf3))
        {
            System.out.println("pf1 and pf3 are equal.");
        }
        else{System.out.println("pf1 and pf3 are not equal.");}
        System.out.println(pf1.toString());
        System.out.println(pf3.toString());
        System.out.println();


        System.out.println("This is pf2 and the object cloned from pf2, pf4");
        try
        {
            pf4 = pf2.clone();
            System.out.println(pf4.toString());
        }catch(CloneNotSupportedException e) {
            System.out.println("There was a CloneNotSupportedException");
        }
        System.out.println(pf2.toString());



/*

*/






    }
}
