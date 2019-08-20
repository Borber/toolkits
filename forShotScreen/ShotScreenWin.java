package forShotScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.stage.FileChooser;


/**
 * @program: ShotScreenWin
 * @description: 创建一个全屏的窗体，再去掉整个窗体的装饰，即取消关闭，最小/大化，边框，并截取整个屏幕的像素，然后在窗体中显示。最后通过鼠标监听事件，将制定区域的像素保存到桌面。
 * @author: BORBER
 * 借鉴 : 明月依希 "https://blog.csdn.net/Mingyueyixi/article/details/49757829"
 *
 * @create: 2019-08-17 13:17
 * @version: 1.0
 **/

public class ShotScreenWin extends JFrame {

    private static final long serialVersionUID = 1L;
    private Point point_holder, point_release;//按下鼠标时的坐标与释放鼠标后的坐标，依此计算截屏区域

    public ShotScreenWin() {
        //Dimension 类封装单个对象中组件的宽度和高度（精确到整数）
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();//获取整个屏幕大小

        setUndecorated(true);//禁用窗体装饰，不显示标题栏，关闭，最小化等
        setSize(d);//设置窗体全屏
        BufferedImage screenshot = snapShot(0, 0, (int) d.getWidth(), (int) d.getHeight());//缓冲图片数据
        //覆盖窗体的图片标签
        JLabel image_Label = new JLabel(new ImageIcon(screenshot));//根据图片缓冲构造图片，设为标签，使窗体即为全屏幕截图

        add(image_Label);//添加标签
        addMouseListener((MouseListener) new ShotListenerMouse());//鼠标点击监听
        setVisible(true);//设置窗体为可见。默认不可见
    }

    /**
     * @Description: TODO
     * @Param: [point_holder, point_release]
     * @return: 区域截图
     * @Author: BORBER
     * @Date: 2019/8/17
     */
    private void snapShot(Point point_holder, Point point_release) {
//      获取屏幕数据的缓冲流
        BufferedImage screen = snapShot(point_holder.x, point_holder.y, point_release.x - point_holder.x, point_release.y - point_holder.y);

        String formatname = "jpg";//后缀名

//      注释掉对话框方法

        File file = shotDialog();//创建一个新 File 实例
        try {
//          使用支持给定格式的任意 ImageWriter 将一个图像写入 File。如果已经有一个 File 存在，则丢弃其内容
            ImageIO.write(screen, formatname, file);//将图片保存到桌面
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("\r...保存完毕!");

    }

    /**
     * 获取屏幕区域的像素
     *
     * @param i      起始点x坐标
     * @param j      起始点y坐标
     * @param width  到达终点时宽度
     * @param height 到达终点时高度
     * @return 全屏截图
     */
    private BufferedImage snapShot(int i, int j, int width, int height) {
        BufferedImage screenshot = null;
        try {
            screenshot = (new Robot()).createScreenCapture(new
                    Rectangle(i, j, width, height));
        } catch (AWTException e) {
            e.printStackTrace();
        }

        return screenshot;
    }

    private class ShotListenerMouse extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            point_holder = e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

            point_release = e.getPoint();
            snapShot(point_holder, point_release);
            System.exit(0);

        }

    }


    /**
    * @Description: 实现截图时 调出文件管理器
    * @Param: [filename]
    * @return: java.io.File
    * @Author: BORBER
    * @Date: 2019/8/17
    */
    private File shotDialog() {

        FileDialog dialog = new FileDialog(this, "保存", FileDialog.SAVE);

        //设置所打开文件的扩展名
        //设置默认目录

        dialog.setDirectory("D:\\File\\SS");

        //设置可选文件扩展名的显示名称：
        //  javascreen -- jsc
        String filename = "jsc" + System.currentTimeMillis() + ".jpg" ;//设置图片文件名

        dialog.setFile(filename);

        //设置显示到下拉框中的扩展名的名称

        //打开窗口。返回用户所选的文件目录

        //设为可见 默认不可见
        dialog.setVisible(true);


        String file_Path = dialog.getDirectory();
        String file_name = dialog.getFile();
        return new File(file_Path, file_name);
    }
}

