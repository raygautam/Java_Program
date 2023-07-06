package exception.uncheckedException;

import java.io.IOException;

public class ArithmeticExceptionClass {
    public static void main (String[] args) throws Exception {
        int a=5;
        int b=0;
        try{
            System.out.println(a/b);
        }
        catch(ArithmeticException e){
            String exceptionName = e.getClass().getName();
            String exceptionDescription = e.getMessage();

            System.out.println("Exception Name: " + exceptionName);
            System.out.println("Exception Description: " + exceptionDescription);
//            throw new Exception(exceptionName+exceptionDescription);
        }
//        Exception
//        IOException
    }
}
