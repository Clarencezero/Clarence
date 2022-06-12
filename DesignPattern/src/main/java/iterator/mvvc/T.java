package iterator.mvvc;

import iterator.mvvc.MyArraysList;

import java.util.Iterator;

public class T {
    public static void main(String[] args) throws Exception{
        MyArraysList<String> myArraysList = new MyArraysList();
        myArraysList.add("A");
        myArraysList.add("B");
        myArraysList.add("C");
        myArraysList.add("D");

        Iterator<String> iterator = myArraysList.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        myArraysList.remove("B");

        Iterator<String> iterator2 = myArraysList.iterator();

        while(iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }


        myArraysList.remove("C");
        Iterator<String> iterator3 = myArraysList.iterator();

        while(iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }

        myArraysList.add("E");
        Iterator<String> iterator4 = myArraysList.iterator();

        while(iterator4.hasNext()) {
            System.out.println(iterator4.next());
        }

    }
}
