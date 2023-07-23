package exception.fileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class FileReadWriteScheduler {
//    private static final String INPUT_FILE_PATH = "input.txt";
//    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String INPUT_FILE_PATH = "D:\\abedFile.txt";
    private static final String OUTPUT_FILE_PATH = "D:\\abedFile1.txt";
    private static final long DURATION_MS = 5000; // Duration in milliseconds

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new FileReadWriteTask(), 0, DURATION_MS);
    }

    private static class FileReadWriteTask extends TimerTask {
        @Override
        public void run() {
            try {
                // Read from input file
                BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();

                // Write to output file
                BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH));
                writer.write(content.toString());
                writer.close();

                System.out.println("File read and write operation completed.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

