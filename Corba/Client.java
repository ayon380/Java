import org.omg.CORBA.*;

public class MyClient {

    public static void main(String[] args) {
        try {
            // Initialize the ORB
            ORB orb = ORB.init();

            // Get a reference to the root naming context
            org.omg.CosNaming.NamingContext rootContext = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

            // Create a name for the server object
            org.omg.CosNaming.NameComponent[] name = new org.omg.CosNaming.NameComponent[1];
            name[0] = new org.omg.CosNaming.NameComponent("MyServer", "");

            // Resolve the name to a reference to the server object
            org.omg.CORBA.Object obj = rootContext.resolve(name);

            // Narrow the reference to the correct type
            MyServer server = MyServerHelper.narrow(obj);

            // Call the server object's hello_world() operation
            String message = server.hello_world();

            // Print the message
            System.out.println(message);

            // Shutdown the ORB
            orb.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
