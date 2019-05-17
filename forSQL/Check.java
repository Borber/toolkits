package forSQL;

import java.sql.SQLException;
import java.util.concurrent.ConcurrentNavigableMap;

import static forSQL.SQL_Constants.*;

/**
 * @author BORBER
 * @version 1.0.0
 * @ClassName Check.java
 * @Description TODO
 * @createTime 2019年05月17日 17:38
 */
public class Check {

    public static boolean checkLogin(String sql,String name,String password){

        /**
         * @title checkLogin
         * @description 用于一系列的登录检测
         * @author BORBER
         * @param: sql
         * @param: name
         * @param: password
         * @updateTime 2019/5/17 17:50
         * @return: boolean
         * @throws SQLException
         */

        try {
            PST = CONN.prepareStatement(sql);
            PST.setString(1,name);
            PST.setString(2,password);
            RS = PST.executeQuery();
            return RS.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
