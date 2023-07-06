package exception.fileHandling;

import java.io.File;

//Write a Java program to check if the given pathname is a directory or a file.
public class Exercise5 {
    public static void main(String[] args) {
        File file=new File("D:\\abedFile.txt");
        File file1=new File("D:\\");
        final String s = file.isDirectory() ? file.getAbsolutePath() + " is a directory.\n" : file.getAbsolutePath() + " is not a directory.\n";
        final String s1 = file.isFile() ? file.getAbsolutePath() + " is a file.\n" : file.getAbsolutePath() + " is not a file.\n";
        final String s3 = file1.isDirectory() ? file1.getAbsolutePath() + " is a directory.\n" : file1.getAbsolutePath() + " is not a directory.\n";
        final String s4 = file1.isFile() ? file1.getAbsolutePath() + " is a file.\n" : file1.getAbsolutePath() + " is not a file.\n";
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s3);
        System.out.println(s4);
    }
}
