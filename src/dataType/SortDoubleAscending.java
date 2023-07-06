package dataType;

import java.util.*;

public class SortDoubleAscending {
    public static void main(String[] args) {
        //If we are using Set then use below code to sort Set.
//        Set<Double> doubleValue = new TreeSet<>(new DoubleDecimalComparator());
        List<Double> doubleValue = new ArrayList<>();

        doubleValue.add(3.14159);
        doubleValue.add(2.71828);
        doubleValue.add(1.61803);
        doubleValue.add(0.7071);

        //If we are using List then use below code to sort list
        doubleValue.sort(new DoubleDecimalComparator());
        // Print the sorted set or  list
        for (Double d : doubleValue) {
            System.out.println(d);
        }
    }
}

class DoubleDecimalComparator1 implements Comparator<Double> {
    @Override
    public int compare(Double d1, Double d2) {
        int decimalPart1 = getDecimalPart(d1);
        int decimalPart2 = getDecimalPart(d2);
        return decimalPart1 - decimalPart2; // Ascending order
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

