package inputOutput;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadingInputUsingDataInputStream {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//             DataInputStream dis = new DataInputStream(System.in)
        ) {

            System.out.print("Enter a string: ");
            String input = reader.readLine(); // Read input line by line
//            dis.readUTF(); // Discard the length prefix

            System.out.println("Input: " + input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
