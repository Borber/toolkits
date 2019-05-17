package forFrame.forJTable;

import javax.swing.*;

public class JTableOperation {


    /**
     * 待完成
     */
    public void reloadJTable(String key){
        String[][] rowData = null;
        if(key.length() == 0){
            //rowData = new adminSreachSQL().sreach();
        }else {
            //rowData = new adminSreachSQL().sreach(key);
        }

        JTable table=new JTable(rowData, jTableTitle);
        //GlobalObject.setjTable(table);
        //GlobalObject.getjScrollPane().setViewportView(table);
    }
    private String[] jTableTitle = null;
}

