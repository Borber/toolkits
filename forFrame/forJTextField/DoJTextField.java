package forFrame.forJTextField;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.io.BufferedReader;
import java.util.Scanner;

/**
 * @author BORBER
 * @version 1.0.0
 * @ClassName DoJTextField.java
 * @Description 对输入框进行的操作
 * @createTime 2019年05月17日 17:22
 */
public class DoJTextField {

    /**
     * 限制字符的长度
     * 使用方法 JTextField.setDocument(new JTextFieldLimit(n)); n 为整数
     * @author BORBER
     */
    public class JTextFieldLimit extends PlainDocument {
        private int limit;
        public JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        JTextFieldLimit(int limit, boolean upper) {
            super();
            this.limit = limit;
        }
        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) {
                return;
            }

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }




}
