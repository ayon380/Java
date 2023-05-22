import java.util.TreeMap;

public class TreeMap_ {
    public static void main(String args[])
    {
        TreeMap<Integer,Integer> t=new TreeMap();
        t.put(8,1);
        t.put(1,2);
        System.out.print(t);
        t.remove(8);
        t.replace(1, 9) ;
        System.out.print(t);
    }
}
