import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDeque_ {
    public static void main(String args[]) {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        arr.offerLast(6);
        arr.offerFirst(9);
        arr.forEach((x)->System.out.println(x*x));
        arr.offerLast(10);
        System.out.println(arr);
        Iterator<Integer> namesIterator = arr.iterator();
        while(namesIterator.hasNext()) {
            System.out.print(namesIterator.next());
        }
    }
}
