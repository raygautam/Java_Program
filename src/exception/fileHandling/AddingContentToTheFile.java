package exception.fileHandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddingContentToTheFile {
    public static void main(String[] args) throws IOException {
        String content="Creating new file and adding content to it";
        boolean created=new File("D:\\writingContent.txt").createNewFile();
        if(created){
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("D:\\writingContent.txt")))){
//                writer.write(content);
//            }catch (IOException e) {
//                System.out.println("An error occurred: " + e.getMessage());
//            }
            try (FileWriter fileWriter=new FileWriter(new File("D:\\writingContent.txt"))){
                fileWriter.write(content);
                System.out.println("Content add successfully");
            }catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }else {
            System.out.println("File not created");
        }
    }
}
