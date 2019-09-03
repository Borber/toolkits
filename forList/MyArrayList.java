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
    private int[] theItems;

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
    public int get(int idx){
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
    public int set(int idx,int newVal){
        if(idx < 0||idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        int old = theItems[idx];
        theItems[idx] = newVal;
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
        int[] old = theItems;
        theItems = new int[newCapacity];
        if (size() >= 0) {
            System.arraycopy(old, 0, theItems, 0, size());
        }
    }

    public boolean add(int x){
        add( size(), x);
        return true;
    }

    /**
    * @Description: 通过下标插入 下标小于 0 默认为0 大于队列长度 默认为队列末端
    * @Param: [idx, x]
    * @return: void
    * @Author: BORBER
    * @Date: 2019/9/3
    */
    public void add(int idx, int x){
        x = x<0?0:Math.min(x, size());
        if(theItems.length == size()){
            ensureCapacity(size()+DEFAULT_CAPACITY);
        }
        if (size() - idx >= 0) {
            System.arraycopy(theItems, idx, theItems, idx + 1, size() - idx);
        }
        theItems[idx] = x;
        ++theSize;
    }

    /**
    * @Description: 通过下标 删除元素
    * @Param: [idx]
    * @return: int
    * @Author: BORBER
    * @Date: 2019/9/3
    */
    public int remove(int idx){
        if (idx < 0||idx >size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        int removedItem = theItems[idx];
        if (size() - 1 - idx >= 0) {
            System.arraycopy(theItems, idx + 1, theItems, idx, size() - 1 - idx);
        }
        --theSize;
        return removedItem;
    }

    public java.util.Iterator<Integer> iterator(){
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<Integer>{

        private int current = 0;
        @Override
        public boolean hasNext() {
            return current<size();
        }

        @Override
        public Integer next() {
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
