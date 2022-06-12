package iterator;


import java.util.ArrayList;

public class T {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        name.add("jjj");
        name.add("zwf");
        name.add("xxx");

        name.iterator().forEachRemaining(u -> {
            System.out.println(u);
        });

        int i = 1;
        System.out.println(i++);

        // MyIterator<String> iterator = new ArrayIterator<>(name);
        // while (iterator.hasNext()) {
        //     System.out.println(iterator.currentItem());
        //     iterator.next();
        // }
    }
}
