package forfile;

import java.io.*;

/**
 * @author BORBER
 *
 */
public class DoFile {

    public static boolean creatFile(String filepath){
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
        File file = new File(directory);
        if(!file.exists()){
            return file.mkdir();
        }else {
            System.out.println("Directory is already exists, so I can't creat it.");
        }
        return false;
    }

    public static boolean deleteFiles(String filepath){
        File file = new File(filepath);
        if(file.exists() && file.isFile()){
            return file.delete();
        }else {
            System.out.println("File is not exists or it is not a file, so I can't delete it.");
        }
        return false;
    }

    public static boolean deleteDirectory(String filepath){
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
}
