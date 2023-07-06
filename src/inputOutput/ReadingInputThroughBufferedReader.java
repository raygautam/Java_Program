package inputOutput;

import javax.swing.*;
import java.io.*;
import java.nio.file.NoSuchFileException;
import java.security.Security;
import java.util.zip.InflaterInputStream;

public class ReadingInputThroughBufferedReader {

    // Java Program for taking user
// input using BufferedReader Class

        // Main Method
        public static void main(String[] args) throws IOException {
            // Creating BufferedReader Object
            // InputStreamReader converts bytes to
            // stream of character
            try (BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in))) {
                long startTime=System.currentTimeMillis();
                System.out.println("Enter any string value: ");
                String str = bfn.readLine();

                System.out.println("Enter any integer value: ");
                int it;
                try {
                    it = Integer.parseInt(bfn.readLine());
                } catch (NumberFormatException e) {
                    String errorMessage = "Invalid input for integer: " + e.getMessage();
                    throw new RuntimeException(errorMessage);
                }

                System.out.println("Entered String: " + str);
                System.out.println("Entered Integer: " + it);
                System.out.println(Integer.toBinaryString(it));
                System.out.println(Integer.bitCount(it));
                long endTime=System.currentTimeMillis();
                long executionTime=endTime-startTime;
                System.out.println("Execution time : "+executionTime);
            } catch (RuntimeException e) {
                System.err.println("---"+e.getMessage());
            } catch (IOException e) {
                System.err.println("IO Error: " + e.getMessage());
            }
        }
}
