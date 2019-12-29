package sw.practice.FileOperation;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        FileOperation fileOperation = new FileOperation();
        //create file or directory
//        FileOperation.createFile("/home/swyoung/Desktop/hhh");
//        FileOperation.createDirectory("/home/swyoung/Desktop/hhhhh");
        File file = new File("/home/swyoung/Desktop/jiujiu");
        System.out.println(file.getParent());

        StringBuffer stringBuffer = new StringBuffer();
        FileReader fileReader = new FileReader(file);
        char[] s = new char[(int) file.length()];
        fileReader.read(s);
        for (char c:s
             ) {
            stringBuffer.append(c);
        }
        System.out.println(stringBuffer);
        System.out.println("--------------------");

        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write("ssssfaivnasdvasoivdsovidvi avid我因笑\n");
        fileWriter.flush();
        fileWriter.close();

        s = new char[(int) file.length()];
        fileReader.read(s);
        fileReader.close();
        for (char c:s
        ) {
            if (c!=0){
                stringBuffer.append(c);
            }
        }
        System.out.println(stringBuffer);
        System.out.println("--------------------");



        //delete file or directory
//        FileOperation.deleteFile("/home/swyoung/Desktop/hhh");
//        FileOperation.deleteDirectory("/home/swyoung/Desktop/hhhhh");
//        FileOperation.deleteDirectorys("/home/swyoung/Desktop/jiu");

        //read file
        System.out.println(FileOperation.readFileByBytes("/home/swyoung/Desktop/jiujiu"));
//        System.out.println(FileOperation.readFileByChars("/home/swyoung/Desktop/jiujiu"));
//        System.out.println(FileOperation.readFileByLines("/home/swyoung/Desktop/jiujiu"));

//        //write to file
//        FileOperation.writeFileByFileOutputStream("/home/swyoung/Desktop/jiujiu", "11111");
//        FileOperation.writeFileByFileWriter("/home/swyoung/Desktop/jiujiu", "2222222");
    }
}
