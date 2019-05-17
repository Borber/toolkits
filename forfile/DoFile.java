package forfile;

import java.io.File;
import java.io.IOException;

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
        }
        return false;
    }
    public static boolean createDirectory(String directory){
        File file = new File(directory);
        if(!file.exists()){
            return file.mkdir();
        }
        return false;
    }

    public static boolean deleteFiles(String filepath){
        File file = new File(filepath);
        if(file.exists() && file.isFile()){
            return file.delete();
        }
        return false;
    }

    public static boolean deleteDirectory(String filepath){
        File file = new File(filepath);
        if(!file.exists()){
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

}
