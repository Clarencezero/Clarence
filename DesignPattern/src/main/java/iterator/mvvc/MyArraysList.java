package iterator.mvvc;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArraysList<E> implements List<E> {
    // 初始化容量大小
    private static final int DEFAULT_CAPACITY = 10;
    // 使用数组存储元素
    private Object[] elementData;
    // 存放元素添加时间戳
    private long[] addTimeStamp;
    // 存放元素删除时间戳
    private long[] deleteTimeStamp;
    // 集合总大小(包含被删除元素、元素并未进行删除，只是删除动作修改了deleteTimeStamp时间戳)
    private int totalSize;
    // 集合实际大小
    private int actualSize;

    public MyArraysList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.addTimeStamp = new long[DEFAULT_CAPACITY];
        this.deleteTimeStamp = new long[DEFAULT_CAPACITY];
        this.totalSize = 0;
        this.actualSize = 0;
    }

    public MyArraysList(int size) {
        this.elementData = new Object[size];
        this.addTimeStamp = new long[size];
        this.deleteTimeStamp = new long[size];
        this.totalSize = 0;
        this.actualSize = 0;
    }

    @Override
    public boolean add(E e) {
        elementData[totalSize] = e;
        addTimeStamp[totalSize] = System.currentTimeMillis();
        deleteTimeStamp[totalSize] = Long.MAX_VALUE;
        actualSize++;
        totalSize++;
        return true;
    }

    /**
     * 元素删除动作
     * 1.将deleteTimeStamp相应的数组序号置为当前时间
     * 2.实际元素统计值actualSize减一
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < totalSize; i++) {
            if (elementData[i].equals(o)) {
                deleteTimeStamp[i] = System.currentTimeMillis();
                actualSize--;
            }
        }
        return true;
    }

    /**
     * 创建一个新的迭代器
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new SnapshotArrayIteraotr(System.currentTimeMillis());
    }

    private class SnapshotArrayIteraotr<E> implements Iterator<E> {
        // 创建迭代器时间戳
        private long snapshotTimestap;
        // 当前游标位置
        private int cursor;

        public SnapshotArrayIteraotr(long snapshotTimestap) {
            this.snapshotTimestap = snapshotTimestap;
            this.cursor = 0;
        }

        /**
         * 是否还有下一个元素
         * @return
         */
        @Override
        public boolean hasNext() {
            return cursor <= totalSize;
        }

        /**
         * 有两个步骤
         * 1.获取cursor游标的值
         * 2.找寻下一个游标位置
         * @return
         */
        @Override
        public E next() {
            E result =(E) elementData[cursor];
            jumpToNextCursor();
            return result;
        }

        /**
         * 找寻下一个可用的游标
         */
        private void jumpToNextCursor() {
            while (cursor++ < totalSize) {
                long addTime = addTimeStamp[cursor];
                long deleteTime = deleteTimeStamp[cursor];
                if (snapshotTimestap >= addTime && snapshotTimestap < deleteTime) {
                    // 在这个时间范围内的
                    break;
                }
            }
        }
    }





    @Override
    public int size() {
        return actualSize;
    }

    @Override
    public boolean isEmpty() {
        return actualSize == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }





    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
