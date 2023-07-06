package exception.fileHandling;

import java.io.File;
import java.util.Objects;

//Write a Java program to get a list of all file/directory names in the given directory.
public class ListOfAllFileDirectory {
    public static void main(String[] a)
    {
        String url="D:\\";
        File file = new File(url);
//        String[] fileList = file.list();
//        assert fileList != null;
        for(File name: Objects.requireNonNull(file.listFiles())){
//            System.out.println(name.);
            String fileName=name.getName();
            int dotIndex=fileName.lastIndexOf(".");
//            && dotIndex<fileName.length()-1
            if(dotIndex>0 ){
                String fileExtension=fileName.substring(dotIndex+1);
//                System.out.println(name.getName());
                System.out.println("fileName : "+name.getName()+" ,=> File Extension : " + fileExtension+" ,=>dotIndex : "+dotIndex+" ,=>fileName.length() : "+fileName.length());
            }
        }
    }
}
