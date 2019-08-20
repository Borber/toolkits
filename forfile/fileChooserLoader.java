package forfile;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * @program: fileChooserLoader
 * @description: 打开文件选择器 返回相应目录
 * @author: BORBER
 * @create: 2019-08-17 21:10
 * @version: 1.0
 **/
public class fileChooserLoader extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(final Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG (*.png)", "*.*");
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialDirectory(new File("D:\\File\\SS"));
        File file = fileChooser.showSaveDialog(primaryStage);
        System.out.println(file);
    }

}
