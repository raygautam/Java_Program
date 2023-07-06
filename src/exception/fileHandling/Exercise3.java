package exception.fileHandling;

import java.io.File;

//Write a Java program to check if a file or directory specified by pathname exists or not.
public class Exercise3 {
    public static void main(String[] args) {
        File file=new File("D:\\JavaCollection.txt");
        final String s = file.exists() ? "file exists" : "file doesn't exists";
        System.out.println(s);
    }
}
