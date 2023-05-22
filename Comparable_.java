import java.util.TreeSet;

class Container implements Comparable<Container> {
    int x;

    Container(int x) {
        this.x = x;
    }

    @Override
    public int compareTo(Container x) {
        if (this.x > x.x)
            return 1;
        else if (this.x < x.x)
            return -1;
        else
            return 0;

    }
}

public class Comparable_ {
    public static void main(String args[]) {
        TreeSet<Container> t = new TreeSet<>();
        t.add(new Container(1));

        t.add(new Container(4));
        t.add(new Container(2));
        t.add(new Container(7));
        for (Container e : t) {
            System.out.println(e.x);
        }
    }
}
