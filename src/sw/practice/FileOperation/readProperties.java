package sw.practice.FileOperation;

import java.io.*;
import java.util.Properties;

public class readProperties {
    /**
     * 获取配置文件中的参数
     * @param args
     */
    public static void main(String[] args) {
        String name;
        String age;
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream("test.properties"));//加载文件流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        name = properties.getProperty("name");
        age = properties.getProperty("age");
        System.out.println(name+" "+age);
    }
}
