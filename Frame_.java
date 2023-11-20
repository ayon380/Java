// import java.awt.*;
// public class Frame_ {
//     public static void main(String args[]) {
//         Frame f= new Frame("Windows 11");
//         f.setSize(1000,1000 );
//         f.setVisible(true);
//     }
// }

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Frame_ extends Frame {
    Frame_(String str) {
        super(str);
    }
    public static void main(String args[])
    {
        Frame_ f=new Frame_("Ayon");
        f.setSize(100,100 );
        f.setVisible(true);
        f.addWindowListener(new MyClass());
    }
}
class MyClass extends WindowAdapter{
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}