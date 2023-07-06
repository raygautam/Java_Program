package exception.fileHandling;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteFile {
    public static void main(String[] args) {
        String inputFile = "D:\\abedFile.txt";
        String outputFile = "D:\\abedFile1.txt";

        try {
            // Read from the input file
            String content = readFile(inputFile);

            // Modify the content (e.g., convert to uppercase)
            String modifiedContent = content.toUpperCase();

            // Write to the output file
            writeFile(outputFile, modifiedContent);

            System.out.println("File reading and writing completed successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        return content.toString();
    }

    public static void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }
}

