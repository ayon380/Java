import java.io.*;
import java.net.*;
import java.io.IOException;

// The base class for all layers
class Layer {
    public void send(String data, int port) throws IOException {
        // Common implementation for sending data
        try (Socket socket = new Socket("localhost", port)) {
            OutputStream out = socket.getOutputStream();
            out.write(data.getBytes());
        }
    }

    public String receive(int port) throws IOException {
        // Common implementation for receiving data
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                data.append(line);
            }
            return data.toString();
        }
    }
}

// Transport Layer
class TransportLayer extends Layer {
    public void sendData(String data, int port) throws IOException {
        // Implement transport layer-specific data sending logic
        send(data, port);
    }

    public String receiveData(int port) throws IOException {
        // Implement transport layer-specific data receiving logic
        return receive(port);
    }
}

// Network Layer
class NetworkkLayer extends Layer {
    public void routeData(String data, int port) throws IOException {
        // Implement network layer-specific data routing logic
        send(data, port);
    }

    public String processData(int port) throws IOException {
        // Implement network layer-specific data processing logic
        return receive(port);
    }
}

// Data Link Layer
class DataLinkLayer extends Layer {
    public void transmitData(String data, int port) throws IOException {
        // Implement data link layer-specific data transmission logic
        send(data, port);
    }

    public String receiveData(int port) throws IOException {
        // Implement data link layer-specific data reception logic
        return receive(port);
    }
}

// Physical Layer
class PhysicalLayer extends Layer {
    public void sendSignal(String signal, int port) throws IOException {
        // Implement physical layer-specific signal sending logic
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName("localhost");
            byte[] data = signal.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            socket.send(packet);
        }
    }

    public String receiveSignal(int port) throws IOException {
        // Implement physical layer-specific signal receiving logic
        try (DatagramSocket socket = new DatagramSocket(port)) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            return new String(packet.getData(), 0, packet.getLength());
        }
    }
}

// Example usage


public class Network {
    public static void main(String[] args) throws IOException {
        // Create instances of all layers
        TransportLayer transportLayerA = new TransportLayer();
        TransportLayer transportLayerB = new TransportLayer();
        TransportLayer transportLayerC = new TransportLayer();
        TransportLayer transportLayerD = new TransportLayer();
        
        
        // Node A sends data to Node B
        String dataFromAtoB = "Data from Node A to Node B";
        transportLayerA.sendData(dataFromAtoB, 8080);

        // Node B receives data from Node A and forwards it to Node C
        String receivedDataAtB = transportLayerB.receiveData(8080);
        transportLayerC.sendData(receivedDataAtB, 8081);

        // Node C receives data from Node B and forwards it to Node D
        String receivedDataAtC = transportLayerC.receiveData(8081);
        transportLayerD.receiveData( 8082);

        // Node D receives data from Node C
        String dataReceivedAtD = transportLayerD.receiveData(8082);

        System.out.println("Data received at Node D: " + dataReceivedAtD);
    }
}
