package exception.fileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class FileReadWriteScheduler1 {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) {
        // Get the current date and time
        Calendar now = Calendar.getInstance();

        // Set the desired time for file read and write (11 PM)
        Calendar desiredTime = Calendar.getInstance();
        desiredTime.set(Calendar.HOUR_OF_DAY, 23);
        desiredTime.set(Calendar.MINUTE, 0);
        desiredTime.set(Calendar.SECOND, 0);

        // If the desired time has already passed for today, schedule for the next day
        if (now.after(desiredTime)) {
            desiredTime.add(Calendar.DATE, 1);
        }

        // Calculate the delay until the desired time
        long delay = desiredTime.getTimeInMillis() - now.getTimeInMillis();

        // Schedule the task at the desired time
        Timer timer = new Timer();
        timer.schedule(new FileReadWriteTask(), delay);
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

                System.out.println("File read and write operation completed at " + getCurrentTime());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String getCurrentTime() {
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(now);
        }
    }
}
