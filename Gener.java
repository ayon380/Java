import java.util.*;
class es<t,q>{
    t a;
    q b;
    es(t a, q b)
    {
        this.a=a;
        this.b=b;
    }
    void display()
    {
        System.out.println(a+" "+b);
    }
}
public class Gener {
    public static void main(String args[])
    {
        es <Integer,String> d=new es(2,"hel"); 
        d.display();
    }
}
