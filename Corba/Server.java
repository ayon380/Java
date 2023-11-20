import org.omg.CORBA.*;

public class MyServerImpl extends org.omg.CORBA.portable.ServantObject implements MyServer {

    public String hello_world() {
        return "Hello, world!";
    }

    public static void main(String[] args) {
        try {
            // Initialize the ORB
            ORB orb = ORB.init();

            // Register the server object with the ORB
            org.omg.CORBA.Object obj = orb.register_object(new MyServerImpl());

            // Get a reference to the root naming context
            org.omg.CosNaming.NamingContext rootContext = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

            // Create a name for the server object
            org.omg.CosNaming.NameComponent[] name = new org.omg.CosNaming.NameComponent[1];
            name[0] = new org.omg.CosNaming.NameComponent("MyServer", "");

            // Bind the server object to the name
            rootContext.bind(name, obj);

            // Start the ORB
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
