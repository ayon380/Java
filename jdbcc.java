import java.sql.*;
public class jdbcc{
    public static void main(String args[]) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost/test");
        Statement s=c.createStatement();
        ResultSet r=s.executeQuery ("select firstName, mi, lastName from Student where lastName "
        + " = 'Smith'");
        while(r.next()){
            System.out.println(r.getString(0));
        }


    }
}