import java.io.File;

public class FileClass {
    public static void main(String args[])
    {
        try{
            File f=new File("C:\\Users\\ayons\\OneDrive\\Github\\Programming\\Java");
            System.out.println(f.exists());
            System.out.println(f.createNewFile());
            System.out.println(f.exists());
            System.out.println(f.getName());
            System.out.println(f.getAbsolutePath());
            System.out.println(f.getParent());
            System.out.println(f.canRead());
            System.out.println(f.canWrite());
            System.out.println(f.isDirectory());
            System.out.println(f.isFile());
            System.out.println(f.isHidden());
            System.out.println(f.lastModified());
            System.out.println(f.length());
            System.out.println(f.delete());
            System.out.println(f.getTotalSpace()/1024/1024/1024);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
