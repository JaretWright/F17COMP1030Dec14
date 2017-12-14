package f17dec14comp130;

/**
 *
 * @author jwright
 */
public class ArrayRefresher {
    
    
    public static void main(String[] args)
    {
        String[] presents = new String[5];
        presents[0] = "Delorean";
        presents[1] = "Going back home";
        presents[2] = "Condo";
        presents[3] = "A grades";
        presents[4] = "Winning lottery ticket";
        
        displayArray(presents);
        displayReverseArray(presents);
        displayLowerCaseArray(presents);
    }
    
    public static void displayArray(String[] array)
    {
        for (int i=0; i<array.length; i++)
        {
            if (i==array.length-1)
                System.out.printf("%s %n", array[i]);
            else
                System.out.printf("%s, ", array[i]);
        }
    }
    
    public static void displayLowerCaseArray(String[] array)
    {
        for (int i=0; i<array.length; i++)
        {
            if (i==array.length-1)
                System.out.printf("%s %n", array[i].toLowerCase());
            else
                System.out.printf("%s, ", array[i].toLowerCase());
        }
    }
    
    public static void displayReverseArray(String[] array)
    {
        for (int i=array.length-1; i>=0; i--)
        {
            if (i==0)
                System.out.printf("%s %n", array[i]);
            else
                System.out.printf("%s, ", array[i]);
        }
    }
}
