package forList;

/**
 * @program: MyArrayList
 * @description: 用来实现ArrayList
 * @author: BORBER
 * @create: 2019-09-03 15:47
 * @version: 1.0
 **/
public class MyArrayList {
    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;



    static class Doub{
        int modulus;
        int index;
        Doub(int modulus,int index){
            this.modulus = modulus;
            this.index = index;
        }
    }

    private Doub[] theItems;
//    private int[] theItems;

    /**
     * @Description: 通过调用 doClear() 创造列表数组
     * @Author: BORBER
     * @Date: 2019/9/3
     */
    public MyArrayList(){
        doClear();
    }

    /**
     * @Description: 通过调用 doClear() 更新列表数组
     * @return: void
     * @Author: BORBER
     * @Date: 2019/9/3
     */
    public void clear(){
        doClear();
    }

    /**
     * @Description: 通过调用 ensureCapacity 清零列表长度 返回新的队列
     * @return: void
     * @Author: BORBER
     * @Date: 2019/9/3
     */
    private void doClear(){
        theSize = 0; ensureCapacity( DEFAULT_CAPACITY);
    }

    /**
     * @Description: 返回列表元素个数
     * @return: int
     * @Author: BORBER
     * @Date: 2019/9/3
     */
    public int size(){
        return theSize;
    }

    /**
     * @Description: 返回列表是否为空
     * @return: boolean
     * @Author: BORBER
     * @Date: 2019/9/3
     */
    public boolean isEmpty(){
        return size() == 0;
    }

    /**
     * @Description: 去除多余的列表数组空间
     * @return: void
     * @Author: BORBER
     * @Date: 2019/9/3
     */
    public void trimToSize(){

    }

    /**
     * @Description: 通过下标进行列表查询
     * @Param: [idx]
     * @return: int
     * @Author: BORBER
     * @Date: 2019/9/3
     */
    public Doub get(int idx){
        if(idx < 0||idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    /**
     * @Description: 通过下标进行元素赋值 并返回旧值
     * @Param: [idx, newVal]
     * @return: int
     * @Author: BORBER
     * @Date: 2019/9/3
     */
    public Doub set(int idx,int a,int b){
        if(idx < 0||idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        Doub old = theItems[idx];
        theItems[idx] = new Doub(a, b);
        return old;
    }

    /**
     * @Description: 更新列表数组
     * @Param: [newCapacity]
     * @return: void
     * @Author: BORBER
     * @Date: 2019/9/3
     */
    public void ensureCapacity(int newCapacity){
        if(newCapacity < theSize){
            return;
        }
        Doub[] old = theItems;
        theItems = new Doub[newCapacity];
        if (size() > 0) {
            System.arraycopy(old, 0, theItems, 0, size());
        }
    }

    public boolean add(int a,int b){
        add( size(), a, b);
        return true;
    }

    /**
     * @Description: 通过下标插入 下标小于 0 默认为0 大于队列长度 默认为队列末端
     * @Param: [idx, x]
     * @return: void
     * @Author: BORBER
     * @Date: 2019/9/3
     */
    public void add(int idx, int a, int b){
        idx = idx<0?0:Math.min(idx, size());
        if(theItems.length == size()){
            ensureCapacity(size()+DEFAULT_CAPACITY);
        }
        if (size() - idx >= 0) {
            System.arraycopy(theItems, idx, theItems, idx + 1, size() - idx);
        }
        theItems[idx] = new Doub(a, b);
        ++theSize;
    }

    /**
     * @Description: 通过下标 删除元素
     * @Param: [idx]
     * @return: int
     * @Author: BORBER
     * @Date: 2019/9/3
     */
    public Doub remove(int idx){
        if (idx < 0||idx >size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        Doub removedItem = theItems[idx];
        if (size() - 1 - idx >= 0) {
            System.arraycopy(theItems, idx + 1, theItems, idx, size() - 1 - idx);
        }
        --theSize;
        return removedItem;
    }


    /**
     * @Description: 返回迭代器
     * @return: java.util.Iterator<java.lang.Integer>
     * @Author: BORBER
     * @Date: 2019/9/3
     */
    public java.util.Iterator<Doub> iterator(){
        return new MyArrayList.ArrayListIterator();
    }


    /**
     * @Description: 迭代器接口
     * @return:
     * @Author: BORBER
     * @Date: 2019/9/3
     */
    private class ArrayListIterator implements java.util.Iterator<Doub>{

        private int current = 0;
        @Override
        public boolean hasNext() {
            return current<size();
        }

        @Override
        public Doub next() {
            if (!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
