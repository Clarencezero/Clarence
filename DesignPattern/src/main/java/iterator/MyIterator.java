package iterator;


public interface MyIterator<E> {
    /**
     * 判断是否有下一个元素
     * @return
     */
    boolean hasNext();

    /**
     * 迭代器内部指针+1动作
     */
    void next();

    /**
     * 返回当前元素
     * @return
     */
    E currentItem();
}
