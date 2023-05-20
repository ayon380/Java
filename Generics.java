import java.util.ArrayList;

class type<t>{
    ArrayList<t> arr=new ArrayList();
    public void append(t a)
    {
        arr.add(a);
    }
    public void display()
    {
        for(T i : arr)
        {
            System.out.println(i);
        }
    }
}
public class Generics {
    public static void main(String args[])
    {
        type<String> q=new type();
        q.append("qwere");
        q.append("3wqe");
        q.display();
    }
}
