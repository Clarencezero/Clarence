package iterator;

import java.util.ArrayList;

public class ArrayIterator<E> implements MyIterator {
    private int cursor;
    private ArrayList<E> arrayList;

    public ArrayIterator(ArrayList<E> arrayList) {
        this.cursor = 0;
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        return cursor != arrayList.size();
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public Object currentItem() {
        return  arrayList.get(cursor);
    }
}
