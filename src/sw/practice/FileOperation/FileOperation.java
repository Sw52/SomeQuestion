package sw.practice.FileOperation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileOperation {
    /**
     * create a file
     *
     * @param filePath
     * @return
     */
    public static boolean createFile(String filePath) {    //the String you named is filePath + fileName
        boolean result = false;
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                result = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Delete the file
     *
     * @param filePath
     * @return
     */
    public static boolean deleteFile(String filePath) {
        boolean result = false;
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            result = file.delete();
        }
        return result;
    }

    /**
     * create a Directory
     *
     * @param directoryPath
     * @return
     */
    public static boolean createDirectory(String directoryPath) { //the String you named is directoryPath + directoryName
        boolean result = false;
        File file = new File(directoryPath);
        if (!file.exists())
            result = file.mkdir();
        return result;
    }

    /**
     * Delete the Directory
     *
     * @param directoryPath
     * @return
     */
    public static boolean deleteDirectory(String directoryPath) {
        boolean result = false;
        File file = new File(directoryPath);
        if (file.exists() && file.isDirectory())
            result = file.delete();
        return result;
    }

    /**
     * Delete the Directory and the file or directory in it
     *
     * @param directoryPath
     * @return
     */
    public static void deleteDirectorys(String directoryPath) {
        boolean result = false;
        File file = new File(directoryPath);
        if (!file.exists())
            return;
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File fileToDelete : files) {
                deleteDirectorys(directoryPath + "/" + fileToDelete.getName());
            }
            file.delete();
        }
    }

    /**
     * read file by bytes
     *
     * @param filePath
     * @return
     */
    public static String readFileByBytes(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            return null;
        }

        StringBuffer content = new StringBuffer();

        try {
            byte[] temp = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(temp);
            content.append(temp);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    /**
     * read file by char
     *
     * @param filePath
     * @return
     */
    public static String readFileByChars(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile())
            return null;
        StringBuffer content = new StringBuffer();

        try {
            char[] temp = new char[(int) file.length()]; //attention! if the file is too long ex of the range od int maybe error
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            inputStreamReader.read(temp);
            content.append(temp);
            fileInputStream.close();
            inputStreamReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    /**
     * read file by line
     *
     * @param filePath
     * @return
     */
    public static List<String> readFileByLines(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            return null;
        }

        List<String> content = new ArrayList<String>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String lineContent = "";
            while ((lineContent = reader.readLine()) != null) {
                content.add(lineContent);
                System.out.println(lineContent);
            }

            fileInputStream.close();
            inputStreamReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    /**
     * @param filePath
     * @param content
     * @throws IOException
     * @see write to file
     */
    public static void writeFileByFileOutputStream(String filePath, String content) throws IOException {
        File file = new File(filePath);
        synchronized (file) {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
            fileOutputStream.write(content.getBytes("GBK"));
            fileOutputStream.close();
        }
    }

    /**
     * write to file
     *
     * @param filePath
     * @param content
     * @throws IOException
     */
    public static void writeFileByFileWriter(String filePath, String content) throws IOException {
        File file = new File(filePath);
        synchronized (file) {
            FileWriter fw = new FileWriter(filePath, true);//the second parameter is make the contents append to the end of file
            fw.write(content);
            fw.close();
        }
    }
}