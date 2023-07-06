package exception.fileHandling;

import java.io.File;
import java.io.FilenameFilter;

public class Exercise2 {
    //Write a Java program to get specific files with extensions from a specified folder.
    public static void main(String[] a){
        File file = new File("D:\\");
//        String[] list = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                if(name.toLowerCase().endsWith(".py")){
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        });

        String[] list=file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".sql") || name.toLowerCase().endsWith(".docx") ||
                        name.toLowerCase().endsWith(".txt") || name.toLowerCase().endsWith(".zip");
            }
        });

        assert list != null;
        for(String f:list){
            System.out.println(f);
        }
    }
}
