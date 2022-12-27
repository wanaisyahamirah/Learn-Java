package demo;

import java.util.ArrayList;
import java.util.List;

public class PageNumber {

    public static void main (String[] args){

        String ListofPageString = "2,5 ,7, 8-10, 23,29-30,33, 38 -  43";

        List<Integer> list= getPageNumber(ListofPageString);

        for(int i=0; i<list.size(); i++){
            System.out.println("Page " +list.get(i));
        }

    }
    
    private static boolean isContain(String string1, String stringFind)
    {
        return string1.indexOf(stringFind) > -1;
        /* 
        if(string1.indexOf(stringFind) > -1){

        return true;
        }
        return false;
        */
    }

    public static List<Integer> getPageNumber(String input)
    {
        List<Integer> listAllPage = new ArrayList<Integer>();

        String[] splitByComa = input.split(",");

        for(int i = 0; i < splitByComa.length; i++)
        {
            splitByComa[i] = splitByComa[i].trim();
        }

        for(int i = 0; i < splitByComa.length; i++)
        {
            //if(splitByComa[i].indexOf("-") > -1)
            //"ABCD-123"
            if(isContain(splitByComa[i],"-"))
            {
                listAllPage.addAll(getPageBetween(splitByComa[i]));
            }
            else
            {
                listAllPage.add(Integer.parseInt(splitByComa[i]));
            }
        }
        return listAllPage;
    }

    private static List<Integer> getPageBetween(String input)
    {
        List<Integer> list = new ArrayList<Integer>();
        String[] splitByHyphen = input.split("-");

        int Num1 = Integer.parseInt(splitByHyphen[0].trim());
        int Num2 = Integer.parseInt(splitByHyphen[1].trim());

        //System.out.println("Num 1 is " +Num1+ " Num 2 is " +Num2);

        for (int i = Num1; i <= Num2; i++)
        {
            list.add(i);
            //System.out.println("list is: " + list);
        }
        return list;

    }
    
}
