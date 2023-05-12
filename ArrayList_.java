import java.util.*;

public class ArrayList_ {
    public static void main(String args[]) {
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        System.out.println(arr2);
        arr2.add(4);
        arr.add(3);
        arr.add(8);
        arr2.add(6);
        arr2.add(1, 4);
        arr2.addAll(1, arr);
        System.out.println(arr2.get(2));
        System.out.println(arr2.contains(9));
        arr2.forEach((n) -> System.out.println(n * n));
        System.out.println(arr2.get(2));
        System.out.println(arr2.indexOf(4));
        System.out.println(arr2.isEmpty());
        ListIterator<Integer> itr = arr2.listIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println(arr2.remove(2));
        System.out.println(arr2.size());
    }
}
