package forSQL;

import java.sql.*;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SQL_Constants.java
 * @Description 模块化对 SQL 的操作
 * @createTime 2019年05月17日 16:44
 */
public class SQL_Constants {

    /**
     * 连接全局化 节省连接的时间
     * 以及 别的可能使用的变量全局化
     */
    public static Connection CONN = null;

    public static PreparedStatement PST = null;

    public static ResultSet RS = null;



    /**
     * 字符串待填写
     */
    private final static String MYSQL_CLASS = "";
    private final static String MYSQL_URL = "";
    private final static String MYSQL_NAME = "";
    private final static String MYSQL_PASSWORD = "";

    public static void GetConnection(){
        /**
         * @title GetConnection
         * @description
         * @author BORBER
         * @updateTime 2019/5/17 17:10
         * @throws
         */

        try {
            CONN = null;
            Class.forName(MYSQL_CLASS);
            CONN = DriverManager.getConnection(MYSQL_URL,MYSQL_NAME,MYSQL_PASSWORD);
            if(CONN != null){
                System.out.println("Connect success!");
            }
        }catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (SQLException e) {
            System.out.println("Connect fail!");
        }
    }


}
