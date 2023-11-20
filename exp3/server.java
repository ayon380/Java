import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketOptions;

public class Server {
  public static void main(String[] args) {
    // Create a server socket on port 12345
    try (ServerSocket serverSocket = new ServerSocket(12345)) {
      System.out.println("Server is listening on port 12345");
      
      // Set some socket options
      
      serverSocket.setOption(SocketOptions.SO_KEEPALIVE, true);
      serverSocket.setOption(SocketOptions.SO_LINGER, new Integer(10));
      serverSocket.setOption(SocketOptions.SO_SNDBUF, new Integer(8192));
      serverSocket.setOption(SocketOptions.SO_RCVBUF, new Integer(8192));
      serverSocket.setOption(SocketOptions.TCP_NODELAY, true);
      
      // Get and print the current values of the options
      System.out.println("SO_KEEPALIVE: " + serverSocket.getOption(SocketOptions.SO_KEEPALIVE));
      System.out.println("SO_LINGER: " + serverSocket.getOption(SocketOptions.SO_LINGER));
      System.out.println("SO_SNDBUF: " + serverSocket.getOption(SocketOptions.SO_SNDBUF));
      System.out.println("SO_RCVBUF: " + serverSocket.getOption(SocketOptions.SO_RCVBUF));
      System.out.println("TCP_NODELAY: " + serverSocket.getOption(SocketOptions.TCP_NODELAY));
      
      // Accept an incoming connection from a client socket
      Socket clientSocket = serverSocket.accept();
      System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
      
      // Handle the client communication in a separate thread
      new ClientHandler(clientSocket).start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
