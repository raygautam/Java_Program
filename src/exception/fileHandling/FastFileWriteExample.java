package exception.fileHandling;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FastFileWriteExample {
    public static void main(String[] args) {
        String filePath = "D:\\writingContent.txt";
        String content = "This is the content to be written to the file.";

        try {
            writeFileFast(filePath, content);
            System.out.println("File writing completed successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file: " + e.getMessage());
        }
    }

    public static void writeFileFast(String filePath, String content) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");
             FileChannel channel = file.getChannel()) {

            byte[] contentBytes = content.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(contentBytes.length);
            buffer.put(contentBytes);
            buffer.flip();

            channel.write(buffer);
        }
    }
}

