package inputOutput;

import java.util.Scanner;

public class ReadingInputThroughScanner {
    public static void main(String arg[]){
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter any string value : ");
        String name=scanner.nextLine();

        System.out.println("Enter any integer value : ");
        Integer age=scanner.nextInt();

        System.out.println("Name : "+name+" age : "+age);
    }
}
