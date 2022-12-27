package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiplicationTable {

    public static void main (String[] args)
    {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Please enter the number from: ");
            int numFrom = sc.nextInt();

            System.out.print("Please enter the number to: ");
            int numTo = sc.nextInt();

            List<Integer> list = getNumberBetween(numFrom, numTo);

            /*for(int i = 0; i <= list.size() ; i++){
                System.out.println();
                System.out.println("size: "+list.size());
            }*/

            
            System.out.println("Size is: "+list.size());

            for(int i = 0; i < list.size() ; i++)
            {
                System.out.println("i is :" +i);
                for(int j = 1; j <= 12 ; j++)
                {
                    String printTable = list.get(i)+" * "+j+" = "+list.get(i)*j;
                    System.out.println(printTable);
                }

                System.out.println();
            }
        }

    }

    private static List<Integer> getNumberBetween(int numFrom, int numTo)
    {

        int Num1 = numFrom;
        int Num2 = numTo;;

        List<Integer> numberBetweenList = new ArrayList<Integer>();

        for (int i = Num1; i <= Num2; i++)
        {
            numberBetweenList.add(i);
            //System.out.println("list is: " + list);
        }
        return numberBetweenList;

    }
    
}
