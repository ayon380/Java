package javaRMI;


import java.rmi.*;
import java.rmi.server.*;
public class SearchQuery extends UnicastRemoteObject implements Search {
    SearchQuery() throws RemoteException {
        super();
    }
    public String query(String search)
            throws RemoteException {
        String result;
        if (search.equals("RMI"))
            result = "Found";
        else
            result = "Not Found";

        return result;
    }
}
