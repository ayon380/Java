import java.util.HashMap;

public class HashMap_ {
    public static void main(String args[])
    {
        HashMap<Integer,Integer> h=new HashMap<>();
        h.put(8,1);
        h.put(1,2);
        System.out.print(h);
        h.remove(8);
        h.replace(1, 9) ;
        System.out.print(h);
    }
}
