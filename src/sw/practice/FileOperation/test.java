package sw.practice.FileOperation;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        FileOperation fileOperation = new FileOperation();
        //create file or directory
//        FileOperation.createFile("/home/swyoung/Desktop/hhh");
//        FileOperation.createDirectory("/home/swyoung/Desktop/hhhhh");

        //delete file or directory
//        FileOperation.deleteFile("/home/swyoung/Desktop/hhh");
//        FileOperation.deleteDirectory("/home/swyoung/Desktop/hhhhh");
//        FileOperation.deleteDirectorys("/home/swyoung/Desktop/jiu");

        //read file
        System.out.println(FileOperation.readFileByBytes("/home/swyoung/Desktop/jiujiu"));
//        System.out.println(FileOperation.readFileByChars("/home/swyoung/Desktop/jiujiu"));
//        System.out.println(FileOperation.readFileByLines("/home/swyoung/Desktop/jiujiu"));

        //write to file
        FileOperation.writeFileByFileOutputStream("/home/swyoung/Desktop/jiujiu", "11111");
        FileOperation.writeFileByFileWriter("/home/swyoung/Desktop/jiujiu", "2222222");
    }
}
