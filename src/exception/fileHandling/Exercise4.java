package exception.fileHandling;

import java.io.File;
import java.io.IOException;

//Write a Java program to check if a file or directory has read and write permissions.
public class Exercise4 {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\abcd.txt");
        File file1=new File("D:\\abcdFile1.txt");
        final String s = file.canRead() && file.canWrite() ? "file has read and write permissions" : "file doesn't have read and write permissions";
        System.out.println(s);

//        boolean created=file1.createNewFile();
//        final String s1 = created ? "file " + file1 + "created" : "file " + file1 + "not created";
//        System.out.println(s1);

        final String s1 = file.renameTo(new File("D:\\abedFile.docx")) ?
                "File renamed to abedFile.docx successfully." : "File renaming to abedFile.docx failed.";
        final String s2 = new File("D:\\abedFile.docx").renameTo(new File("D:\\abedFile.xlsx")) ?
                "File renamed to abedFile.xlsx successfully." : "File renaming to abedFile.xlsx failed.";
        final String s3 = new File("D:\\abedFile.xlsx").renameTo(new File("D:\\abedFile.txt")) ?
                "File renamed to abedFile.txt successfully." : "File renaming to abedFile.txt failed.";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
