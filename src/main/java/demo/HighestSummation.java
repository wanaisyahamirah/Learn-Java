package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HighestSummation {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter input >> ");

            // String input = "30|100|200,50|60|700,150|30";
            String input = sc.nextLine();

            List<String> itemsPriceSeperatedByComa = getItemPriceSeperatedByComa(input);

            int max = 0;
            int counter = 0;

            for (int i = 0; i < itemsPriceSeperatedByComa.size(); i++) {
                System.out.println("Items Seperated By Coma  #" + (i + 1) + " is " + itemsPriceSeperatedByComa.get(i));

                List<String> itemsPriceSeperatedByVerticalLine = getItemPriceSeperatedByVerticalLine(
                        itemsPriceSeperatedByComa.get(i));

                int sum = 0;

                for (int j = 0; j < itemsPriceSeperatedByVerticalLine.size(); j++) {
                    System.out.println("Items Seperated By Vertical Line  #" + (j + 1) + " is "
                            + itemsPriceSeperatedByVerticalLine.get(j));
                    sum += Integer.parseInt(itemsPriceSeperatedByVerticalLine.get(j));

                }

                if (sum > max) {
                    max = sum;
                    counter = i;
                }
                System.out.println("Summation of the Item Prices is >> " + sum + "\n");
            }

            System.out.println("Highest Value is " + max + " which belongs to #" + (counter + 1) + "\n");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    public static List<String> getItemPriceSeperatedByComa(String input) {
        String[] splitByComa = input.split(",");

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < splitByComa.length; i++) {
            list.add(splitByComa[i]);
        }

        return list;

    }

    public static List<String> getItemPriceSeperatedByVerticalLine(String input) {
        String[] splitByVerticalLine = input.split("\\|");

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < splitByVerticalLine.length; i++) {
            list.add(splitByVerticalLine[i]);
        }

        return list;
    }

}
