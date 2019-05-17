package forfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author BORBER
 */

public class DoFile {

    public static boolean creatFile(String filepath){
        /**
         *@title creatFile
         * @description 创建文件
         * @author admin
         * @param: filepath
         * @updateTime 2019/5/17 15:42
         * @return: boolean
         * @throws IOException
         */

        File file = new File(filepath);
        if(!file.exists()){
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("File is already exists,so I can't creat it.");
        }
        return false;
    }

    public static boolean createDirectory(String directory){
        /**
         * @title createDirectory
         * @description 创建文件夹
         * @author admin
         * @param: directory
         * @updateTime 2019/5/17 15:44
         * @return: boolean
         * @throws
         */

        File file = new File(directory);
        if(!file.exists()){
            return file.mkdir();
        }else {
            System.out.println("Directory is already exists, so I can't creat it.");
        }
        return false;
    }

    public static boolean deleteFiles(String filepath){
        /**
         * @title deleteFiles
         * @description 删除文件
         * @author admin
         * @param: filepath
         * @updateTime 2019/5/17 15:44
         * @return: boolean
         * @throws
         */

        File file = new File(filepath);
        if(file.exists() && file.isFile()){
            return file.delete();
        }else {
            System.out.println("File is not exists or it is not a file, so I can't delete it.");
        }
        return false;
    }

    public static boolean deleteDirectory(String filepath){
        /**
         * @title deleteDirectory
         * @description 删除文件夹 并且 递归删除其下的所有文件及文件夹
         * @author admin
         * @param: filepath
         * @updateTime 2019/5/17 15:44
         * @return: boolean
         * @throws
         */
        File file = new File(filepath);
        if(!file.exists()){
            System.out.println("File if not exists so I can't delete it.");
            return false;
        }
        if(file.isFile()){
            return file.delete();
        }else if (file.isDirectory()){
            File[] files = file.listFiles();
            for(File myfile : files){
                deleteDirectory(filepath + "/" +myfile.getName());
            }
            return file.delete();
        }
        return false;
    }

    public static String readFileByBytes(String filepath){
        /**
         * @title readFileByBytes
         * @description 以字节为单位读取文件 一般用于二进制文件
         * @author admin
         * @param: filepath
         * @updateTime 2019/5/17 15:45
         * @return: java.lang.String
         * @throws IOException
         */

        File file = new File(filepath);
        if(!file.exists() || !file.isFile()){
            System.out.println("File is not exists or it is not a file,so I can't read it.");
            return null;
        }
        StringBuffer content = new StringBuffer();
        try {
            byte[] tmp = new byte[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            while (fileInputStream.read(tmp) != -1){
                content.append(new String(tmp));
                tmp = new byte[1024];
            }
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static String readFileByChars(String filepath){
        /**
         * @title readFileByChars
         * @description 以字符为单位读取文件 一般用于文本文件
         * @author admin
         * @param: filepath
         * @updateTime 2019/5/17 15:45
         * @return: java.lang.String
         * @throws IOException
         */

        File file = new File(filepath);
        if(!file.exists() || !file.isFile()){
            System.out.println("File is not exists or it is not a file,so I can't read it.");
            return null;
        }
        StringBuffer content = new StringBuffer();
        try {
            char[] tmp = new char[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"GBK");
            while (inputStreamReader.read(tmp) != -1){
                content.append(new String(tmp));
                tmp = new char[1024];
            }
            fileInputStream.close();
            inputStreamReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static List<String> readFileByLine(String filepath){
        /**
         * @title readFileByLine
         * @description 以行为单位读取文件 一般用于 各行独立的文件
         * @author admin
         * @param: filepath
         * @updateTime 2019/5/17 15:49
         * @return: java.util.List<java.lang.String>
         * @throws IOException
         */

        File file = new File(filepath);
        if(!file.exists() || !file.isFile()){
            System.out.println("File is not exists or it is not a file,so I can't read it.");
            return null;
        }
        List<String> content = new ArrayList<String>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"GBK");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String lineContent = "";
            while ((lineContent = reader.readLine()) != null){
                content.add(lineContent);
                System.out.println(lineContent);
            }
            fileInputStream.close();
            inputStreamReader.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  content;
    }

    public static void writeFileByFileWriter(String filePath,String content) throws IOException{
        /**
         * @title writeFileByFileWriter
         * @description 字符串写入文件的几个类中，FileWriter效率最高，BufferedOutputStream次之，FileOutputStream最差
         * 故而只使用Writer
         * @author admin 
         * @param: filePath
         * @param: content
         * @updateTime 2019/5/17 16:04 
         * @throws IOException
         */
        File file = new File(filePath);
        synchronized (file){
            FileWriter fw = new FileWriter(filePath);
            fw.write(content);
            fw.close();
        }
    }
}
