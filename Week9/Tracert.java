package Week9;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tracert {
    public static void main(String[] args) {
        String host = "google.com"; // Change to the host you want to trace-route

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("tracert", host);
            Process process = processBuilder.start();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
