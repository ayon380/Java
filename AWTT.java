import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class f1 extends Frame {
    String str;

    f1(String s) {
        str = s;
    }
}

class Win extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

public class AWTT {
    public static void main(String args[]) {
        f1 f = new f1("Hello");
        f.setVisible(true);
        f.setSize(500, 300);
        f.addWindowListener(new Win());
    }
}
