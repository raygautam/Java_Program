package dataType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortDoubleDescending {
    public static void main(String[] args) throws IOException {
        Set<Double> doubleList = new TreeSet<>(new DoubleDecimalComparator());
//        doubleList.add(3.14159);
//        doubleList.add(2.71828);
//        doubleList.add(1.61803);
//        doubleList.add(0.7071);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of element : ");
        int size= Integer.parseInt(br.readLine());

        do{
            System.out.println("Enter the number : ");
            Double number= Double.parseDouble(br.readLine());
            doubleList.add(number);
            size--;
        }while(size>0);

        // Sort in descending order after the decimal point
//        Collections.sort(doubleList, new DoubleDecimalComparator());

        // Print the sorted list
        for (Double d : doubleList) {
            System.out.println(d);
        }
    }
}

class DoubleDecimalComparator implements Comparator<Double> {
    @Override
    public int compare(Double d1, Double d2) {
        int decimalPart1 = getDecimalPart(d1);
        int decimalPart2 = getDecimalPart(d2);
//        return decimalPart2 - decimalPart1; // Descending order
        return decimalPart1 - decimalPart2; // Descending order
    }

    private int getDecimalPart(Double d) {
        String doubleStr = Double.toString(d);
        int dotIndex = doubleStr.indexOf('.');
        if (dotIndex == -1) {
            return 0;
        } else {
            String decimalPartStr = doubleStr.substring(dotIndex + 1);
            return Integer.parseInt(decimalPartStr);
        }
    }
}

